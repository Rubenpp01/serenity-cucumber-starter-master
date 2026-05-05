package testing.stepdefinitions.Cuentas.HerramientasdeCuentas.PerfilesdeExportacion;


import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import testing.questions.Cuentas.HerramientasdeCuentas.PerfilesdeExportacion.ErrorPerfilCrear;
import testing.questions.Cuentas.HerramientasdeCuentas.PerfilesdeExportacion.SuccessPerfilCrear;
import testing.tasks.Cuentas.HerramientasdeCuentas.PerfilesdeExportacion.FormularioPerfilExportacion;
import testing.tasks.Cuentas.HerramientasdeCuentas.PerfilesdeExportacion.ModuloCuentasPerfilExp;
import testing.tasks.Cuentas.HerramientasdeCuentas.PerfilesdeExportacion.SeleccionarPerfilExportacion;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class PerfilesdeExportacion {

    //Escenarios exitosos//
    //Creación Perfil de exportacion//


    @When("Navega al módulo de cuentas selecciona la opción {string}")
    public void NavegaAlModuloDeCuentasYSeleccionaLaOpcion (String perfilExpo) {
        theActorInTheSpotlight().wasAbleTo(
                ModuloCuentasPerfilExp.navegar(),
                SeleccionarPerfilExportacion.como(perfilExpo)
        );
    }
    @When("Completar el formulario del perfil con {string},{string}")
    public void CompletarElFormularioDePerfilExportacion (String descripcionperfil, String nombreperfil) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                FormularioPerfilExportacion.datosPerfil(descripcionperfil, nombreperfil)
                );
    }
    @Then("Validacion mensaje de confirmación Perfil{string}")
    public void validarMensajeConfirmacionPerfil(String PerfilcreadoExitosa) {
        theActorInTheSpotlight().should(seeThat(SuccessPerfilCrear.PerfilcreadoExitosa(PerfilcreadoExitosa)));
    }

}

