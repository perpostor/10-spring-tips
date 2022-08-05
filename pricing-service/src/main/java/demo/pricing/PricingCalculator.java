package demo.pricing;

import demo.aspect.LogExecutionTime;
import demo.pricing.model.Price;
import demo.pricing.model.PricingEvent;
import demo.pricing.strategy.PricingStrategy;
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
  private final Map<String, PricingStrategy> pricingStrategies;

  @LogExecutionTime
  public Price appraiseInstrument(final Strategy strategy, final String instrumentCd) {
    Price price = pricingStrategies.get(strategy.toString()).determinePrice(instrumentCd);

    eventPublisher.publishEvent(new PricingEvent(this, price, strategy));

    return price;
  }

  @Override
  public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
    eventPublisher = applicationEventPublisher;
  }
}
