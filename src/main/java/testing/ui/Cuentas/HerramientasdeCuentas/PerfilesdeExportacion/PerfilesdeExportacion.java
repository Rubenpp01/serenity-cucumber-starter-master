package testing.ui.Cuentas.HerramientasdeCuentas.PerfilesdeExportacion;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.findby.By;

public class PerfilesdeExportacion {

    private PerfilesdeExportacion() { }

    public static final Target PERFILEX_MENU_CUENTAS = Target.the("clic Módulo Cuentas")
            .located(By.id("navigation_accounts"));
    public static final Target PERFILEX_SERV_PERFILEX = Target.the("clic el Servicio Perfiles de Exportación")
            .located(By.id("navigation_accounts_accountsExportProfiles"));
    public static final Target PERFILEX_PERFILEX_CREAR = Target.the("Clic en el botón Crear Perfil de Exportación")
            .located(By.id("add_link"));
    public static final Target PERFILEX_CREAR_Desc = Target.the("Clic campo descripción Perfil de Exportación")
            .locatedBy("//*[@id='exportProfileDescription']");
    public static final Target PERFILEX_CREAR_Nomb = Target.the("clic campo nombre Perfil de Exportación")
            .locatedBy("//*[@id='exportProfileName']");
    public static final Target PERFILEX_CREAR_Lista = Target.the("Clic en el campo Lista de Cuentas")
            .locatedBy("//*[@id='fileFormat_displayText']");
    public static final Target PERFILEX_CREAR_SelectArchivo = Target.the("Clic en el tipo de Archivo")
            .located(By.id("fileFormat_option_TAB"));
    public static final Target PERFILEX_CREAR_Bton_Sgte = Target.the("Clic en el botón Siguiente")
                .locatedBy("//*[@id='btnNext']");
    public static final Target PERFILEX_CREAR_Selectallctas = Target.the("Clic en el checkbox Seleccionar Todas las Cuentas")
            .locatedBy("//*[@id='input-accounts_toacc_gridselector-checkbox_checkinput-background']");
    public static final Target PERFILEX_CREAR_SelectRelativa = Target.the("Clic en el checkbox Seleccionar Relativa")
            .locatedBy("//*[@id='relativeDateRange-radio-option-input_radio-container']");
    public static final Target PERFILEX_CREAR_LISTDe = Target.the("Clic en el campo Lista de Destinatarios")
            .located(By.id("relativeDateFrom_displayText"));
    public static final Target PERFILEX_CREAR_LISTInicioMesAct = Target.the("Clic en el campo Inicio Mes Actual")
            .locatedBy("//*[@id='relativeDateFrom_option_BEG_CUR_MONTH']");
    public static final Target PERFILEX_CREAR_LISTHasta = Target.the("Clic en el campo Lista de Destinatarios Hasta")
            .locatedBy("//*[@id='relativeDateTo_displayText']");
    public static final Target PERFILEX_CREAR_LISTHoy = Target.the("Clic en el campo Lista de Destinatarios Hoy")
            .locatedBy("//*[@id='relativeDateTo_option_TODAY']");
    public static final Target PERFILEX_CREAR_BtonSgte2 = Target.the("Clic en el botón Siguiente2")
            .locatedBy("//*[@id='btnNext']");
    public static final Target PERFILEX_CREAR_BtonSgte3 = Target.the("Clic en el botón Siguiente3")
            .locatedBy("//*[@id='btnNext']");
    public static final Target PERFILEX_CREAR_CheckTran = Target.the("Clic en el checkbox Transacciones")
            .locatedBy("//*[@id='input-transactionCodesGridselector-checkbox_checkinput-background']");
    public static final Target PERFILEX_CREAR_CheckCuenta = Target.the("Clic en el checkbox Resumen de Cuentas")
            .locatedBy("//*[@id='input-summaryCodesselector-checkbox_checkinput-background']");
    public static final Target PERFILEX_CREAR_CheckResumen = Target.the("Clic en el checkbox Resumen de Cuentas")
            .locatedBy("//*[@id='input-summaryCodesselector-checkbox_checkinput-background']");
    public static final Target PERFILEX_CREAR_BtonSgte4 = Target.the("Clic en el botón Siguiente4")
            .locatedBy("//*[@id='btnNext']");
    public static final Target PERFILEX_CREAR_BtonEnviarPerfil = Target.the("Clic en el botón Enviar Perfil")
            .locatedBy("//*[@id='btnSubmit']");
    public static final Target PERFILEX_CREAR_MensajeConfirmacion = Target.the("Mensaje de confirmación")
            .locatedBy("//*[@id='success-block-SUCCESS_EXPORT_LEVEL']/div[3]");
    public static final Target PERFILEX_CREAR_MensajeError = Target.the("Mensaje de error")
            .located(By.xpath("//*[@id='error-block-global']"));

}
