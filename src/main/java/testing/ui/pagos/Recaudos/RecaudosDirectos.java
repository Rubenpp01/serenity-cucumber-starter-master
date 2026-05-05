package testing.ui.pagos.Recaudos;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.findby.By;

public class RecaudosDirectos {

    private RecaudosDirectos() { }

    public static final Target MENU_PAGOS = Target.the("Módulo Pagos")
            .locatedBy("//*[@id='navigation_payments']");
    public static final Target RECAUDOS_DIRECTOS= Target.the("Servicio Recaudos Directos Crear Pagos Col")
            .located(By.id("navigation_payments_createCollection"));
    public static final Target FORM_RECAUDO_DIR_HEADER = Target.the("Encabezado de Formulario Rec Dir")
            .located(By.id("Crear_Recaudo_Directo_Colombia"));
    public static final Target CUENTA_FROM_RECAUDO_DIR = Target.the("Campo de selección cuenta origen")
            .locatedBy("//*[@id='originatingAcctcombobox']");
    public static final Target CURREN_ACCOUNT_RECAUDO_DIR = Target.the("Cuenta Ahorro desde")
            .locatedBy("//*[@id='originatingAcct_option_0008C80E']");
    public static final Target TIPO_REC_LIST_RECAUDO_DIR= Target.the("Seleccion tipo de Recaudo")
            .located(By.id("collectionType_displayText"));
    public static final Target TIPO_RECAUDO_DIR= Target.the("Seleccion tipo Cuota")
                .locatedBy("//*[@id='collectionType_option_011']");
    public static final Target BTON_SELECT_BENE_EXIST= Target.the("Seleccion Beneficiario existente")
            .locatedBy("//*[@id='btnSelectRecipients']");
    public static final Target SELECT_SINGLE_BENEFICIARIO= Target.the("Seleccion un beneficiario")
            .located(By.id("input-baiGrpsList-rowSelector-2-checkbox_checkinput-background"));
    public static final Target BUTTON_ACEPTAR_SELECT_BENE= Target.the("Boton Aceptar")
            .locatedBy("//*[@id='btnDone']");
    public static final Target SELECT_MONTO_RECAUDO_DIR= Target.the("seleccionar Adicionar monto")
            .locatedBy("//*[@id='recipientAmount_0_input']");
    public static final Target ADD_NUMEROREF_RECAUDO_DIR= Target.the("Adicionar el valor monto")
            .locatedBy("//*[@id='referenceNumber_0']");
    public static final Target BUTTON_CONTINUAR1_RECAUDO_DIR= Target.the("Boton Continuar")
            .locatedBy("//*[@id='btnContinue']");
    public static final Target ASIGNAR_CLAVE= Target.the("Asignacion Clave")
            .locatedBy("//*[@id='signature']");
    public static final Target ENVIAR_PAGO_RECAUDO_DIR= Target.the("Boton enviar Pago")
            .locatedBy("//*[@id='btnSubmit']");
    public static final Target RECAUDO_DIR_SUCCESS = Target.the("Mensaje de confirmación")
            .locatedBy("//*[@id='success-block-PAYMENT-SUCCESS']");
    public static final Target RECAUDO_DIR_ERROR = Target.the("Mensaje de error")
            .located(By.xpath("//*[@id='error-block-global']"));

}
