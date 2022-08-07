package demo.pricing.strategy;

import demo.pricing.ref.model.Quote;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

import static demo.pricing.strategy.Strategy.StrategyConstants.SAFE;

@Service(SAFE)
public class PlayingItSafeStrategy extends MarkupTemplate {

  @Override
  BigDecimal getMarkup(Quote defaultQuote, String ccyPair) {
    return BigDecimal.valueOf(0);
  }
}
