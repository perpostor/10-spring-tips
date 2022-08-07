package demo.quotation.ref;

import demo.quotation.cache.RefDataCache;
import demo.quotation.ref.model.Quote;
import java.util.function.Function;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

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

    var rawCcyPairMappings = refDataService.getQuotes();
    Map<String, Quote> ccyPairMappings = rawCcyPairMappings
            .stream()
            .collect(Collectors.toMap(Quote::ccyPair, Function.identity()));

    RefDataCache.updateQuoteMappings(ccyPairMappings);

    LOGGER.info("Loaded reference data into the cache");
  }
}
