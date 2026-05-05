package testing.questions.Pagos.CrearPlantillas;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.ensure.Ensure;
import testing.ui.pagos.Recaudos.RecaudosDirectos;
import testing.ui.pagos.crearPlantillas.PlantillaRecaudos;

public class SuccessPlantilla implements Question<Boolean> {
    private final String creacionExitosa;

    public SuccessPlantilla(String creacionExitosa) {
        this.creacionExitosa = creacionExitosa;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        actor.attemptsTo(
                Ensure.that(PlantillaRecaudos.PLANTILLA_RECAUDO_SUCCESS).isDisplayed(),
                Ensure.that(PlantillaRecaudos.PLANTILLA_RECAUDO_SUCCESS).text().contains(creacionExitosa)
        );
        return true;
    }

    public static SuccessPlantilla creacionExitosa (String creacionExitosa) {
        return new SuccessPlantilla(creacionExitosa);
    }

}


