package demo.config;

import demo.beans.BeanOne;
import demo.beans.BeanThree;
import demo.beans.BeanTwo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

  @Bean
  public BeanOne beanOne() {
    return new BeanOne();
  }

  @Bean
  public BeanTwo beanTwo() {
    return new BeanTwo(beanOne());
  }


  @Bean
  public BeanThree beanThree() {
    // will still get the same bean as beanTwo - singleton scope by default
    return new BeanThree(beanOne());
  }
}
