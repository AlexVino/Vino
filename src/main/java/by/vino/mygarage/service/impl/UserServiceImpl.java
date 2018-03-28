package by.vino.mygarage.service.impl;

import by.vino.mygarage.dao.api.UserDao;
import by.vino.mygarage.dao.jpa.User;
import by.vino.mygarage.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    /**
     * {@inheritDoc}
     * */
    @Override
    public void createUser(User user) {
        userDao.create(user);
    }

    /**
     * {@inheritDoc}
     * */
    @Override
    public boolean isUsernameFree(String username) {
        return userDao.findByUsername(username) == null;
    }

    /**
     * {@inheritDoc}
     * */
    @Override
    public User loadUserByUsername(String username) {
        return userDao.findByUsername(username);
    }

    /**
     * {@inheritDoc}
     * */
    @Override
    public User loadUserById(int id) {
        return userDao.get(id);
    }
}
