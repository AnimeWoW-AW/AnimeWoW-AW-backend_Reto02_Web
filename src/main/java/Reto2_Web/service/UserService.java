/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto2_Web.service;

import Reto2_Web.model.User;
import Reto2_Web.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Nicolay
 */
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAll() {
        return userRepository.getAll();
    }

    public Optional<User> getUser(int id) {
        return userRepository.getUser(id);
    }

    /**
     * Metodo para crear el usuario
     * @param user
     * @return
     */
    public User save(User user) {
        if (user.getId() == null) {
            return user;
        }else {
            Optional<User> dbUser = userRepository.getUser(user.getId());
            if (dbUser.isEmpty()) {
                if (emailExists(user.getEmail())==false){
                    return userRepository.save(user);
                } else {
                    return user;
                }
            }else{
                return user;
            }
        }
    }

    public boolean emailExists(String email) {
        return userRepository.emailExists(email);
    }

    /**
     * Metodo para actualizar el usuario
     * @param user
     * @return
     */
    public User update(User user) {
        if (user.getId() != null) {
            Optional<User> dbUser = userRepository.getUser(user.getId());
            if (!dbUser.isEmpty()) {
                if (user.getIdentification() != null) {
                    dbUser.get().setIdentification(user.getIdentification());
                }
                if (user.getName() != null) {
                    dbUser.get().setName(user.getName());
                }
                if (user.getAddress() != null) {
                    dbUser.get().setAddress(user.getAddress());
                }
                if (user.getCellPhone() != null) {
                    dbUser.get().setCellPhone(user.getCellPhone());
                }
                if (user.getEmail() != null) {
                    dbUser.get().setEmail(user.getEmail());
                }
                if (user.getPassword() != null) {
                    dbUser.get().setPassword(user.getPassword());
                }
                if (user.getZone() != null) {
                    dbUser.get().setZone(user.getZone());
                }
                if (user.getType() != null) {
                    dbUser.get().setType(user.getType());
                }
                userRepository.update(dbUser.get());
                return dbUser.get();
            } else {
                return user;
            }
        } else {
            return user;
        }
    }

    /**
     * Metodo para eliminar el usuario
     * @param userId
     * @return
     */
    public boolean delete(int userId) {
        Boolean userBoolean = getUser(userId).map(user -> {
            userRepository.delete(user);
            return true;
        }).orElse(false);
        return userBoolean;
    }

    /**
     * Metodo para autenticar el usuario
     * @param email
     * @param password
     * @return
     */
    public User authenticateUser(String email, String password) {
        Optional<User> user = userRepository.authenticateUser(email, password);
        if (user.isEmpty()) {
            return new User();
        } else {
            return user.get();
        }
    }

}