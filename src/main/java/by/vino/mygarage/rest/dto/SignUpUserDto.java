package by.vino.mygarage.rest.dto;

import by.vino.mygarage.dao.jpa.Role;
import by.vino.mygarage.dao.jpa.RoleEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@NoArgsConstructor
@Getter
@Setter
public class SignUpUserDto {
    @NotNull
    @Size(min = 4, max = 32, message = "form.username.size")
    private String username;

    @NotNull
    @Size(min = 8, max = 20, message = "form.password.size")
    private String password;

    @NotNull
    private String firstname;

    @NotNull
    private String lastname;

    @NotNull
    private String phone;

    private Role role = new Role(RoleEnum.USER);
}
