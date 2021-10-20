package demo.pricing;

import demo.aspect.LogExecutionTime;
import demo.pricing.model.Price;
import demo.pricing.model.PricingEvent;
import demo.pricing.strategy.PricingStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;

import java.util.Map;

import static demo.pricing.strategy.Strategy.AGGRESSIVE;
import static demo.pricing.strategy.Strategy.PLAYING_IT_SAFE;

@Service
@RequiredArgsConstructor
public class PricingCalculator implements ApplicationEventPublisherAware {

  private ApplicationEventPublisher eventPublisher;
  private final Map<String, PricingStrategy> pricingStrategies;

  @LogExecutionTime
  public Price appraiseInstrument(final boolean beAggressive, final String instrumentCd) {
    Price price = beAggressive ? pricingStrategies.get(AGGRESSIVE).suggestPrice(instrumentCd) : pricingStrategies.get(PLAYING_IT_SAFE).suggestPrice(instrumentCd);

    eventPublisher.publishEvent(new PricingEvent(this, price));

    return price;
  }

  @Override
  public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
    eventPublisher = applicationEventPublisher;
  }
}
