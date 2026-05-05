package testing.stepdefinitions.commons;


import io.cucumber.java.en.Given;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;

public class StepUrl {
    private static final String PAGE_URL = "pages.url";

    @Given("{string} abre la página web")
    public void abreLaPáginaWeb(String actor) {
        OnStage.theActorCalled(actor);
        OnStage.theActorInTheSpotlight().wasAbleTo(Open.browserOn().thePageNamed(PAGE_URL));
    }
}
