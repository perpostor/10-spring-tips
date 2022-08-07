package demo.quotation.model;

import java.math.BigDecimal;

public record Quote(String ccyPair, BigDecimal bid, BigDecimal offer) {

}
