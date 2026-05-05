package testing.questions.Pagos.Recaudos;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.ensure.Ensure;
import testing.ui.pagos.Recaudos.RecaudosDirectos;

public class SuccessUnica implements Question<Boolean> {
    private final String creacionExitosa;

    public SuccessUnica(String creacionExitosa) {
        this.creacionExitosa = creacionExitosa;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        actor.attemptsTo(
                Ensure.that(RecaudosDirectos.RECAUDO_DIR_SUCCESS).isDisplayed(),
                Ensure.that(RecaudosDirectos.RECAUDO_DIR_SUCCESS).text().contains(creacionExitosa)
        );
        return true;
    }

    public static SuccessUnica creacionExitosa (String creacionExitosa) {
        return new SuccessUnica(creacionExitosa);
    }

}


