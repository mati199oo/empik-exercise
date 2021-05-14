package component.view.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class User {

    private String id;
    private String login;
    private String name;
    private String type;
    private String avatarUrl;
    private LocalDate createdAt;
    private Double calculations;
}
