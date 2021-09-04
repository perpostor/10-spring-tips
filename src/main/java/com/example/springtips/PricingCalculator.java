package com.example.springtips;

import com.example.springtips.strategy.PricingStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebAutoConfiguration;
import org.springframework.stereotype.Service;

import java.util.Map;

import static com.example.springtips.strategy.Strategy.AGGRESSIVE;
import static com.example.springtips.strategy.Strategy.PLAYING_IT_SAFE;

@Service
@RequiredArgsConstructor
public class PricingCalculator {

  private final Map<String, PricingStrategy> pricingStrategies;

  public int appraiseStock(boolean beAggressive) {
    return beAggressive ? pricingStrategies.get(AGGRESSIVE).suggestPrice() : pricingStrategies.get(PLAYING_IT_SAFE).suggestPrice();
  }

}
