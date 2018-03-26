package by.vino.mygarage.rest.impl;

import by.vino.mygarage.dao.jpa.User;
import by.vino.mygarage.rest.dto.SignUpUserDto;
import by.vino.mygarage.service.api.UserService;
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
    public ResponseEntity<?> addUser(@RequestBody @Valid SignUpUserDto signUpUserDto) {
        User user = modelMapper.map(signUpUserDto, User.class);
        user.setPassword(encoder.encode(user.getPassword()));
        userService.createUser(user);
        return ResponseEntity.ok(true);
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
        return ResponseEntity.ok(userService.isUsernameFree(username));
    }

    /**
     * Processes GET request to '/rest/users/username' and
     * returns the username of the current user.
     *
     * @return username
     * */
    @RequestMapping(value = "/username", method = RequestMethod.GET)
    public ResponseEntity<?> getUsername() {
        UserDetails currentUser = getCurrentUser();
        if (currentUser != null) {
            return ResponseEntity.ok(currentUser.getUsername());
        } else {
            return ResponseEntity.ok(false);
        }
    }

    private UserDetails getCurrentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (null == auth) {
            return null;
        }

        Object obj = auth.getPrincipal();

        if (obj instanceof UserDetails) {
            return (UserDetails) obj;
        } else {
            return null;
        }
    }
}