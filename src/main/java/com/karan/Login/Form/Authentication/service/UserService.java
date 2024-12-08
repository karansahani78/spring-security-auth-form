package com.karan.Login.Form.Authentication.service;
import com.karan.Login.Form.Authentication.model.User;
import com.karan.Login.Form.Authentication.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
        // Fetch user by username or email
        User user = userRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail)
                .orElseThrow(() -> new UsernameNotFoundException("User not found for username or email: " + usernameOrEmail));

        // Return a CustomUserDetails object
        return new CustomUserDetails(user);
    }

    // Additional service methods
    public User registerUser(User user) {
        // Check if username or email is already taken
        if (userRepository.findByUsernameOrEmail(user.getUsername(), user.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Username or email is already taken");
        }

        // Encode the password before saving
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // Save the user to the database
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
