package demo.ref;

import demo.pricing.ref.RefDataService;
import demo.pricing.ref.model.InstrumentCoefficientMapping;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Set;

@Service
public class StaticRefDataService implements RefDataService {

  @Override
  public Set<InstrumentCoefficientMapping> getInstrumentCoefficientMappings() {
    var instrumentMapping_APPL = new InstrumentCoefficientMapping("APPL", BigDecimal.valueOf(1.2));
    var instrumentMapping_GOGL = new InstrumentCoefficientMapping("GOGL", BigDecimal.valueOf(1.1));
    var instrumentMapping_AMZN = new InstrumentCoefficientMapping("AMZN", BigDecimal.valueOf(1.5));
    var instrumentMapping_MSFT = new InstrumentCoefficientMapping("MSFT", BigDecimal.valueOf(1.1));

    return Set.of(instrumentMapping_APPL, instrumentMapping_GOGL, instrumentMapping_AMZN, instrumentMapping_MSFT);
  }
}
