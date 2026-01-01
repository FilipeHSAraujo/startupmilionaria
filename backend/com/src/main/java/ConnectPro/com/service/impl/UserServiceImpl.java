package ConnectPro.com.service.impl;

import ConnectPro.com.model.User;
import ConnectPro.com.model.UserAction;
import ConnectPro.com.model.UserType;
import ConnectPro.com.repository.UserRepository;
import ConnectPro.com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository,
                           PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User registerUser(User user) {

        if (user == null) {
            throw new RuntimeException("User cannot be null");
        }

        if (user.getUsername() == null || user.getUsername().isBlank()) {
            throw new RuntimeException("Username is required");
        }

        if (user.getEmail() == null || user.getEmail().isBlank()) {
            throw new RuntimeException("Email is required");
        }

        if (user.getPassword() == null || user.getPassword().isBlank()) {
            throw new RuntimeException("Password is required");
        }

        if (user.getUserType() == null) {
            throw new RuntimeException("User type is required");
        }

        userRepository.findByUsername(user.getUsername())
                .ifPresent(u -> {
                    throw new RuntimeException("Username already exists");
                });

        userRepository.findByEmail(user.getEmail())
                .ifPresent(u -> {
                    throw new RuntimeException("Email already exists");
                });

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        return userRepository.save(user);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<User> findUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<User> findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("User not found");
        }
        userRepository.deleteById(id);
    }

    @Override
    public boolean canUserPerformAction(Long userId, UserAction action) {

        if (action == null) {
            return false;
        }

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        UserType userType = user.getUserType();

        if (userType == null) {
            return false;
        }

        switch (userType) {
            case ADMIN:
                return true;

            case CLIENT:
                return action == UserAction.POST_JOB
                        || action == UserAction.VIEW_PROFILE;

            case FREELANCER:
                return action == UserAction.APPLY_JOB
                        || action == UserAction.VIEW_PROFILE;

            default:
                return false;
        }
    }
}
