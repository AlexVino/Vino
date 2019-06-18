package by.vino.mygarage.service.api;

import by.vino.mygarage.dao.jpa.User;

import java.util.List;

public interface UserService {
    /**
     * Creates new user.
     *
     * @param user user
     * */
    void createUser(User user);

    /**
     * Checks username. If user with this username exists
     * it returns false else true.
     *
     * @param username username
     *
     * @return true (if username is free) or false (username isn't free)
     * */
    boolean isUsernameFree(String username);

    /**
     * Loads user by username. If user with this username does not exist
     * it returns null.
     *
     * @param username username
     *
     * @return user
     * */
    User loadUserByUsername(String username);

    /**
     * Loads user by id. If user with this id does not exist
     * it returns null.
     *
     * @param id user id
     *
     * @return user
     * */
    User loadUserById(int id);

    /**
     * Loads users by role.
     *
     * @param role user roleId
     * */
    List<User> loadUsersByRole(int role);
}
