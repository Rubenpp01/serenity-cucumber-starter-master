package testing.ui.Login;

import net.serenitybdd.screenplay.targets.Target;

public class HomeCorporatePage {

    private HomeCorporatePage() { }

    public static final Target WELCOME_TEXT = Target.the("Bienvenido")
            .locatedBy("//*[@id='user-section']/div/div[1]/span");

}

