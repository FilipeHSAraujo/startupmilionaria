package ConnectPro.service;

import ConnectPro.model.User;
import ConnectPro.value.UserType;
import ConnectPro.value.UserAction;

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
