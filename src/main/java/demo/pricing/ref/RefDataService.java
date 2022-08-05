package demo.pricing.ref;

import demo.pricing.ref.model.InstrumentCoefficientMapping;

import java.util.Set;

public interface RefDataService {

  Set<InstrumentCoefficientMapping> getInstrumentCoefficientMappings();
}
