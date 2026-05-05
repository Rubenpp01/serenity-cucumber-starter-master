package testing.tasks.Pagos.CrearPlantillas;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import testing.ui.pagos.Recaudos.RecaudosDirectos;
import testing.ui.pagos.crearPlantillas.PlantillaRecaudos;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;


public class PlantillaModuloPagos implements Task {
    @Override
    public void performAs(Actor actor) {
        actor.attemptsTo(
                WaitUntil.the(PlantillaRecaudos.PLANTILLA_MENU_PAGOS, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(PlantillaRecaudos.PLANTILLA_MENU_PAGOS)
        );
    }

    public static PlantillaModuloPagos navegar() {
        return instrumented(PlantillaModuloPagos.class);
    }

}
