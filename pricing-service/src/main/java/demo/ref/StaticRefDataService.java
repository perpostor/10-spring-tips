package demo.ref;

import demo.pricing.ref.RefDataService;
import demo.pricing.ref.model.InstrumentMapping;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class StaticRefDataService implements RefDataService {

  @Override
  public Set<InstrumentMapping> getInstrumentMappings() {
    var instrumentMapping_APPL = new InstrumentMapping("APPL", "APPLE");
    var instrumentMapping_GOGL = new InstrumentMapping("GOGL", "GOOGLE");

    return Set.of(instrumentMapping_APPL, instrumentMapping_GOGL);
  }
}
