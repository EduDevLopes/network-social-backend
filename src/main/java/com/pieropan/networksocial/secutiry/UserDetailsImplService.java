package com.pieropan.networksocial.secutiry;

import com.pieropan.networksocial.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsImplService implements UserDetailsService {

    @Autowired
    UsersRepository repostirory;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        return repostirory.findByLogin(login);
    }
}