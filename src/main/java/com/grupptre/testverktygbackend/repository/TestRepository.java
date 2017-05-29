/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupptre.testverktygbackend.repository;

import com.grupptre.testverktygbackend.models.Testresult;
import com.grupptre.testverktygbackend.util.HibernateUtil;
import java.util.List;
import org.hibernate.SQLQuery;
import org.hibernate.Session;


/**
 *
 * @author hampus
 */
public class TestRepository {
    
   public List<Testresult> getResultFromTest(int studentId, int testId ) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
         SQLQuery q = session.createSQLQuery("SELECT user_id,test_id,question,answer,isCorrect\n" +
                                           "FROM testresult WHERE user_id = :studentId AND test_id = :testId" );
        q.setParameter("studentId", studentId);
        q.setParameter("testId", testId);
        q.addEntity(Testresult.class);
       
        List<Testresult> result = q.list();
        
        for(Testresult t : result){
            System.out.println(t.getQuestion());
        }
        
        //Testresult t = (Testresult) session.get(Testresult.class, 1);
        //List<Testresult> result = session.createCriteria(Testresult.class).list();
        //System.out.println(result.get(0).getQuestion());
        session.getTransaction().commit();
       
        return result;

  
    }
}
