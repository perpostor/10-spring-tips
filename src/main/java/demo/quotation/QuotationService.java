package demo.quotation;

import demo.quotation.cache.RefDataCache;
import demo.quotation.model.Quote;
import java.math.BigDecimal;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QuotationService {

  public Quote getQuote(final String ccyPair) {
    return Optional.ofNullable(RefDataCache.getQuoteMappings().get(ccyPair))
        .orElse(new Quote(ccyPair, BigDecimal.valueOf(0.9), BigDecimal.valueOf(0.91)));
  }

}
