package demo.pricing.strategy;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

import static demo.pricing.strategy.Strategy.PLAYING_IT_SAFE;

@Service(PLAYING_IT_SAFE)
public class PlayingItSafeStrategy extends PricingStrategy {

  @Override
  BigDecimal getPriceForInstrument(String instrumentCd) {
    return BigDecimal.TEN;
  }
}
