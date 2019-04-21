package ru.stacy.oauth2restful.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.stacy.oauth2restful.entity.User;
import ru.stacy.oauth2restful.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    @Autowired
    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        CustomUserDetails customUserDetails;

        if (user != null) {
            customUserDetails = new CustomUserDetails();
            customUserDetails.setUser(user);
        } else {
            throw new UsernameNotFoundException("User not exist with username: " + username);
        }

        return customUserDetails;
    }
}
