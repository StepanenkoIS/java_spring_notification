package is.serversms.controllers;

import is.serversms.models.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

  Logger logger = LoggerFactory.getLogger(HomeController.class);

  // Invoke-WebRequest -Uri "http://127.0.0.1:8082/sendtest"
  @GetMapping("/sendtest")
  public String sendTest() {
    Message message = new Message("8-900-000-00-00", "Notification", "Hello, Dear colleagues!");
    logger.info("sms was sent: " + message);
    return "sms was sent: " + message;
  }

  //Invoke-WebRequest -Uri "http://127.0.0.1:8082/send?to=8(900)000-00&from=SMS&body=textsms"
  @GetMapping("/send")
  public String send(@RequestParam(value = "to", required = false) String to,
                        @RequestParam(value = "from", required = false) String from,
                        @RequestParam(value = "body", required = false) String body) {

    Message message = new Message(to, from, body);
    logger.info("sms was sent: " + message);
    return "sms was sent: " + message;
  }

}
