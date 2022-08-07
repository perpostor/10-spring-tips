package demo.api;

import demo.quotation.QuotationService;
import demo.quotation.model.Quote;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class QuotationApi {

  private final QuotationService quotationService;

  @GetMapping("/quote/{ccyPair}")
  public Quote getQuote(@PathVariable("ccyPair") final String ccyPair) {

    return quotationService.getQuote(ccyPair);
  }

}
