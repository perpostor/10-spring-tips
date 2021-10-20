package demo.pricing.strategy;

import demo.pricing.cache.RefDataCache;
import demo.pricing.model.Price;

import java.math.BigDecimal;

public abstract class PricingStrategy {

  public Price suggestPrice(String instrumentCd) {
    final String updatedInstrumentCd = RefDataCache.getInstrumentMappings().get(instrumentCd);

    BigDecimal priceForInstrument = getPriceForInstrument(updatedInstrumentCd);

    return new Price(updatedInstrumentCd, priceForInstrument);
  }

  abstract BigDecimal getPriceForInstrument(String instrumentCd);
}
