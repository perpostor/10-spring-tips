package demo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import demo.strategy.PricingStrategy;

import java.util.Map;

import static demo.strategy.Strategy.AGGRESSIVE;
import static demo.strategy.Strategy.PLAYING_IT_SAFE;

@Service
@RequiredArgsConstructor
public class PricingCalculator {

  private final Map<String, PricingStrategy> pricingStrategies;

  public int appraiseStock(boolean beAggressive) {
    return beAggressive ? pricingStrategies.get(AGGRESSIVE).suggestPrice() : pricingStrategies.get(PLAYING_IT_SAFE).suggestPrice();
  }

}
