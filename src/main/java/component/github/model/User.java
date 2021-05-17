package component.github.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

    private Integer id;
    private String login;
    private String name;
    private String type;
    private String avatarUrl;
    private String createdAt;
    private Integer numberOfFollowers;
    private Integer numberOfRepos;

    public User(@JsonProperty("id") Integer id,
                @JsonProperty("login") String login,
                @JsonProperty("name") String name,
                @JsonProperty("type") String type,
                @JsonProperty("avatar_url") String avatarUrl,
                @JsonProperty("created_at") String createdAt,
                @JsonProperty("followers") Integer numberOfFollowers,
                @JsonProperty("public_repos") Integer numberOfRepos) {
        this.id = id;
        this.login = login;
        this.name = name;
        this.type = type;
        this.avatarUrl = avatarUrl;
        this.createdAt = createdAt;
        this.numberOfFollowers = numberOfFollowers;
        this.numberOfRepos = numberOfRepos;
    }
}
