package demo.pricing.strategy;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

import static demo.pricing.strategy.Strategy.StrategyConstants.AGGRESSIVE;

@Service(AGGRESSIVE)
public class AggressivePricingStrategy extends PricingStrategy {

  @Override
  BigDecimal getPriceForInstrument(BigDecimal coefficient, String instrumentCd) {
    return BigDecimal.valueOf(Integer.MAX_VALUE).multiply(coefficient);
  }

}
