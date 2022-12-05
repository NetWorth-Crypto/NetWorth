package com.example.networth.services;

import com.example.networth.models.User;
import com.example.networth.models.UserWithRoles;
import com.example.networth.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsLoader implements UserDetailsService {

    private final UserRepository users;

    public UserDetailsLoader(UserRepository users) {
        this.users = users;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = users.findByUserName(username);

        if (user == null) {
            throw new UsernameNotFoundException("No user found for " + username);
        }

        System.out.println(user.toString());
        return new UserWithRoles(user);

    }
}