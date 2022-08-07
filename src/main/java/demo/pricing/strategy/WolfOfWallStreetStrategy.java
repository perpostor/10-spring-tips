package demo.pricing.strategy;

import demo.pricing.ref.model.Quote;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Random;

import static demo.pricing.strategy.Strategy.StrategyConstants.WOLF_OF_WALL_STREET;

@Component(WOLF_OF_WALL_STREET)
public class WolfOfWallStreetStrategy extends MarkupTemplate {

  @Override
  BigDecimal getMarkup(Quote defaultQuote, String ccyPair) {
    // Some smart logic based on defaultQuote and ccyPair
    return BigDecimal.valueOf(new Random().nextDouble()).abs();
  }

}
