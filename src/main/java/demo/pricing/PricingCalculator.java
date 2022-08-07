package demo.pricing;

import demo.aspect.LogExecutionTime;
import demo.pricing.model.QuotationEvent;
import demo.pricing.ref.model.Quote;
import demo.pricing.strategy.MarkupTemplate;
import demo.pricing.strategy.Strategy;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class PricingCalculator implements ApplicationEventPublisherAware {

  private ApplicationEventPublisher eventPublisher;
  private final Map<String, MarkupTemplate> pricingStrategies;

  @LogExecutionTime
  public Quote getQuote(final String clientId, final String ccyPair) {
    var strategy = determineStrategy(clientId);
    Quote rate = pricingStrategies.get(strategy.toString()).markupQuote(ccyPair);

    eventPublisher.publishEvent(new QuotationEvent(this, rate, clientId, strategy));

    return rate;
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
