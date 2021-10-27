package demo.pricing.cache;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class RefDataCache {

  private static final Map<String, BigDecimal> instrumentMappings = new HashMap<>();

  public static void updateInstrumentMappings(final Map<String, BigDecimal> newInstrumentMappings) {
    instrumentMappings.clear();
    instrumentMappings.putAll(newInstrumentMappings);
  }

  public static Map<String, BigDecimal> getInstrumentMappings() {
    return instrumentMappings;
  }

}
