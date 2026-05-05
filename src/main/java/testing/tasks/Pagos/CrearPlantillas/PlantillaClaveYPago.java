package testing.tasks.Pagos.CrearPlantillas;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.jetbrains.annotations.NotNull;
import testing.ui.pagos.Recaudos.RecaudosDirectos;
import testing.ui.pagos.crearPlantillas.PlantillaRecaudos;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class PlantillaClaveYPago implements Task {

    private final String clavePagos;

    public PlantillaClaveYPago(String clavePagos) {
        this.clavePagos = clavePagos;
    }



    @Override
    public <T extends Actor> void performAs(@NotNull T actor) {
        actor.attemptsTo(

                Enter.theValue(clavePagos).into(PlantillaRecaudos.PLANTILLA_ASIGNAR_CLAVE_RECAUDO),
                WaitUntil.the(PlantillaRecaudos.PLANTILLA_ENVIAR_PLANTILLA_RECAUDO, isVisible()).forNoMoreThan(30).seconds(),
                Click.on(PlantillaRecaudos.PLANTILLA_ENVIAR_PLANTILLA_RECAUDO)
        );
    }

    public static PlantillaClaveYPago con(String clavePagos) {
        return instrumented(PlantillaClaveYPago.class, clavePagos);
    }
}
