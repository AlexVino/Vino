package by.vino.mygarage.rest.dto;

import by.vino.mygarage.dao.jpa.Role;
import by.vino.mygarage.dao.jpa.RoleEnum;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import static javax.validation.constraints.Pattern.Flag.UNICODE_CASE;

public class SignUpUserDto {
    @NotNull(message = "form.username.empty")
    @Size(min = 4, max = 20, message = "form.username.size")
    @Pattern(regexp = "[a-zA-Z0-9-.]+", message = "form.username.size")
    private String username;

    @NotNull
    @Size(min = 4, max = 20, message = "form.password.size")
    private String password;

    @NotNull
    @Size(min = 4, max = 30, message = "form.firstname.size")
    private String firstname;

    @NotNull
    @Size(min = 4, max = 30, message = "form.lastname.size")
    private String lastname;

    @NotNull
    @Size(min = 4, max = 20, message = "form.phone.size")
    @Pattern(regexp = "[\\d]+", flags = {UNICODE_CASE},message = "form.phone.pattern")
    private String phone;

    @NotNull
    @Size(min = 5, max = 255, message = "form.email.size")
    @Pattern(regexp="^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", flags = {UNICODE_CASE},message = "form.email.pattern")
    private String email;

    private Role role = new Role(RoleEnum.ROLE_USER);

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
