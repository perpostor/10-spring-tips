package demo.pricing.cache;

import demo.pricing.ref.model.Quote;
import java.util.HashMap;
import java.util.Map;

public class RefDataCache {

  private static final Map<String, Quote> quoteMappings = new HashMap<>();

  public static void updateQuoteMappings(final Map<String, Quote> newQuoteMappings) {
    quoteMappings.clear();
    quoteMappings.putAll(newQuoteMappings);
  }

  public static Map<String, Quote> getQuoteMappings() {
    return quoteMappings;
  }

}
