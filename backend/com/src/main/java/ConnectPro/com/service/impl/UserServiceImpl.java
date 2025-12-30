package ConnectPro.com.service.impl;

import ConnectPro.com.model.User;
import ConnectPro.com.model.UserType;
import ConnectPro.com.repository.UserRepository;
import ConnectPro.com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User registerUser(User user) {
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            throw new RuntimeException("Username already exists");
        }
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new RuntimeException("Email already exists");
        }
        
        // Internal handling of User Types if needed (e.g. setting default permissions)
        // For now, we just proceed with saving
        return userRepository.save(user);
    }

    @Override
    public Optional<User> findUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<User> findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public boolean canUserPerformAction(Long userId, String action) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Logic handling different user types internally
        switch (user.getUserType()) {
            case ADMIN:
                return true; // Admin can do anything
            case CLIENT:
                return "POST_JOB".equals(action) || "VIEW_PROFILE".equals(action);
            case FREELANCER:
                return "APPLY_JOB".equals(action) || "VIEW_PROFILE".equals(action);
            default:
                return false;
        }
    }
}
