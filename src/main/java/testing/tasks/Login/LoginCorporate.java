package testing.tasks.Login;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import testing.ui.Login.LoginCorporatePage;
import testing.ui.Login.HomeCorporatePage;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class LoginCorporate implements Task {

    private final String company;
    private final String username;
    private final String password;

    public LoginCorporate(String company, String username, String password) {
        this.company = company;
        this.username = username;
        this.password = password;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(this.company).into(LoginCorporatePage.COMPANY),
                Enter.theValue(this.username).into(LoginCorporatePage.USERNAME),
                Enter.theValue(this.password).into(LoginCorporatePage.PASSWORD),
                Click.on(LoginCorporatePage.LANGUAGE_ABRIR_SELECT),
                Click.on(LoginCorporatePage.LANGUAGE_SELECT_ESPANOL),
                Click.on(LoginCorporatePage.SUBMIT_BUTTON),
                ActiveSession.Continuar (),
                WaitUntil.the(HomeCorporatePage.WELCOME_TEXT, isVisible()).forNoMoreThan(2000).seconds()
        );
    }

    public static LoginCorporate conCredenciales(String company, String username, String password) {
        return instrumented(LoginCorporate.class, company, username, password);
    }
}
