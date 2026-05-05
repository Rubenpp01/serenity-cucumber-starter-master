package testing.tasks.Cuentas.HerramientasdeCuentas.PerfilesdeExportacion;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import testing.ui.Cuentas.HerramientasdeCuentas.PerfilesdeExportacion.PerfilesdeExportacion;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SeleccionarPerfilExportacion implements Task {

    private final String tipo;

    public SeleccionarPerfilExportacion(String type) {
        this.tipo = type; // ← FIX
    }

    @Override
    public void performAs(Actor actor) {
        if (tipo.equalsIgnoreCase("Perfiles de Exportación")) {
            actor.attemptsTo(
                    WaitUntil.the(PerfilesdeExportacion.PERFILEX_SERV_PERFILEX, isVisible()).forNoMoreThan(10).seconds(),
                    Click.on(PerfilesdeExportacion.PERFILEX_SERV_PERFILEX)
            );
        }
    }

    public static SeleccionarPerfilExportacion como(String perfilExportacion) {
        return instrumented(SeleccionarPerfilExportacion.class, perfilExportacion);
    }
}
