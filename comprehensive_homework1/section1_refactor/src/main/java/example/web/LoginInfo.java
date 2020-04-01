package example.web;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class LoginInfo {

    @NotNull
    @Size(min = 3, max = 6, message = "{name.message}")
    private String userName;

    @NotNull
    @Size(min = 6, max = 6, message = "{password.message}")
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
