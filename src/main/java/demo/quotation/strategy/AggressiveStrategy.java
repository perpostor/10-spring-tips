package demo.quotation.strategy;

import demo.quotation.model.Quote;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

import static demo.quotation.strategy.Strategy.StrategyConstants.AGGRESSIVE;

@Service(AGGRESSIVE)
public class AggressiveStrategy extends MarkupTemplate {

  @Override
  BigDecimal getMarkup(Quote defaultQuote, String ccyPair) {
    // Some smart logic based on defaultQuote and ccyPair
    return BigDecimal.valueOf(0.3);
  }

}
