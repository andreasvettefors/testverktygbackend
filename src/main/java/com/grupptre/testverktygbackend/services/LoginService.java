/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupptre.testverktygbackend.services;

import com.grupptre.testverktygbackend.models.User;
import com.grupptre.testverktygbackend.repository.UserRepository;
import java.util.List;

/**
 *
 * @author Conrad Letelier conrad@letelier.email
 */
public class LoginService {

    UserRepository ur = new UserRepository();
    User userToReturn = new User();
    
        public User login(User loginAttempt) {
        List<User> users = ur.getAllUsers();
        User user = new User();
        for(User u : users){
           if(u.getEMail().equals(loginAttempt.getEMail()) && u.getPassword().equals(loginAttempt.getPassword())){
                user = u;
           }    
        }
        return user;
    }
    

}
