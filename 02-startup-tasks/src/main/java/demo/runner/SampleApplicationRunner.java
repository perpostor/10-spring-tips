package demo.runner;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@Order(1)
public class SampleApplicationRunner implements ApplicationRunner {

    @SneakyThrows
    @Override
    public void run(ApplicationArguments args) {
        LOGGER.info("I'm also running a task on startup and I have a fancy way to interface with the arguments!");
        var optionValues = args.getOptionValues("some-option");
        Thread.sleep(1000);
        LOGGER.info("I'm done with my task! I also saw the values of option-value and they are: {}", optionValues);
    }
}
