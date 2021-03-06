package tv.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.boot.env.YamlPropertySourceLoader;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;

/**
 * From Spring Boot 71.3 on customizing the Environment.
 */
public class SomethingYamlEnvironmentPostProcessor implements EnvironmentPostProcessor {

    private static final Resource[] RESOURCES = new Resource[]{new ClassPathResource("/something.yml")};

    private final YamlPropertySourceLoader loader = new YamlPropertySourceLoader();

    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment,
                                       SpringApplication application) {
        for (Resource path : RESOURCES) {
            PropertySource<?> propertySource = loadYaml(path);
            environment.getPropertySources().addLast(propertySource);
        }
    }

    private PropertySource<?> loadYaml(Resource path) {
        if (!path.exists()) {
            throw new IllegalArgumentException("Resource " + path + " does not exist");
        }
        try {
            return this.loader.load("somethings", path, null);
        } catch (IOException ex) {
            throw new IllegalStateException(
                    "Failed to load yaml configuration from " + path, ex);
        }
    }
}
