/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupptre.testverktygbackend.repository;

import com.grupptre.testverktygbackend.models.Course;
import com.grupptre.testverktygbackend.models.Test;
import com.grupptre.testverktygbackend.models.User;
import com.grupptre.testverktygbackend.util.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author hampus
 */
public class TestRepository {
    
    
    
    public Test addTest(Test test){
        Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    session.save(test);
    
   
    session.getTransaction().commit();
    
    return test;
    }
    
}
