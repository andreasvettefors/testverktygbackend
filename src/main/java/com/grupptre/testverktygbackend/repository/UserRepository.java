/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupptre.testverktygbackend.repository;

import com.grupptre.testverktygbackend.models.User;
import com.grupptre.testverktygbackend.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author ramonachantaf
 */
public class UserRepository {
    
       public List<User> getAllUsers() {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        List<User> list = session.createCriteria(User.class).list();
        /*List<Test> list = session.createCriteria(Test.class).list();
        for(Test t:list){
            for(Question q: t.getQuestionList()){
                for(Answer a:q.getAnswerList()){                    
                }
            }
        }*/
         
        session.getTransaction().commit();
        return list;
    }
}
