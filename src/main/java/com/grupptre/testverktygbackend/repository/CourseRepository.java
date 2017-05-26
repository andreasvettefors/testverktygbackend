/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupptre.testverktygbackend.repository;

import com.grupptre.testverktygbackend.models.Test;
import com.grupptre.testverktygbackend.models.User;
import com.grupptre.testverktygbackend.util.HibernateUtil;
import java.util.List;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

/**
 *
 * @author hampus
 */
public class CourseRepository {
    
    // hämtar alla test från en viss kurs
   public List<Test> getTestsFromCourse(int id) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        SQLQuery q = session.createSQLQuery("SELECT test.id,name,description,timeLimit,seeResult \n" +
                                            "FROM test JOIN user_has_test \n" +
                                            "ON test.id = `test_id` WHERE course_id = :courseId" );
        q.addEntity(Test.class);
        q.setParameter("courseId", id);
        List<Test> tests = q.list();
         for(Test t : tests){
            System.out.println(t); 
        }
        session.getTransaction().commit();
       
        return tests;
    }
     
}
