package is.serverpush.model;

import lombok.*;

@Data
@AllArgsConstructor
public class Message {
  String to;
  String from;
  String title;
  String body;
  String click_action;
  int timeRelSec;
}
