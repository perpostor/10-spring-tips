package demo.strategy;

import org.springframework.stereotype.Service;

import static demo.strategy.Strategy.PLAYING_IT_SAFE;

@Service(PLAYING_IT_SAFE)
public class PlayingItSafeStrategy implements PricingStrategy {

  @Override
  public int suggestPrice() {
    return 10;
  }
}
