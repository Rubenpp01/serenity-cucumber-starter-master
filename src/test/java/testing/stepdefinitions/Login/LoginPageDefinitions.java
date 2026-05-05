package testing.stepdefinitions.Login;


import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import testing.questions.Login.SuccessLogin;
import testing.tasks.Login.ActiveSession;
import testing.tasks.Login.LoginCorporate;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class LoginPageDefinitions {


    @When("Inicia sesión con las credenciales {string},{string},{string}")
    public void iniciaSesiónConLasCredenciales(String company,String username,String password) {
        theActorInTheSpotlight().attemptsTo(
        LoginCorporate.conCredenciales(company,username,password ));
        ActiveSession.Continuar();
    }
    @Then("Debe iniciar sesión correctamente en corporate {string}")
    public void debeIniciarSesiónCorrectamente(String mensajeEsperado) {
        theActorInTheSpotlight().should(seeThat(SuccessLogin.loginExitoso(mensajeEsperado)));
    }

}
