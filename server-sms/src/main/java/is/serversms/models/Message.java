package is.serversms.models;


import lombok.*;

@Data
@AllArgsConstructor
public class Message {
  String to;
  String from;
  String body;
}
