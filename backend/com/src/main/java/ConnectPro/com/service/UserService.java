package ConnectPro.com.service;

import ConnectPro.com.model.User;
import ConnectPro.com.model.UserType;
import ConnectPro.com.model.UserAction;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User registerUser(User user);
    Optional<User> findUserById(Long id);
    Optional<User> findUserByUsername(String username);
    List<User> findAllUsers();
    void deleteUser(Long id);
    
    // Business logic specific to user types
    boolean canUserPerformAction(Long userId, UserAction action);
}
