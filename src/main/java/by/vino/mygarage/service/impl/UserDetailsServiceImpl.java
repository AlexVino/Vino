package by.vino.mygarage.service.impl;

import by.vino.mygarage.dao.api.UserDao;
import by.vino.mygarage.dao.jpa.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        User activeUserInfo = userDao.findByUsername(username);
        GrantedAuthority authority = new SimpleGrantedAuthority(activeUserInfo.getRole().getRoleName());
        return new org.springframework.security.core.userdetails.User(
                activeUserInfo.getUsername(),
                activeUserInfo.getPassword(),
                Collections.singletonList(authority));
    }
}
