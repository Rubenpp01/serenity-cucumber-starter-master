package testing.stepdefinitions.Pagos.CrearPlantillas;


import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import testing.questions.Pagos.CrearPlantillas.ErrorPlantilla;
import testing.questions.Pagos.CrearPlantillas.SuccessPlantilla;
import testing.tasks.Pagos.CrearPlantillas.PlantillaClaveYPago;
import testing.tasks.Pagos.CrearPlantillas.PlantillaFormularioRecaudo;
import testing.tasks.Pagos.CrearPlantillas.PlantillaModuloPagos;
import testing.tasks.Pagos.CrearPlantillas.SeleccionarTipoPlantilla;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class PlantillaRecaudosPageDefinitions {

    //Escenarios exitosos//

    //Creación plantilla recaudo directo//


    @When("Navega al módulo de pagos y plantillas selecciona la opción {string}")
    public void navegaAlModuloPagos (String tipoPago) {
        theActorInTheSpotlight().wasAbleTo(
                PlantillaModuloPagos.navegar(),
                SeleccionarTipoPlantilla.como(tipoPago)
        );
    }
    @When("Completar el formulario de recaudos con {string},{string},{string},{string}")
    public void llenaElFormularioDeRecaudosCon (String nombreplantilla, String limiteRec, String monto, String numeroref) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                PlantillaFormularioRecaudo.datosRecaudos(nombreplantilla, limiteRec, monto, numeroref)
                );
    }

    @When("Ingreso de la contraseña {string} y confirma el recaudo")
    public void IngresaLacontraseñapararecaudo (String clavePagos) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                PlantillaClaveYPago.con(clavePagos)

        );
    }
    @Then("Validacion mensaje de confirmación {string}")
    public void validarMensajeConfirmacion(String creacionExitosa) {
        theActorInTheSpotlight().should(seeThat(SuccessPlantilla.creacionExitosa(creacionExitosa)));
    }

//Plantilla recaudo directo sin monto//

    @Then("Validacion mensaje de error {string}")
    public void validacion_mensaje_de_error(String mensajeError) {
        theActorInTheSpotlight().should(seeThat(ErrorPlantilla.mensajeDeError(mensajeError)));
    }

//Plantilla recaudo directo validacion de limite de recaudo//

    @Then("Validacion mensaje de error limite de recaudo {string}")
    public void validacion_mensaje_de_error_limite_de_recaudo(String mensajeErrorLimite) {
        theActorInTheSpotlight().should(seeThat(ErrorPlantilla.mensajeDeError(mensajeErrorLimite)));
    }
}

