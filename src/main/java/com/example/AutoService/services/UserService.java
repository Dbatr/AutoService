package com.example.AutoService.services;

import com.example.AutoService.models.User;
import com.example.AutoService.models.enums.Role;
import com.example.AutoService.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void initializeUserData() {
        long count = userRepository.count();
        if (count == 0) {
            Set<Role> adminRoles = new HashSet<>();
            adminRoles.add(Role.ROLE_ADMIN);

            Set<Role> userRoles = new HashSet<>();
            userRoles.add(Role.ROLE_USER);

            User adminUser = new User(null, "admin@mail.com", passwordEncoder.encode("admin"),
                    "89993331234", true, adminRoles);
            User regularUser1 = new User(null, "user@mail.com", passwordEncoder.encode("user"),
                    "89093214569", true, userRoles);

            userRepository.saveAll(Arrays.asList(adminUser, regularUser1));
        }
    }
}
