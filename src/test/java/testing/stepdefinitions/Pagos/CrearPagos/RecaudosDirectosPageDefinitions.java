package testing.stepdefinitions.Pagos.CrearPagos;


import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import net.serenitybdd.screenplay.actors.OnStage;


import testing.tasks.Pagos.Recaudos.ClaveYPago;
import testing.tasks.Pagos.Recaudos.FormularioRecaudo;
import testing.tasks.Pagos.Recaudos.ModuloPagos;
import testing.tasks.Pagos.Recaudos.SeleccionarTipoPago;
import testing.questions.Pagos.Recaudos.SuccessUnica;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class RecaudosDirectosPageDefinitions {

    //Escenarios exitosos//

    //Creación de recaudo directo//

    @When("Navega al módulo de pagos y selecciona la opción {string}")
    public void navegaAlModuloPagos (String tipoPago) {
        theActorInTheSpotlight().wasAbleTo(
                ModuloPagos.navegar(),
                SeleccionarTipoPago.como(tipoPago)
        );
    }
    @When("Llena el formulario de recaudos directos con {string},{string}")
    public void llenaElFormularioDeRecaudosCon (String monto, String numeroref) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                FormularioRecaudo.datosRecaudos(monto, numeroref)
                );
    }

    @When("Ingresa la contraseña {string} y confirma el recaudo")
    public void IngresaLacontraseñapararecaudo (String clavePagos) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                ClaveYPago.con(clavePagos)

        );
    }
    @Then("Visualiza mensaje de confirmación {string}")
    public void validarMensajeConfirmacion(String creacionExitosa) {
        theActorInTheSpotlight().should(seeThat(SuccessUnica.creacionExitosa(creacionExitosa)));
    }


}

