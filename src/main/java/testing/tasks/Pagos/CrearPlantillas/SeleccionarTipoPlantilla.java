package testing.tasks.Pagos.CrearPlantillas;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import testing.ui.pagos.Recaudos.RecaudosDirectos;
import testing.ui.pagos.crearPlantillas.PlantillaRecaudos;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SeleccionarTipoPlantilla implements Task {

    private final String tipo;

    public SeleccionarTipoPlantilla(String type) {
        this.tipo = type; // ← FIX
    }

    @Override
    public void performAs(Actor actor) {
        if (tipo.equalsIgnoreCase("PLANTILLA RECAUDOS")) {
            actor.attemptsTo(
                    WaitUntil.the(PlantillaRecaudos.PLANTILLA_RECAUDO_SERV, isVisible()).forNoMoreThan(10).seconds(),
                    Click.on(PlantillaRecaudos.PLANTILLA_RECAUDO_SERV),
                    WaitUntil.the(PlantillaRecaudos.PLANTILLA_FORM_RECAUDO_HEADER, isVisible()).forNoMoreThan(20).seconds()
            );
        }
    }

    public static SeleccionarTipoPlantilla como(String tipo) {
        return instrumented(SeleccionarTipoPlantilla.class, tipo);
    }
}
