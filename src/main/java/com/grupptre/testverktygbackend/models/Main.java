/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupptre.testverktygbackend.models;

import com.grupptre.testverktygbackend.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Andreas Vettefors (contact@vettefors.se)
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        
        /*Course c1 = new Course();
        c1.setName("Matte");
           
        User user = new User();
        user.setAuthorization(2);
        user.setEMail("Pelle@sven.com");
        user.setPassword("nisse");
        
        List<User> userList = new ArrayList<>();
        userList.add(user);
        
        c1.setUserList(userList);
      
        session.save(c1);*/
        
        List<User> list = session.createCriteria(User.class).list();
        for(User u: list){
            //System.out.println(u.getUserHasTestList().get(0).getTestId().getQuestionList().get(0).getQuestion());
        }
        session.getTransaction().commit();
    }
    
}
