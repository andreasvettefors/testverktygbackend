/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupptre.testverktygbackend.services;

import com.grupptre.testverktygbackend.models.Studentanswer;
import com.grupptre.testverktygbackend.models.User;
import com.grupptre.testverktygbackend.repository.UserRepository;
import java.util.List;

/**
 *
 * @author hampus
 */
public class UserService {
    
    UserRepository ur = new UserRepository();
    
    public List<User> getAllUsers(){
        return ur.getAllUsers();
    }
    
    public void saveStudentAnswer(int userId,int questionId,int answerId){
        ur.saveStudentAnswer(userId,questionId,answerId);
    }
    
}
