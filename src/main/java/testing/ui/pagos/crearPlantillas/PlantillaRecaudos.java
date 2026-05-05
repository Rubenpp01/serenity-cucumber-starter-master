package testing.ui.pagos.crearPlantillas;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.findby.By;

public class PlantillaRecaudos {

    private PlantillaRecaudos() { }

    public static final Target PLANTILLA_MENU_PAGOS = Target.the("clic Módulo Pagos")
            .located(By.id("navigation_payments"));
    public static final Target PLANTILLA_RECAUDO_SERV = Target.the("clic el Servicio Plantillas Recaudos Directos Crear Pagos Col")
            .located(By.id("navigation_payments_createCollectionTemplate"));
    public static final Target PLANTILLA_FORM_RECAUDO_HEADER = Target.the("Valida el Encabezado de Formulario Rec Dir")
            .located(By.id("navigation_payments_createCollectionTemplate"));
    public static final Target PANTILLA_NOMBRE_RECAUDO = Target.the("Campo Nombre Plantilla")
            .locatedBy("//*[@id='templateName']");
    public static final Target PLANTILLA_CUENTA_FROM_RECAUDO = Target.the("Campo de selección cuenta origen")
            .locatedBy("//*[@id='originatingAcct_displayText']");
    public static final Target PLANTILLA_CUENTA_ORIGEN_RECAUDO = Target.the("seleccion Cuenta Ahorro desde")
            .locatedBy("//*[@id='originatingAcct_option_0008C80E']");
    public static final Target PLANTILLA_TIPO_DESPLIEGUE_RECAUDO = Target.the("Despliegue listado tipo de Recaudo")
            .located(By.id("collectionType_displayText"));
    public static final Target PLANTILLA_SELECT_TIPO_RECAUDO = Target.the("Seleccion tipo Cuota")
                .locatedBy("//*[@id='collectionType_option_010']");
    public static final Target PLANTILLA_ASIG_LIMITE_RECAUDO = Target.the("Seleccion tipo Cuota")
            .locatedBy("//*[@id='templateLimit_input']");
    public static final Target PLANTILLA_BTON_BENE_EXISTENTE_RECAUDO = Target.the("Boton Beneficiario existente")
            .locatedBy("//*[@id='btnSelectRecipients']");
    public static final Target PLANTILLA_SELECT_BENEFICIARIO_1_RECAUDO = Target.the("Seleccion CHECK un beneficiario")
            .located(By.id("input-baiGrpsList-rowSelector-3-checkbox_checkinput-background"));
    public static final Target PLANTILLA_BUTTON_ACEPTAR_SELECT_BENE_RECAUDO= Target.the("Boton Aceptar seleccion beneficiario")
            .locatedBy("//*[@id='btnDone']");
    public static final Target PLANTILLA_SELECT_MONTO_RECAUDO = Target.the("seleccionar Adicionar monto")
            .locatedBy("//*[@id='recipientAmount_0_input']");
    public static final Target PLANTILLA_NUMEROREF_RECAUDO = Target.the("Adicionar el valor monto")
            .locatedBy("//*[@id='referenceNumber_0']");
    public static final Target PLANTILLA_BUTTON_CONTINUAR1_RECAUDO = Target.the("Boton Continuar")
            .locatedBy("//*[@id='btnContinue']");
    public static final Target PLANTILLA_ASIGNAR_CLAVE_RECAUDO = Target.the("Asignacion Clave")
            .locatedBy("//*[@id='signature']");
    public static final Target PLANTILLA_ENVIAR_PLANTILLA_RECAUDO= Target.the("Boton enviar Pago")
            .locatedBy("//*[@id='btnSubmit']");
    public static final Target PLANTILLA_RECAUDO_SUCCESS = Target.the("Mensaje de confirmación")
            .locatedBy("//*[@id='success-block-PAYMENT-SUCCESS']");
    public static final Target PLANTILLA_RECAUDO_ERROR = Target.the("Mensaje de error")
            .located(By.xpath("//*[@id='error-block-global']"));

}
