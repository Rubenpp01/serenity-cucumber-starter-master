package testing.tasks.Login;

import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import testing.ui.Login.LoginCorporatePage;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ActiveSession implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        if (LoginCorporatePage.CONTINUE_BUTTON.resolveFor(actor).isPresent()) {
            actor.attemptsTo(Click.on(LoginCorporatePage.CONTINUE_BUTTON));
        } else {
            // Acción alternativa si el botón no está presente
            System.out.println("No se detectó una sesión activa anterior. Continuando sin cerrar sesión.");
        }
    }

    public static ActiveSession Continuar () {
        return instrumented(ActiveSession.class);
    }

}

