package demo.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api")
public class DemoApi {

  @GetMapping("/params")
  public Object params(@RequestParam("param1") final String param1,
                     @RequestParam("param2") final String param2,
                     @RequestParam Map<String, String> allParams) {
    LOGGER.info("I know about param1-{} and param2-{}, but I didn't know about the other {} params you sent me!",
            param1, param2, allParams.size() - 2);

    return allParams;
  }

  @GetMapping("/headers")
  public Object headers(@RequestHeader("Accept") final String accept,
                     @RequestHeader("Keep-Alive") final String keepAlive,
                     @RequestHeader Map<String, String> allHeaders) {
    LOGGER.info("I know about accept-{} and keepAlive-{}, but I didn't know about the other {} params you sent me!",
            accept, keepAlive, allHeaders.size() - 2);

    return allHeaders;
  }
}
