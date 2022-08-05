package demo.api;

import demo.pricing.PricingCalculator;
import demo.pricing.strategy.Strategy;
import demo.pricing.model.Price;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PricingApi {

  private final PricingCalculator pricingCalculator;

  @GetMapping("/price/{strategy}/{instrumentCd}")
  public Price getPriceForInstrument(@PathVariable("strategy") final Strategy strategy,
                                     @PathVariable("instrumentCd") final String instrumentCd,
                                     @RequestHeader Map<String, String> headers) {
    LOGGER.info("Headers in the request: {}", headers);

    return pricingCalculator.appraiseInstrument(strategy, instrumentCd);
  }

}
