package is.serveremail.model;

import lombok.*;

@Data
@AllArgsConstructor
public class Message {
  String to;
  String from;
  String title;
  String body ;
}
