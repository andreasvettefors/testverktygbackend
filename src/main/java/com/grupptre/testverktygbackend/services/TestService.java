/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupptre.testverktygbackend.services;

import com.grupptre.testverktygbackend.models.Test;
import com.grupptre.testverktygbackend.repository.TestRepository;

/**
 *
 * @author hampus
 */
public class TestService {
    TestRepository t = new TestRepository();
    
    
    public Test addTest(Test test){
        return t.addTest(test);
    }
}
