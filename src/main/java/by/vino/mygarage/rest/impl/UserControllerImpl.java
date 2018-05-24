package by.vino.mygarage.rest.impl;

import by.vino.mygarage.dao.jpa.User;
import by.vino.mygarage.exception.ErrorCode;
import by.vino.mygarage.exception.RestException;
import by.vino.mygarage.rest.dto.SignUpUserDto;
import by.vino.mygarage.service.api.UserService;
import by.vino.mygarage.util.SecurityHelper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<?> addUser(@RequestBody @Valid SignUpUserDto signUpUserDto) {
        User user = modelMapper.map(signUpUserDto, User.class);
        user.setPassword(encoder.encode(user.getPassword()));
        if (userService.isUsernameFree(user.getUsername())) {
            userService.createUser(user);
        } else {
            throw new RestException(ErrorCode.USERNAME_EXISTED);
        }
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