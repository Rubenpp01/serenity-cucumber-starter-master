package testing.tasks.Pagos.Recaudos;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import testing.ui.pagos.Recaudos.RecaudosDirectos;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SeleccionarTipoPago implements Task {

    private final String tipo;

    public SeleccionarTipoPago(String type) {
        this.tipo = type; // ← FIX
    }

    @Override
    public void performAs(Actor actor) {
        if (tipo.equalsIgnoreCase("RECAUDOS DIRECTOS")) {
            actor.attemptsTo(
                    WaitUntil.the(RecaudosDirectos.RECAUDOS_DIRECTOS, isVisible()).forNoMoreThan(10).seconds(),
                    Click.on(RecaudosDirectos.RECAUDOS_DIRECTOS),
                    WaitUntil.the(RecaudosDirectos.FORM_RECAUDO_DIR_HEADER, isVisible()).forNoMoreThan(20).seconds()
            );
        }
    }

    public static SeleccionarTipoPago como(String tipo) {
        return instrumented(SeleccionarTipoPago.class, tipo);
    }
}
