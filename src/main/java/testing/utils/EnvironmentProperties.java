package testing.utils;

import net.serenitybdd.model.environment.EnvironmentSpecificConfiguration;
import net.thucydides.model.configuration.SystemPropertiesConfiguration;
import net.thucydides.model.environment.SystemEnvironmentVariables;
import net.thucydides.model.util.EnvironmentVariables;

public final class EnvironmentProperties {

    private static final SystemPropertiesConfiguration CONFIGURATION = new SystemPropertiesConfiguration(SystemEnvironmentVariables.createEnvironmentVariables());
    private static final EnvironmentVariables ENV_VARIABLES = CONFIGURATION.getEnvironmentVariables();

    private EnvironmentProperties() {
    }

    public static String getProperty(String nameProperty) {
        return EnvironmentSpecificConfiguration.from(ENV_VARIABLES).getProperty(nameProperty);
    }

    public static String getProperties() {

        return EnvironmentProperties.getProperties();
    }
}
