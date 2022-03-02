package is.serverpush.controllers;


import is.serverpush.model.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

  Logger logger = LoggerFactory.getLogger(HomeController.class);

  // Invoke-WebRequest -Uri "http://127.0.0.1:8083/sendtest"
  @GetMapping("/sendtest")
  public String sendTest() {
    Message message = new Message("is", "app1", "Notification", "Hello, Dear colleagues!", "app1", 30);
    logger.info("push was sent: " + message);
    return "push was sent: " + message;
  }

  //Invoke-WebRequest -Uri "http://127.0.0.1:8083/send?to=is&from=app1&title=Notification&body=pushText&click_action=app1&timeRelSec=30"
  @GetMapping("/send")
  public String sendSms(@RequestParam(value = "to", required = false) String to,
                        @RequestParam(value = "from", required = false) String from,
                        @RequestParam(value = "title", required = false) String title,
                        @RequestParam(value = "body", required = false) String body,
                        @RequestParam(value = "click_action", required = false) String click_action,
                        @RequestParam(value = "timeRelSec", required = false) int timeRelSec) {

    Message message = new Message(to, from, title, body, click_action, timeRelSec);
    logger.info("push was sent: " + message);
    return "push was sent: " + message;
  }




}
