package by.vino.mygarage.service.impl;

import by.vino.mygarage.dao.api.UserRepository;
import by.vino.mygarage.dao.jpa.User;
import by.vino.mygarage.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    /**
     * {@inheritDoc}
     * */
    @Override
    public void createUser(User user) {
        userRepository.save(user);
    }

    /**
     * {@inheritDoc}
     * */
    @Override
    public boolean isUsernameFree(String username) {
        return userRepository.findByUsername(username) == null;
    }

    /**
     * {@inheritDoc}
     * */
    @Override
    public User loadUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    /**
     * {@inheritDoc}
     * */
    @Override
    public User loadUserById(int id) {
        return userRepository.findById(id).orElse(null);
    }

    /**
     * {@inheritDoc}
     * */
    @Override
    public List<User> loadUsersByRole(int role) {
        return userRepository.findAllByRole_RoleId(role);
    }
}
