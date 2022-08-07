package demo.quotation.strategy;

import demo.quotation.cache.RefDataCache;
import demo.quotation.ref.model.Quote;
import java.math.BigDecimal;
import java.util.Optional;

public abstract class MarkupTemplate {

  public Quote markupQuote(String ccyPair) {
    final Quote defaultQuote = Optional.ofNullable(RefDataCache.getQuoteMappings().get(ccyPair))
            .orElse(new Quote(ccyPair, BigDecimal.valueOf(0.9), BigDecimal.valueOf(0.91)));

    BigDecimal markup = getMarkup(defaultQuote, ccyPair);

    return new Quote(ccyPair, markup.add(defaultQuote.bid()), markup.add(defaultQuote.offer()));
  }

  abstract BigDecimal getMarkup(Quote defaultQuote, String ccyPair);
}
