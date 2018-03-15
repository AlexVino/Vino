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
        userDao.createUser(user);
    }

    /**
     * {@inheritDoc}
     * */
    @Override
    public boolean checkUsername(String username) {
        return userDao.findUserByUsername(username) == null;
    }

    /**
     * {@inheritDoc}
     * */
    @Override
    public User loadUserByUsername(String username) {
        return userDao.findUserByUsername(username);
    }
}
