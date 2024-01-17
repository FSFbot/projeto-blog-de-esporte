package com.blogesporte.esportes.Service;

import com.blogesporte.esportes.Repository.UserRepository;
import com.blogesporte.esportes.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public abstract class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    @Override
    @Transactional(readOnly = true)
    public Optional<User> findById(Long id){
        return Optional.ofNullable(userRepository.findById(id).orElseThrow(() -> new UsernameNotFoundException("User not find ")));

    }
    @Override
    @Transactional
    public void deleteUser(Long id){
        Optional<User> user =  findById(id);
    }

}
