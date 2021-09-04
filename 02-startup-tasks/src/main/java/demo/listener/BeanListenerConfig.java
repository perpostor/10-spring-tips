package demo.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class BeanListenerConfig {

    @EventListener
    public void appStarted(ApplicationStartedEvent event) {
        LOGGER.info("The ApplicationStartedEvent has been fired. The context was refreshed, but no command-line or application runners have been called yet.");
    }

    @EventListener
    public void appReady(ApplicationReadyEvent event) {
        LOGGER.info("The ApplicationReadyEvent has been fired. Command-line and application runners have been called and are completed.");
    }
}
