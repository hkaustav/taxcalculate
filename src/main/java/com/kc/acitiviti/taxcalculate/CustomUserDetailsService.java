package com.kc.acitiviti.taxcalculate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserStore userStore;

    @Autowired
    public CustomUserDetailsService(UserStore userStore) {
        this.userStore = userStore;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        if (userStore.get(username).isEmpty()) {
            throw new UsernameNotFoundException("User not found");
        }

        return org.springframework.security.core.userdetails.User.withUsername(username)
                .password("{noop}" + userStore.get(username)) // {noop} indicates no password encoding
                .roles("USER")
                .build();
    }
}
