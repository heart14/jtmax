package xyz.sadli.query.sys;

import javax.validation.constraints.NotEmpty;

/**
 * About:
 * Other:
 * Created: lwf14 on 2022/12/2 15:51.
 * Editored:
 */

public class LoginQuery {

    @NotEmpty
    private String phoneNumber;

    @NotEmpty
    private String password;


    public LoginQuery() {
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginQuery{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
