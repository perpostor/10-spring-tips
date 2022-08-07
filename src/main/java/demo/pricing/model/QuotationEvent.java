package demo.pricing.model;

import demo.pricing.ref.model.Quote;
import demo.pricing.strategy.Strategy;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class QuotationEvent extends ApplicationEvent {

  private final Quote quote;
  private final String clientId;
  private final Strategy strategy;

  public QuotationEvent(Object source, Quote quote, String clientId, Strategy strategy) {
    super(source);
    this.quote = quote;
    this.clientId = clientId;
    this.strategy = strategy;
  }

}
