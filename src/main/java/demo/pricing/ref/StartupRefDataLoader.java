package demo.pricing.ref;

import demo.pricing.cache.RefDataCache;
import demo.pricing.ref.model.InstrumentCoefficientMapping;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Map;
import java.util.stream.Collectors;

@Component
@Slf4j
@RequiredArgsConstructor
public class StartupRefDataLoader implements CommandLineRunner {

  private final RefDataService refDataService;

  @Override
  public void run(String... args) {
    LOGGER.info("Loading reference data into the cache");
    var rawInstrumentMappings = refDataService.getInstrumentCoefficientMappings();
    Map<String, BigDecimal> instrumentMappings = rawInstrumentMappings
            .stream()
            .collect(Collectors.toMap(InstrumentCoefficientMapping::getInstrumentCd, InstrumentCoefficientMapping::getCoefficient));
    RefDataCache.updateInstrumentMappings(instrumentMappings);
    LOGGER.info("Loaded reference data into the cache");
  }
}
