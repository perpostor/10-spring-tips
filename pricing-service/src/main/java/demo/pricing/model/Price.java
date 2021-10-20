package demo.pricing.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@Data
@RequiredArgsConstructor
public class Price {

  private final String instrumentCd;
  private final BigDecimal price;

}
