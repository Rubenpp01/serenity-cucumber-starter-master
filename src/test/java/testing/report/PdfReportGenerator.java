package testing.report;

import com.google.gson.*;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.*;

public class PdfReportGenerator {

    private static final String[] POSSIBLE_DIRS = {
            "target/site/serenity",
            "target/serenity"
    };

    private static String REPORTS_DIR;
    private static final String OUTPUT_DIR = "target/site/serenity/pdf-reports";

    public static void main(String[] args) {
        try {
            new PdfReportGenerator().generatePdfReportsByScenario();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void generatePdfReportsByScenario() throws Exception {
        File reportsDir = findReportsDirectory();
        REPORTS_DIR = reportsDir.getAbsolutePath();
        File outputDir = new File(OUTPUT_DIR);
        if (!outputDir.exists()) outputDir.mkdirs();

        File[] jsonFiles = reportsDir.listFiles((dir, name) -> name.toLowerCase().endsWith(".json"));
        if (jsonFiles == null || jsonFiles.length == 0) {
            System.out.println("No se encontraron archivos JSON en: " + REPORTS_DIR);
            return;
        }

        for (File jsonFile : jsonFiles) {
            try (FileReader reader = new FileReader(jsonFile, StandardCharsets.UTF_8)) {
                JsonElement element = JsonParser.parseReader(reader);

                if (element.isJsonArray()) {
                    for (JsonElement e : element.getAsJsonArray()) {
                        if (e.isJsonObject()) generatePdfForScenario(e.getAsJsonObject());
                    }
                } else if (element.isJsonObject()) {
                    generatePdfForScenario(element.getAsJsonObject());
                }
            }
        }

        System.out.println("PDFs generados correctamente en: " + OUTPUT_DIR);
    }

    private File findReportsDirectory() {
        for (String dirPath : POSSIBLE_DIRS) {
            File dir = new File(dirPath);
            if (dir.exists() && dir.isDirectory()) {
                return dir;
            }
        }
        return new File(POSSIBLE_DIRS[0]);
    }

    private void generatePdfForScenario(JsonObject escenario) throws Exception {
        String title = escenario.has("title") ? escenario.get("title").getAsString()
                : escenario.has("name") ? escenario.get("name").getAsString()
                : "Escenario sin título";

        String safeTitle = title.replaceAll("[^a-zA-Z0-9áéíóúÁÉÍÓÚñÑ\\s]", "").trim();
        File pdfFile = new File(OUTPUT_DIR, safeTitle + ".pdf");

        Document document = new Document(PageSize.A4, 36, 36, 54, 36);
        PdfWriter.getInstance(document, new FileOutputStream(pdfFile));
        document.open();

        BaseFont baseFont = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1252, BaseFont.EMBEDDED);
        Font titleFont = new Font(baseFont, 18, Font.BOLD, BaseColor.BLUE);
        Font sectionFont = new Font(baseFont, 14, Font.BOLD);
        Font textFont = new Font(baseFont, 12);
        Font boldBlack = new Font(baseFont, 12, Font.BOLD, BaseColor.BLACK);

        // --- Encabezado ---
        Paragraph titleParagraph = new Paragraph("Serenity Test Report", titleFont);
        titleParagraph.setAlignment(Element.ALIGN_CENTER);
        document.add(titleParagraph);
        document.add(Chunk.NEWLINE);

        String fecha = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
        document.add(new Paragraph("Generado: " + fecha, textFont));
        document.add(Chunk.NEWLINE);

        // --- Escenario ---
        document.add(new Paragraph("Escenario:", sectionFont));
        document.add(new Paragraph(title, textFont));
        document.add(Chunk.NEWLINE);

        // --- Buscar primer bloque de datos {...} y mostrarlo ---
        JsonArray steps = null;
        if (escenario.has("testSteps")) steps = escenario.getAsJsonArray("testSteps");
        else if (escenario.has("steps")) steps = escenario.getAsJsonArray("steps");

        if (steps != null) {
            JsonObject firstStepWithData = findFirstStepWithData(steps);
            if (firstStepWithData != null) {
                addTableFromStep(document, firstStepWithData, textFont, boldBlack);
                document.add(Chunk.NEWLINE);
            }
        }

        // --- Resultado ---
        String statusRaw = escenario.has("result") ? escenario.get("result").getAsString()
                : escenario.has("testResult") ? escenario.get("testResult").getAsString() : null;

        if (statusRaw != null) {
            String statusText;
            String statusIcon;
            BaseColor color;

            if (statusRaw.equalsIgnoreCase("SUCCESS") || statusRaw.equalsIgnoreCase("PASSED")) {
                statusText = "Exitoso";
                statusIcon = "✔";
                color = BaseColor.GREEN;
            } else if (statusRaw.equalsIgnoreCase("FAILURE") || statusRaw.equalsIgnoreCase("ERROR")) {
                statusText = "Fallido";
                statusIcon = "✖";
                color = BaseColor.RED;
            } else {
                statusText = statusRaw;
                statusIcon = "⚠";
                color = BaseColor.ORANGE;
            }

            Font statusFont = new Font(baseFont, 12, Font.BOLD, color);
            Paragraph resultParagraph = new Paragraph("Resultado: " + statusText + " " + statusIcon, statusFont);
            document.add(resultParagraph);
            document.add(Chunk.NEWLINE);
        }

        // --- Evidencias ---
        document.add(new Paragraph("Evidencias:", sectionFont));
        if (steps != null) {
            addStepsRecursive(document, steps, textFont, boldBlack, 1);
        }

        document.close();
        System.out.println("Generado PDF: " + pdfFile.getName());
    }

    // Busca el primer paso que contenga {...}
    private JsonObject findFirstStepWithData(JsonArray steps) {
        for (JsonElement el : steps) {
            JsonObject step = el.getAsJsonObject();
            if (step.has("description") && step.get("description").getAsString().contains("{")) {
                return step;
            }
            if (step.has("children")) {
                JsonObject found = findFirstStepWithData(step.getAsJsonArray("children"));
                if (found != null) return found;
            }
        }
        return null;
    }

    // Genera tabla desde paso con {...}
    private void addTableFromStep(Document document, JsonObject step, Font textFont, Font boldFont) throws Exception {
        String desc = step.get("description").getAsString();
        int start = desc.indexOf("{");
        int end = desc.indexOf("}");
        if (start == -1 || end == -1) return;

        String dataBlock = desc.substring(start + 1, end);
        PdfPTable table = new PdfPTable(2);
        table.setWidthPercentage(80);
        table.setSpacingBefore(5f);
        table.setSpacingAfter(10f);
        table.setWidths(new float[]{2, 4});

        Font headerFont = new Font(boldFont.getBaseFont(), 12, Font.BOLD, BaseColor.WHITE);
        PdfPCell h1 = new PdfPCell(new Phrase("Campo", headerFont));
        PdfPCell h2 = new PdfPCell(new Phrase("Valor", headerFont));
        h1.setBackgroundColor(BaseColor.DARK_GRAY);
        h2.setBackgroundColor(BaseColor.DARK_GRAY);
        h1.setHorizontalAlignment(Element.ALIGN_CENTER);
        h2.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(h1);
        table.addCell(h2);

        for (String part : dataBlock.split(",")) {
            String[] keyValue = part.split(":|=");
            String key = keyValue.length > 0 ? keyValue[0].trim() : "";
            String value = keyValue.length > 1 ? keyValue[1].trim() : "";
            table.addCell(new Phrase(key, textFont));
            table.addCell(new Phrase(value, textFont));
        }
        document.add(table);
    }

    // Recorre los pasos y muestra descripciones e imágenes
    private void addStepsRecursive(Document document, JsonArray steps, Font textFont, Font boldBlack, int stepIndex) throws Exception {
        for (JsonElement stepElement : steps) {
            JsonObject step = stepElement.getAsJsonObject();

            String stepDescription = step.has("description")
                    ? step.get("description").getAsString()
                    : "(sin descripción)";

            stepDescription = stepDescription.replaceAll("^\\d+:", "").trim();
            stepDescription = translateStepDescription(stepDescription);

            // Ignorar bloque {...} ya mostrado al inicio
            if (stepDescription.contains("{")) {
                int start = stepDescription.indexOf("{");
                stepDescription = stepDescription.substring(0, start).trim();
            }

            Paragraph stepParagraph = new Paragraph("Paso " + stepIndex + ": " + stepDescription, boldBlack);
            document.add(stepParagraph);

            // Capturas de pantalla
            if (step.has("screenshots")) {
                JsonArray screenshots = step.getAsJsonArray("screenshots");
                for (JsonElement ss : screenshots) {
                    String screenshotPath = null;
                    if (ss.isJsonPrimitive()) {
                        screenshotPath = ss.getAsString();
                    } else if (ss.isJsonObject() && ss.getAsJsonObject().has("screenshot")) {
                        screenshotPath = ss.getAsJsonObject().get("screenshot").getAsString();
                    }

                    if (screenshotPath != null) {
                        File imgFile = new File(screenshotPath);
                        if (!imgFile.isAbsolute()) {
                            imgFile = new File(REPORTS_DIR, screenshotPath);
                        }

                        if (imgFile.exists()) {
                            try {
                                Image img = Image.getInstance(imgFile.getAbsolutePath());
                                img.scaleToFit(500, 300);
                                img.setAlignment(Element.ALIGN_CENTER);
                                document.add(img);
                            } catch (Exception e) {
                                document.add(new Paragraph("⚠ Error mostrando imagen: " + imgFile.getName(), textFont));
                            }
                        } else {
                            document.add(new Paragraph("⚠ Imagen no encontrada: " + imgFile.getAbsolutePath(), textFont));
                        }
                    }
                }
            }

            // Subpasos
            if (step.has("children")) {
                JsonArray children = step.getAsJsonArray("children");
                if (children.size() > 0) {
                    addStepsRecursive(document, children, textFont, boldBlack, stepIndex + 1);
                }
            }

            document.add(Chunk.NEWLINE);
            stepIndex++;
        }
    }

    // Traducción extendida de pasos
    private String translateStepDescription(String text) {
        text = text.replaceAll("User", "El usuario");
        text = text.replaceAll("Then", "Entonces");
        text = text.replaceAll("When", "Cuando");
        text = text.replaceAll("Given", "Dado que");
        text = text.replaceAll("into", "en");
        text = text.replaceAll("with text value that contains", "con el valor de texto que contiene");
        text = text.replaceAll("that is displayed", "que se muestra");
        text = text.replaceAll("that is enabled", "que está habilitado");
        text = text.replaceAll("that is disabled", "que está deshabilitado");
        text = text.replaceAll("select", "selecciona");
        text = text.replaceAll("clicks on", "hace clic en");
        text = text.replaceAll("click", "clic");
        text = text.replaceAll("enters", "ingresa");
        text = text.replaceAll("navigates to", "navega a");
        text = text.replaceAll("opens the", "abre");
        text = text.replaceAll("form", "formulario");
        text = text.replaceAll("page", "página");
        text = text.replaceAll("field", "campo");
        text = text.replaceAll("value", "valor");
        text = text.replaceAll("message", "mensaje");
        text = text.replaceAll("success login", "inicio de sesión exitoso");
        text = text.replaceAll("Debe iniciar sesión correctamente en corporate", "Debe iniciar sesión correctamente en Corporate");
        text = text.replaceAll("active session", "sesión activa");
        text = text.replaceAll("transfer", "transferencia");
        text = text.replaceAll("type", "tipo");
        text = text.replaceAll("nav", "navega");

        // --- NUEVAS TRADUCCIONES PERSONALIZADAS ---
        text = text.replaceAll("should see", "debería ver");
        text = text.replaceAll("transferenciaencias", "transferencias");
        text = text.replaceAll("transferenciaencia", "transferencia");
        text = text.replaceAll("transferenciair", "transferencias");

        return text.trim();
    }
}
