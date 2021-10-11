package demo.runner;

import demo.event.RunnerReadyEvent;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SampleApplicationRunner implements ApplicationRunner, ApplicationEventPublisherAware {

    private ApplicationEventPublisher publisher;

    @SneakyThrows
    @Override
    public void run(ApplicationArguments args) {
        LOGGER.info("I'm running a task on startup and I have a fancy way to interface with the arguments!");
        var optionValues = args.getOptionValues("some-option");
        Thread.sleep(1000);
        LOGGER.info("I'm done with my task! I also saw the values of option-value and they are: {}", optionValues);

        publisher.publishEvent(new RunnerReadyEvent(this, "The SampleApplicationRunner is done with its task!"));
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        publisher = applicationEventPublisher;
    }
}
