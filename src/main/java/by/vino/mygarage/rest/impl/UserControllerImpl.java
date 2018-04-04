package by.vino.mygarage.rest.impl;

import by.vino.mygarage.dao.jpa.User;
import by.vino.mygarage.rest.dto.SignUpUserDto;
import by.vino.mygarage.service.api.UserService;
import by.vino.mygarage.util.SecurityHelper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/rest/users")
public class UserControllerImpl {
    @Autowired
    private UserService userService;
    @Autowired
    private SecurityHelper securityHelper;
    @Autowired
    private BCryptPasswordEncoder encoder;
    @Autowired
    private ModelMapper modelMapper;

    /**
     * Processes POST request to '/rest/users'.
     * Creates a user by signUpUserDto.
     *
     * @param signUpUserDto signUpUserDto
     *
     * @return result of creating a user (true or false)
     * */
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> addUser(@RequestBody SignUpUserDto signUpUserDto) {

        if (!checkUsername(signUpUserDto.getUsername())) {
            ResponseEntity.ok(false);
        }
        if (!checkPassword(signUpUserDto.getPassword())) {
            ResponseEntity.ok(false);
        }
        if (!checkFirstname(signUpUserDto.getFirstname())) {
            ResponseEntity.ok(false);
        }
        if (!checkLastname(signUpUserDto.getLastname())) {
            ResponseEntity.ok(false);
        }
        if (!checkPhone(signUpUserDto.getPhone())) {
            ResponseEntity.ok(false);
        }

        User user = modelMapper.map(signUpUserDto, User.class);
        user.setPassword(encoder.encode(user.getPassword()));
        userService.createUser(user);
        return ResponseEntity.ok(true);
    }

    public boolean checkUsername(String username){
        if (username == null) {
            return false;
        } else if (username.length() <= 3) {
            return false;
        } else if (username.length() >= 23) {
            return false;
        } else {
            return true;
        }
    }

    private boolean checkPassword(String password){
        if (password == null) {
            return false;
        }
        if (password.length() < 8) {
            return false;
        }
        if (password.length() >= 255) {
            return false;
        }
        return true;
    }

    private boolean checkFirstname(String firstname){
        if (firstname == null) {
            return false;
        } else if (firstname.length() <= 3 || firstname.length() >= 23) {
            return false;
        } else {
            return true;
        }
    }

    private boolean checkLastname(String lastname){
        if (lastname == null || lastname.length() <= 3 || lastname.length() >= 23) {
            return false;
        } else {
            return true;
        }
    }

    private boolean checkPhone(String phone){
        for (int i = 0; i < phone.length(); i++){
            try {
                Integer.parseInt(String.valueOf(phone.charAt(i)));
            } catch (Exception exc){
                return false;
            }
        }
        return true;
    }



    /**
     * Processes GET request to '/rest/users/valid' and
     * checks existing of username.
     *
     * @param username username
     *
     * @return true if username doesn't exist or false if it does
     * */
    @RequestMapping(value = "/valid", method = RequestMethod.GET)
    public ResponseEntity<?> isValidUsername(@RequestParam("username") String username) {

        if (username != null) {
            return ResponseEntity.ok(userService.isUsernameFree(username));
        } else {
            return ResponseEntity.ok(false);
        }
    }

    /**
     * Processes GET request to '/rest/users/username' and
     * returns the username of the current user.
     *
     * @return username
     * */
    @RequestMapping(value = "/username", method = RequestMethod.GET)
    public ResponseEntity<?> getUsername() {
        UserDetails currentUser = securityHelper.getCurrentUser();
        if (currentUser != null) {
            return ResponseEntity.ok(currentUser.getUsername());
        } else {
            return ResponseEntity.ok(false);
        }
    }
}