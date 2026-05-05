package testing.questions.Cuentas.HerramientasdeCuentas.PerfilesdeExportacion;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.ensure.Ensure;
import testing.ui.Cuentas.HerramientasdeCuentas.PerfilesdeExportacion.PerfilesdeExportacion;
import testing.ui.pagos.crearPlantillas.PlantillaRecaudos;

public class ErrorPerfilCrear implements Question<Boolean> {
    private final String mensajeError;

    public ErrorPerfilCrear(String mensajeError) {
        this.mensajeError = mensajeError;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        actor.attemptsTo(
                Ensure.that(PerfilesdeExportacion.PERFILEX_CREAR_MensajeError).isDisplayed(),
                Ensure.that(PerfilesdeExportacion.PERFILEX_CREAR_MensajeError).text().contains(mensajeError)
        );
        return true;
    }

    public static ErrorPerfilCrear mensajeDeError(String mensajeError) {
        return new ErrorPerfilCrear(mensajeError);
    }
}