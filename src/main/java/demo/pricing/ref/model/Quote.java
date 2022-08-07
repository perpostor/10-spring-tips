package demo.pricing.ref.model;

import java.math.BigDecimal;
import lombok.RequiredArgsConstructor;

public record Quote(String ccyPair, BigDecimal bid, BigDecimal offer) {

}
