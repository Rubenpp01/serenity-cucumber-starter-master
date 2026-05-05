package testing.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;


@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty"},
        features = "src/test/resources/features/search/Cuentas/PerfilesdeExportacion/PerfilExpCrear.feature",
        glue = "testing/stepdefinitions",
        //snippets = CucumberOptions.SnippetType.CAMELCASE
        tags = "@PerfilExportacionCrear"
)
public class CucumberTestSuiteTest {}





