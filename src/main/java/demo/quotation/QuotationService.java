package demo.quotation;

import demo.aspect.LogExecutionTime;
import demo.quotation.model.Quote;
import demo.quotation.strategy.MarkupTemplate;
import demo.quotation.strategy.Strategy;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QuotationService {

  private final Map<String, MarkupTemplate> markupStrategies;

  @LogExecutionTime
  public Quote getQuote(final String clientId, final String ccyPair) {
    var strategy = determineStrategy(clientId);

    return markupStrategies.get(strategy.toString()).markupQuote(ccyPair);
  }

  private Strategy determineStrategy(final String clientId) {
    return switch(clientId) {
      case "1" -> Strategy.AGGRESSIVE;
      case "2" -> Strategy.WOLF_OF_WALL_STREET;
      default -> Strategy.SAFE;
    };
  }

}
