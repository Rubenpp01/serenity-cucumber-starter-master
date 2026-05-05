package testing.questions.Pagos.Recaudos;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.ensure.Ensure;
import testing.ui.pagos.Recaudos.RecaudosDirectos;

public class ErrorUnica implements Question<Boolean> {
    private final String mensajeError;

    public ErrorUnica(String mensajeError) {
        this.mensajeError = mensajeError;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        actor.attemptsTo(
                Ensure.that(RecaudosDirectos.RECAUDO_DIR_ERROR).isDisplayed(),
                Ensure.that(RecaudosDirectos.RECAUDO_DIR_ERROR).text().contains(mensajeError)
        );
        return true;
    }

    public static ErrorUnica mensajeDeError(String mensajeError) {
        return new ErrorUnica(mensajeError);
    }
}