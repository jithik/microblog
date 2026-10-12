package com.jithisha.microblog.user;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DevDataRunner implements CommandLineRunner {

    private final UserRepository userRepository;

    public DevDataRunner(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) {
        if (!userRepository.existsByUsername("testuser")) {
            userRepository.save(new User("testuser", "test@example.com", "not-a-real-hash", "Test User"));
        }
        userRepository.findByUsername("testuser").ifPresent(u ->
                System.out.println("Found user: " + u.getUsername() + " id=" + u.getId() + " created=" + u.getCreatedAt()));
    }
}