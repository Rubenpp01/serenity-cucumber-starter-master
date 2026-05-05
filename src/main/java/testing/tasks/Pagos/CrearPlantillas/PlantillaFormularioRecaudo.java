package testing.tasks.Pagos.CrearPlantillas;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import testing.ui.pagos.crearPlantillas.PlantillaRecaudos;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class PlantillaFormularioRecaudo implements Task {

    private final String nombreplantilla;
    private final String limiteRec;
    private final String monto;
    private final String numeroref;


    public PlantillaFormularioRecaudo(String nombreplantilla,String limiteRec, String monto, String nuneroref) {

        this.nombreplantilla=nombreplantilla;
        this.limiteRec=limiteRec;
        this.monto = monto;
        this.numeroref=nuneroref;
    }
    @Override
    public void performAs(Actor actor) {
        actor.attemptsTo(
                Click.on(PlantillaRecaudos.PLANTILLA_FORM_RECAUDO_HEADER),
                Enter.theValue(this.nombreplantilla).into(PlantillaRecaudos.PANTILLA_NOMBRE_RECAUDO),
                Click.on(PlantillaRecaudos.PLANTILLA_CUENTA_FROM_RECAUDO),
                Click.on(PlantillaRecaudos.PLANTILLA_CUENTA_ORIGEN_RECAUDO),
                Click.on(PlantillaRecaudos.PLANTILLA_TIPO_DESPLIEGUE_RECAUDO),
                Click.on(PlantillaRecaudos.PLANTILLA_SELECT_TIPO_RECAUDO),
                Enter.theValue(this.limiteRec).into(PlantillaRecaudos.PLANTILLA_ASIG_LIMITE_RECAUDO),
                Click.on(PlantillaRecaudos.PLANTILLA_BTON_BENE_EXISTENTE_RECAUDO),
                Click.on(PlantillaRecaudos.PLANTILLA_SELECT_BENEFICIARIO_1_RECAUDO),
                Click.on(PlantillaRecaudos.PLANTILLA_BUTTON_ACEPTAR_SELECT_BENE_RECAUDO),
                Enter.theValue(this.monto).into(PlantillaRecaudos.PLANTILLA_SELECT_MONTO_RECAUDO),
                Enter.theValue(this.numeroref).into(PlantillaRecaudos.PLANTILLA_NUMEROREF_RECAUDO),
                Click.on(PlantillaRecaudos.PLANTILLA_BUTTON_CONTINUAR1_RECAUDO)

        );
    }
    public static PlantillaFormularioRecaudo datosRecaudos(String nombreplantilla, String limiteRec, String monto, String numeroref) {
        return instrumented(PlantillaFormularioRecaudo.class, nombreplantilla, limiteRec,monto, numeroref);
    }
}
