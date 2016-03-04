package tv.configuration;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SomethingBeanFactory {

	@Autowired
	private SomeConfigurationProperties someConfigurationProperties;

	public void initialize() {
		log.info("someConfigurationProperties: {}", someConfigurationProperties);

		for (Something something : someConfigurationProperties.getSomethings()) {
			log.info("something: {}", something);
		}
	}
}
