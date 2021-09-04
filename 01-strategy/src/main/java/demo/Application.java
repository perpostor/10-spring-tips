package demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@Slf4j
@SpringBootApplication
public class Application {

	@Autowired
	private PricingCalculator pricingCalculator;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@PostConstruct
	public void logPrices() {
		LOGGER.info("Aggressive price: {}", pricingCalculator.appraiseStock(true));
		LOGGER.info("Timid price: {}", pricingCalculator.appraiseStock(false));
	}

}
