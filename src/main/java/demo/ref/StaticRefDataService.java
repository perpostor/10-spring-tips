package demo.ref;

import demo.quotation.ref.RefDataService;
import demo.quotation.ref.model.Quote;
import java.math.BigDecimal;
import java.util.Set;
import org.springframework.stereotype.Service;

@Service
public class StaticRefDataService implements RefDataService {

  @Override
  public Set<Quote> getQuotes() {
    var quoteGBPUSD = new Quote("GBPUSD", BigDecimal.valueOf(1.31200), BigDecimal.valueOf(1.31210));
    var quoteEURGBP = new Quote("EURGBP", BigDecimal.valueOf(0.91151), BigDecimal.valueOf(0.91156));
    var quoteGBPPLN = new Quote("GBPPLN", BigDecimal.valueOf(4.98363), BigDecimal.valueOf(4.98540));
    var quoteJPYRON = new Quote("JPYRON", BigDecimal.valueOf(0.03814), BigDecimal.valueOf(0.03891));

    return Set.of(quoteEURGBP, quoteGBPUSD, quoteGBPPLN, quoteJPYRON);
  }
}
