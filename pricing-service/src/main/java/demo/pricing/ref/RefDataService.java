package demo.pricing.ref;

import demo.pricing.ref.model.InstrumentMapping;

import java.util.Set;

public interface RefDataService {

  Set<InstrumentMapping> getInstrumentMappings();
}
