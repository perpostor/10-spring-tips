package demo.ref;

import demo.ref.model.InstrumentMapping;

import java.util.Set;

public interface RefDataService {

  Set<InstrumentMapping> getInstrumentMappings();
}
