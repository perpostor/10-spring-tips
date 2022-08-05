package demo.pricing.ref.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@Data
@RequiredArgsConstructor
public class InstrumentCoefficientMapping {

  private final String instrumentCd;
  private final BigDecimal coefficient;
}
