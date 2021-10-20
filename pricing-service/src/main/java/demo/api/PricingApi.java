package demo.api;

import demo.pricing.PricingCalculator;
import demo.pricing.model.Price;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PricingApi {

  private final PricingCalculator pricingCalculator;

  @GetMapping("/price/{instrumentCd}")
  public Price getPriceForInstrument(@PathVariable("instrumentCd") final String instrumentCd) {
    return pricingCalculator.appraiseInstrument(true, instrumentCd);
  }

}
