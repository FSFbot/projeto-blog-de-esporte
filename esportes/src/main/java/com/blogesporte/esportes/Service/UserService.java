package com.blogesporte.esportes.Service;


import com.blogesporte.esportes.model.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface UserService {
    Optional<com.blogesporte.esportes.model.User> findById (Long id);
    User saveUser(User user);
    void deleteUser(Long id);
}
