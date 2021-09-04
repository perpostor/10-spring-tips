package demo.strategy;

import org.springframework.stereotype.Service;

import static demo.strategy.Strategy.AGGRESSIVE;

@Service(AGGRESSIVE)
public class AggressivePricingStrategy implements PricingStrategy {

  @Override
  public int suggestPrice() {
    return Integer.MAX_VALUE;
  }

}
