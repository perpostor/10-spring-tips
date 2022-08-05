package demo.pricing.model;

import demo.pricing.strategy.Strategy;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class PricingEvent extends ApplicationEvent {

  private final Price price;
  private final Strategy strategy;

  public PricingEvent(Object source, Price price, Strategy strategy) {
    super(source);
    this.price = price;
    this.strategy = strategy;
  }

}
