package testing.tasks.Cuentas.HerramientasdeCuentas.PerfilesdeExportacion;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import testing.ui.Cuentas.HerramientasdeCuentas.PerfilesdeExportacion.PerfilesdeExportacion;
import testing.ui.pagos.crearPlantillas.PlantillaRecaudos;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;


public class ModuloCuentasPerfilExp implements Task {
    @Override
    public void performAs(Actor actor) {
        actor.attemptsTo(
                WaitUntil.the(PerfilesdeExportacion.PERFILEX_MENU_CUENTAS, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(PerfilesdeExportacion.PERFILEX_MENU_CUENTAS)
        );
    }

    public static ModuloCuentasPerfilExp navegar() {
        return instrumented(ModuloCuentasPerfilExp.class);
    }

}
