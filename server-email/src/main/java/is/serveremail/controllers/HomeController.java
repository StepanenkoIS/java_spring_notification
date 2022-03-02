package is.serveremail.controllers;

import is.serveremail.model.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

  Logger logger = LoggerFactory.getLogger(HomeController.class);

  // Invoke-WebRequest -Uri "http://127.0.0.1:8081/sendtest"
  @GetMapping("/sendtest")
  public String sendEmailTest() {
    Message message = new Message("user@mail.ru", "app@mail.ru", "Notification", "Hello, Dear colleagues!");
    logger.info("email was sent: " + message);
    return "email was sent: " + message;
  }

  //Invoke-WebRequest -Uri "http://127.0.0.1:8081/send?to=email@mail.ru&from=app@mail.ru&title=Notification&body=emailText"
  @GetMapping("/send")
  public String sendSms(@RequestParam(value = "to", required = false) String to,
                        @RequestParam(value = "from", required = false) String from,
                        @RequestParam(value = "title", required = false) String title,
                        @RequestParam(value = "body", required = false) String body) {

    Message message = new Message(to, from, title, body);
    logger.info("email was sent: " + message);
    return "email was sent: " + message;
  }

}