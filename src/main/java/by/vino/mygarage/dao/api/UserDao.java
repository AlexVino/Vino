package by.vino.mygarage.dao.api;

import by.vino.mygarage.dao.jpa.User;

public interface UserDao {
    User findUserByUsername(String username);
    void createUser(User user);
}
