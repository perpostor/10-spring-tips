package demo.pricing.strategy;

import demo.pricing.cache.RefDataCache;
import demo.pricing.model.Price;

import java.math.BigDecimal;
import java.util.Optional;

public abstract class PricingStrategy {

  public Price determinePrice(String instrumentCd) {
    final BigDecimal coefficient = Optional.ofNullable(RefDataCache.getInstrumentMappings().get(instrumentCd))
            .orElse(BigDecimal.ONE);

    BigDecimal priceForInstrument = getPriceForInstrument(coefficient, instrumentCd);

    return new Price(instrumentCd, priceForInstrument);
  }

  abstract BigDecimal getPriceForInstrument(BigDecimal coefficient, String instrumentCd);
}
