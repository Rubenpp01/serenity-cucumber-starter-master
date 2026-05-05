package testing.tasks.Pagos.Recaudos;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.jetbrains.annotations.NotNull;
import testing.ui.pagos.Recaudos.RecaudosDirectos;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ClaveYPago implements Task {

    private final String clavePagos;

    public ClaveYPago(String clavePagos) {
        this.clavePagos = clavePagos;
    }



    @Override
    public <T extends Actor> void performAs(@NotNull T actor) {
        actor.attemptsTo(

                Enter.theValue(clavePagos).into(RecaudosDirectos.ASIGNAR_CLAVE),
                WaitUntil.the(RecaudosDirectos.ENVIAR_PAGO_RECAUDO_DIR, isVisible()).forNoMoreThan(30).seconds(),
                Click.on(RecaudosDirectos.ENVIAR_PAGO_RECAUDO_DIR)
        );
    }

    public static ClaveYPago con(String clavePagos) {
        return instrumented(ClaveYPago.class, clavePagos);
    }
}
