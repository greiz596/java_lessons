package diplom.task_3.data;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginUser {
    private String email;
    private String password;

    public LoginUser() {
    }

    public LoginUser(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
