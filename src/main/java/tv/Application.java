package tv;

import java.net.UnknownHostException;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import tv.configuration.SomethingBeanFactory;

@SpringBootApplication
@Slf4j
public class Application implements CommandLineRunner {

	@Autowired
	private SomethingBeanFactory somethingBeanFactory;

	public static void main(String[] args) throws UnknownHostException {
		SpringApplication app = new SpringApplication(Application.class);
		app.run(args).getEnvironment();
	}

	@Override
	public void run(String... args) throws Exception {

		somethingBeanFactory.initialize();

		log.info("ctrl-c to quit");

		Thread.currentThread().join();
	}
}
