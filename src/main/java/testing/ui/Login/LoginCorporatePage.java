package testing.ui.Login;

import net.serenitybdd.screenplay.targets.Target;

public class LoginCorporatePage {

    private LoginCorporatePage() { }

    public static final Target COMPANY = Target.the("Campo de ingreso código de compañia")
            .locatedBy("//*[@id='model_organizationId']");
    public static final Target USERNAME= Target.the("Campo de ingreso id usuario")
            .locatedBy("//*[@id='model_userId']");
    public static final Target PASSWORD = Target.the("Campo de contraseña")
            .locatedBy("//*[@id='model_password']");
    public static final Target LANGUAGE_ABRIR_SELECT = Target.the("Lista de seleccion de lenguaje")
            .locatedBy("//*[@id='model_languagecombobox']/span");
    public static final Target LANGUAGE_SELECT_ESPANOL = Target.the("Campo de selección de lenguaje español")
            .locatedBy("//*[@id='model_language_option_es_co']/span");
    public static final Target SUBMIT_BUTTON = Target.the("Botón login")
            .locatedBy("//*[@id='btnLogin']");
    public static final Target CONTINUE_BUTTON = Target.the("Botón continuar sesión activa")
            .locatedBy("//*[@id='btnContinue']");
}



