package in.kuros;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MailContext {
    private String from;
    private String to;
    private String subject;
    private String message;
}
