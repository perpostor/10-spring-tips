package demo.pricing.strategy;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Random;

import static demo.pricing.Strategy.StrategyConstants.WOLF_OF_WALL_STREET;

@Component(WOLF_OF_WALL_STREET)
public class WolfOfWallStreetStrategy extends PricingStrategy {

  @Override
  BigDecimal getPriceForInstrument(BigDecimal coefficient, String instrumentCd) {
    return BigDecimal.valueOf(3.14)
            .multiply(BigDecimal.valueOf(new Random().nextInt()).abs())
            .multiply(coefficient);
  }

}
