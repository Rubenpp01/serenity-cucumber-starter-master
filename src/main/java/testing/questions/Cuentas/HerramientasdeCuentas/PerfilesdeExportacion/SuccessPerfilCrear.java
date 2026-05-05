package testing.questions.Cuentas.HerramientasdeCuentas.PerfilesdeExportacion;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.ensure.Ensure;
import testing.ui.Cuentas.HerramientasdeCuentas.PerfilesdeExportacion.PerfilesdeExportacion;

public class SuccessPerfilCrear implements Question<Boolean> {
    private final String PerfilcreadoExitosa;

    public SuccessPerfilCrear(String PerfilcreadoExitosa) {
        this.PerfilcreadoExitosa = PerfilcreadoExitosa;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        actor.attemptsTo(
                Ensure.that(PerfilesdeExportacion.PERFILEX_CREAR_MensajeConfirmacion).isDisplayed(),
                Ensure.that(PerfilesdeExportacion.PERFILEX_CREAR_MensajeConfirmacion).text().contains(PerfilcreadoExitosa)
        );
        return true;
    }

    public static SuccessPerfilCrear PerfilcreadoExitosa (String PerfilcreadoExitosa) {
        return new SuccessPerfilCrear(PerfilcreadoExitosa);
    }

}


