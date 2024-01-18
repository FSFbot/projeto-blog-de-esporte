package com.blogesporte.esportes.Service;

import org.apache.catalina.User;

import java.util.Optional;

public interface UserService {
    Optional<com.blogesporte.esportes.model.User> findById (Long id);
    User saveUser(User user);
    void deleteUser(Long id);

    com.blogesporte.esportes.model.User saveUser(com.blogesporte.esportes.model.User user);
}
