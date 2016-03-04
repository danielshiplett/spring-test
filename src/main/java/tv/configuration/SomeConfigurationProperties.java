package tv.configuration;

import java.util.List;

import lombok.Data;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(locations = { "file:/etc/test/something.yml",
		"classpath:something.yml" }, merge = true)
@EnableConfigurationProperties
@Data
public class SomeConfigurationProperties {

	private List<Something> somethings;
}
