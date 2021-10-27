package demo.audit;

import demo.pricing.model.PricingEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AuditingService {

  @EventListener
  public void logAppraisal(PricingEvent event) {
    LOGGER.info("{} was appraised to: {} by the {} strategy", event.getPrice().getInstrumentCd(), event.getPrice().getPrice(), event.getStrategy());
  }
}
