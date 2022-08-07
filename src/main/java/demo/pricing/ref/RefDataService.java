package demo.pricing.ref;

import demo.pricing.ref.model.Quote;

import java.util.Set;

public interface RefDataService {

  Set<Quote> getQuotes();
}
