package testing.tasks.Cuentas.HerramientasdeCuentas.PerfilesdeExportacion;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import testing.ui.Cuentas.HerramientasdeCuentas.PerfilesdeExportacion.PerfilesdeExportacion;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class FormularioPerfilExportacion implements Task {

    private final String descripcionperfil;
    private final String nombreperfil;


    public FormularioPerfilExportacion(String descripcionperfil, String nombreperfil) {

        this.descripcionperfil=descripcionperfil;
        this.nombreperfil=nombreperfil;
    }
    @Override
    public void performAs(Actor actor) {
        actor.attemptsTo(
                Click.on(PerfilesdeExportacion.PERFILEX_PERFILEX_CREAR),
                Enter.theValue(this.descripcionperfil).into(PerfilesdeExportacion.PERFILEX_CREAR_Desc),
                Enter.theValue(this.nombreperfil).into(PerfilesdeExportacion.PERFILEX_CREAR_Nomb),
                Click.on(PerfilesdeExportacion.PERFILEX_CREAR_Lista),
                Click.on(PerfilesdeExportacion.PERFILEX_CREAR_SelectArchivo),
                Click.on(PerfilesdeExportacion.PERFILEX_CREAR_Bton_Sgte),
                Click.on(PerfilesdeExportacion.PERFILEX_CREAR_Selectallctas),
                Click.on(PerfilesdeExportacion.PERFILEX_CREAR_SelectRelativa ),
                Click.on(PerfilesdeExportacion.PERFILEX_CREAR_LISTDe),
                Click.on(PerfilesdeExportacion.PERFILEX_CREAR_LISTInicioMesAct),
                Click.on(PerfilesdeExportacion.PERFILEX_CREAR_LISTHasta),
                Click.on(PerfilesdeExportacion.PERFILEX_CREAR_LISTHoy),
                Click.on(PerfilesdeExportacion.PERFILEX_CREAR_BtonSgte2),
                Click.on(PerfilesdeExportacion.PERFILEX_CREAR_BtonSgte3),
                Click.on(PerfilesdeExportacion.PERFILEX_CREAR_CheckTran),
                Click.on(PerfilesdeExportacion.PERFILEX_CREAR_CheckCuenta),
                Click.on(PerfilesdeExportacion.PERFILEX_CREAR_CheckResumen),
                Click.on(PerfilesdeExportacion.PERFILEX_CREAR_BtonSgte4),
                Click.on(PerfilesdeExportacion.PERFILEX_CREAR_BtonEnviarPerfil)

        );
    }
    public static FormularioPerfilExportacion datosPerfil(String descripcionperfil, String nombreperfil) {
        return instrumented(FormularioPerfilExportacion.class, descripcionperfil, nombreperfil);
    }
}
