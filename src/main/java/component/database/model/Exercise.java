package component.database.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
public class Exercise {

    @Id
    private String login;
    private Integer requestCount;

    public Exercise() {}
}