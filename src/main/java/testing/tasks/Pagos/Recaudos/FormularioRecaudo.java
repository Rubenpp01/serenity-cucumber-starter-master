package testing.tasks.Pagos.Recaudos;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import testing.ui.pagos.Recaudos.RecaudosDirectos;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class FormularioRecaudo implements Task {

    private final String monto;
    private final String numeroref;


    public FormularioRecaudo(String monto, String nuneroref) {

        this.monto = monto;
        this.numeroref=nuneroref;
    }
    @Override
    public void performAs(Actor actor) {
        actor.attemptsTo(
                Click.on(RecaudosDirectos.CUENTA_FROM_RECAUDO_DIR),
                Click.on(RecaudosDirectos.CURREN_ACCOUNT_RECAUDO_DIR),
                Click.on(RecaudosDirectos.TIPO_REC_LIST_RECAUDO_DIR),
                Click.on(RecaudosDirectos.TIPO_RECAUDO_DIR),
                Click.on(RecaudosDirectos.BTON_SELECT_BENE_EXIST),
                Click.on(RecaudosDirectos.SELECT_SINGLE_BENEFICIARIO),
                Click.on(RecaudosDirectos.BUTTON_ACEPTAR_SELECT_BENE),
                Enter.theValue(this.monto).into(RecaudosDirectos.SELECT_MONTO_RECAUDO_DIR),
                Enter.theValue(this.numeroref).into(RecaudosDirectos.ADD_NUMEROREF_RECAUDO_DIR),
                Click.on(RecaudosDirectos.BUTTON_CONTINUAR1_RECAUDO_DIR)


        );
    }
    public static FormularioRecaudo datosRecaudos(String monto, String numeroref) {
        return instrumented(FormularioRecaudo.class, monto, numeroref);
    }
}
