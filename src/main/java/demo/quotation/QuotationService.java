package demo.quotation;

import demo.aspect.LogExecutionTime;
import demo.quotation.model.QuotationEvent;
import demo.quotation.ref.model.Quote;
import demo.quotation.strategy.MarkupTemplate;
import demo.quotation.strategy.Strategy;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.actuate.audit.listener.AuditApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class QuotationService implements ApplicationEventPublisherAware {

  private ApplicationEventPublisher eventPublisher;
  private final Map<String, MarkupTemplate> markupStrategies;

  @LogExecutionTime
  public Quote getQuote(final String clientId, final String ccyPair) {
    var strategy = determineStrategy(clientId);
    Quote quote = markupStrategies.get(strategy.toString()).markupQuote(ccyPair);

    eventPublisher.publishEvent(new QuotationEvent(this, quote, clientId, strategy));
    eventPublisher.publishEvent(new AuditApplicationEvent(clientId, "Quotation", Map.of("strategy", strategy, "quote", quote)));

    return quote;
  }

  private Strategy determineStrategy(final String clientId) {
    return switch(clientId) {
      case "1" -> Strategy.AGGRESSIVE;
      case "2" -> Strategy.WOLF_OF_WALL_STREET;
      default -> Strategy.SAFE;
    };
  }

  @Override
  public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
    eventPublisher = applicationEventPublisher;
  }
}
