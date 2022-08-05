package demo.pricing.strategy;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

import static demo.pricing.strategy.Strategy.StrategyConstants.SAFE;

@Service(SAFE)
public class PlayingItSafeStrategy extends PricingStrategy {

  @Override
  BigDecimal getPriceForInstrument(BigDecimal coefficient, String instrumentCd) {
    return BigDecimal.TEN.multiply(coefficient);
  }
}
