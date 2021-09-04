package com.example.springtips.strategy;

import org.springframework.stereotype.Service;

import static com.example.springtips.strategy.Strategy.AGGRESSIVE;

@Service(AGGRESSIVE)
public class AggressivePricingStrategy implements PricingStrategy {

  @Override
  public int suggestPrice() {
    return Integer.MAX_VALUE;
  }

}
