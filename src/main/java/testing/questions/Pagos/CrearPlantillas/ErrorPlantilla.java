package testing.questions.Pagos.CrearPlantillas;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.ensure.Ensure;
import testing.ui.pagos.crearPlantillas.PlantillaRecaudos;

public class ErrorPlantilla implements Question<Boolean> {
    private final String mensajeError;

    public ErrorPlantilla(String mensajeError) {
        this.mensajeError = mensajeError;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        actor.attemptsTo(
                Ensure.that(PlantillaRecaudos.PLANTILLA_RECAUDO_ERROR).isDisplayed(),
                Ensure.that(PlantillaRecaudos.PLANTILLA_RECAUDO_ERROR).text().contains(mensajeError)
        );
        return true;
    }

    public static ErrorPlantilla mensajeDeError(String mensajeError) {
        return new ErrorPlantilla(mensajeError);
    }
}