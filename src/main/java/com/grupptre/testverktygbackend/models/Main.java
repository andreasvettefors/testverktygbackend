/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupptre.testverktygbackend.models;

import com.grupptre.testverktygbackend.util.HibernateUtil;
import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import sun.misc.CRC16;

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
        
        Course c1 = new Course();
        c1.setName("Matte");
           
        User user = new User();
        user.setAuthorization(2);
        user.setEMail("Pelle@sven.com");
        user.setPassword("nisse");
        
        List<User> userList = new ArrayList<>();
        userList.add(user);
        
        c1.setUserList(userList);
      
        session.save(c1);
        session.getTransaction().commit();
    }
    
}
