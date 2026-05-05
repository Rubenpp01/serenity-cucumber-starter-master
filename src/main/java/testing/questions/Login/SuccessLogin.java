package testing.questions.Login;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.ensure.Ensure;
import testing.ui.Login.HomeCorporatePage;

public class SuccessLogin implements Question<Boolean> {
    String mensajeEsperado;
    @Override
    public Boolean answeredBy(Actor actor) {


        actor.attemptsTo(
                Ensure.that(HomeCorporatePage.WELCOME_TEXT).isDisplayed(),
                Ensure.that(HomeCorporatePage.WELCOME_TEXT).text().contains(mensajeEsperado)
        );
        return true;
    }

    public static SuccessLogin loginExitoso(String mensajeEsperado) {return new SuccessLogin();
    }
}
