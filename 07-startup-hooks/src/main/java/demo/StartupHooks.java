package demo;

import demo.listener.ApplicationPreparedListener;
import demo.listener.ApplicationStartingListener;
import demo.listener.ContextInitializedListener;
import demo.listener.EnvironmentPreparedListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StartupHooks {

	public static void main(String[] args) {
		SpringApplication demo = new SpringApplication(StartupHooks.class);

		demo.addListeners(new ApplicationStartingListener());
		demo.addListeners(new EnvironmentPreparedListener());
		demo.addListeners(new ContextInitializedListener());
		demo.addListeners(new ApplicationPreparedListener());

		demo.run(args);
	}

}
