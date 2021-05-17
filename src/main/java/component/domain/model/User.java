package component.domain.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class User {

    private Integer id;
    private String login;
    private String name;
    private String type;
    private String avatarUrl;
    private String createdAt;
    private Integer numberOfFollowers;
    private Integer numberOfRepos;
    private Double calculations;
}
