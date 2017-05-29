/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupptre.testverktygbackend.services;

import com.grupptre.testverktygbackend.models.Test;
import com.grupptre.testverktygbackend.models.Testresult;
import com.grupptre.testverktygbackend.repository.CourseRepository;
import com.grupptre.testverktygbackend.repository.TestRepository;
import java.util.List;

/**
 *
 * @author hampus
 */
public class TestService {
        
   TestRepository tr = new TestRepository();
    
   public List <Testresult> getResultFromTest(int userId, int testId){
      return tr.getResultFromTest(userId, testId);
    }
  
}
