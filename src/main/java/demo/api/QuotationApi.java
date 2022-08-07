package demo.api;

import demo.pricing.PricingCalculator;
import demo.pricing.ref.model.Quote;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class QuotationApi {

  private final PricingCalculator pricingCalculator;

  @GetMapping("/quote/{ccyPair}")
  public Quote getQuote(@PathVariable("ccyPair") final String ccyPair,
                                     @RequestParam("clientId") final String clientId,
                                     @RequestParam Map<String, String> requestParams,
                                     @RequestHeader Map<String, String> headers) {
    LOGGER.info("Headers in the request: {}", headers);
    LOGGER.info("Request params in the request: {}", requestParams);

    return pricingCalculator.getQuote(clientId, ccyPair);
  }

}
