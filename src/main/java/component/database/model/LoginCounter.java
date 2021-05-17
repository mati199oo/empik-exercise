package component.database.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "EXERCISE")
public class LoginCounter {

    @Id
    @Column(name = "LOGIN", nullable = false)
    private String login;

    @Column(name = "REQUEST_COUNT", nullable = false)
    private Integer requestCount;

    public LoginCounter() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LoginCounter)) return false;

        LoginCounter that = (LoginCounter) o;

        if (!Objects.equals(login, that.login)) return false;
        return Objects.equals(requestCount, that.requestCount);
    }

    @Override
    public int hashCode() {
        int result = login != null ? login.hashCode() : 0;
        result = 31 * result + (requestCount != null ? requestCount.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "LoginCounter{" +
                "login='" + login + '\'' +
                ", requestCount=" + requestCount +
                '}';
    }
}