package by.vino.mygarage.dao.api;

import by.vino.mygarage.dao.jpa.User;

public interface UserDao extends CrudDao<User> {
    User findByUsername(String username);
}
