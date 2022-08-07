package demo.quotation.strategy;

import demo.quotation.ref.model.Quote;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

import static demo.quotation.strategy.Strategy.StrategyConstants.SAFE;

@Service(SAFE)
public class PlayingItSafeStrategy extends MarkupTemplate {

  @Override
  BigDecimal getMarkup(Quote defaultQuote, String ccyPair) {
    return BigDecimal.valueOf(0);
  }
}
