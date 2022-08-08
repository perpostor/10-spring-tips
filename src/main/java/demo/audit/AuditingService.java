package demo.audit;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AuditingService {

  @SneakyThrows
  @EventListener
  public void logAppraisal(QuotationEvent event) {
    Thread.sleep(1000);
    LOGGER.info(
        "{} was appraised to Bid: {} and Offer: {} using the {} strategy",
        event.getQuote().ccyPair(),
        event.getQuote().bid(),
        event.getQuote().offer(),
        event.getStrategy());
  }
}
