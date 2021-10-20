package demo.pricing.model;

import org.springframework.context.ApplicationEvent;

public class PricingEvent extends ApplicationEvent {

  private final Price price;

  public PricingEvent(Object source, Price price) {
    super(source);
    this.price = price;
  }

  public Price getPrice() {
    return price;
  }
}
