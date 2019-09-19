package ioc;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter@Setter@Component
public class User {
    public String name;
    public String password;
    public int age;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                '}';
    }
}
