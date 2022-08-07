package demo.quotation.ref.model;

import java.math.BigDecimal;

public record Quote(String ccyPair, BigDecimal bid, BigDecimal offer) {

}
