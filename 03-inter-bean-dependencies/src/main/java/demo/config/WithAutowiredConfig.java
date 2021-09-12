package demo.config;

import demo.beans.BeanFour;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WithAutowiredConfig {

  @Autowired
  private AppConfig appConfig;

  @Bean
  public BeanFour beanFour() {
    return new BeanFour(appConfig.beanThree());
  }

}

