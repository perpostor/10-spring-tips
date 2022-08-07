package demo.audit;

import demo.pricing.model.QuotationEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AuditingService {

  @EventListener
  public void logAppraisal(QuotationEvent event) {
    LOGGER.info(
        "{} was appraised to Bid: {} and Offer: {} using the {} strategy",
        event.getQuote().ccyPair(),
        event.getQuote().bid(),
        event.getQuote().offer(),
        event.getStrategy());
  }
}
