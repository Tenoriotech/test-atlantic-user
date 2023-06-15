package com.user.service;

import com.user.dto.User;
import com.user.entity.UserEntity;
import com.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserEntity createUser(User user) {

        UserEntity userEntity = new UserEntity();

        userEntity.setId(user.getId());
        userEntity.setCpf(user.getCpf());
        userEntity.setName(user.getName());
        userEntity.setPassword(user.getPassword());
        userEntity.setEmail(user.getEmail());
        userEntity.setIsActive(user.getIsActive());
        userEntity.setIdResponsible(user.getIdResponsible());
        userEntity.setAccessSystem(user.getSystemAccess());

        return userRepository.save(userEntity);

    }

    public UserEntity updateUser(User user, Long idUser) {

        Optional<UserEntity> userInDb = userRepository.findById(idUser);

        if (userInDb.isEmpty()) {
            throw new RuntimeException("User not found in db");
        }

        UserEntity userEntity = new UserEntity();

        userEntity.setId(userInDb.get().getId());
        userEntity.setCpf(user.getCpf() != null ? user.getCpf() : userInDb.get().getCpf());
        userEntity.setName(user.getName() != null ? user.getName() : userInDb.get().getName());
        userEntity.setPassword(user.getPassword() != null ? user.getPassword() : userInDb.get().getPassword());
        userEntity.setEmail(user.getEmail() != null ? user.getEmail() : userInDb.get().getEmail());
        userEntity.setIsActive(user.getIsActive() != null ? user.getIsActive() : userInDb.get().getIsActive());
        userEntity.setIdResponsible(user.getIdResponsible() != null ? user.getIdResponsible() : userInDb.get().getIdResponsible());
        userEntity.setAccessSystem(user.getSystemAccess() != null ? user.getSystemAccess() : userInDb.get().getAccessSystem());
        return userRepository.save(userEntity);

    }

    public UserEntity getUser(Long idUser) {

        Optional<UserEntity> userInDb = userRepository.findById(idUser);

        if (userInDb.isEmpty()) {
            throw new RuntimeException("User not found in db");
        }

        return userInDb.get();

    }

    public List<UserEntity> getAllUser() {

        return userRepository.findAll();


    }

    public void deleteUser(Long idUser) {

        Optional<UserEntity> userInDb = userRepository.findById(idUser);

        if (userInDb.isEmpty()) {
            throw new RuntimeException("User not found in db");
        }

        userRepository.delete(userInDb.get());

    }
}
