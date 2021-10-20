package demo.pricing.cache;

import java.util.HashMap;
import java.util.Map;

public class RefDataCache {

  private static final Map<String, String> instrumentMappings = new HashMap<>();

  public static void updateInstrumentMappings(final Map<String, String> newInstrumentMappings) {
    instrumentMappings.clear();
    instrumentMappings.putAll(newInstrumentMappings);
  }

  public static Map<String, String> getInstrumentMappings() {
    return instrumentMappings;
  }

}
