package testing.tasks.Pagos.Recaudos;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import testing.ui.pagos.crearPlantillas.PlantillaRecaudos;


import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;


    public class ModuloPagos implements Task {
        @Override
        public void performAs(Actor actor) {
            actor.attemptsTo(
                    WaitUntil.the(PlantillaRecaudos.PLANTILLA_MENU_PAGOS, isVisible()).forNoMoreThan(10).seconds(),
                    Click.on(PlantillaRecaudos.PLANTILLA_MENU_PAGOS)

            );
        }

        public static ModuloPagos navegar() {
            return instrumented(ModuloPagos.class);
        }

}
