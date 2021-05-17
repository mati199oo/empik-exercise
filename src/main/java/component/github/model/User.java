package component.github.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (!Objects.equals(id, user.id)) return false;
        if (!Objects.equals(login, user.login)) return false;
        if (!Objects.equals(name, user.name)) return false;
        if (!Objects.equals(type, user.type)) return false;
        if (!Objects.equals(avatarUrl, user.avatarUrl)) return false;
        if (!Objects.equals(createdAt, user.createdAt)) return false;
        if (!Objects.equals(numberOfFollowers, user.numberOfFollowers))
            return false;
        return Objects.equals(numberOfRepos, user.numberOfRepos);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (avatarUrl != null ? avatarUrl.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (numberOfFollowers != null ? numberOfFollowers.hashCode() : 0);
        result = 31 * result + (numberOfRepos != null ? numberOfRepos.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", login='" + login + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", avatarUrl='" + avatarUrl + '\'' +
                ", createdAt=" + createdAt +
                ", numberOfFollowers=" + numberOfFollowers +
                ", numberOfRepos=" + numberOfRepos +
                '}';
    }
}
