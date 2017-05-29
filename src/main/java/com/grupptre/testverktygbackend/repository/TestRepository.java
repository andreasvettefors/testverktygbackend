/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupptre.testverktygbackend.repository;

import com.grupptre.testverktygbackend.models.Test;
import com.grupptre.testverktygbackend.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author hampus
 */
public class TestRepository {
    
        public Test getTest(int testId) {
            Session session = HibernateUtil.getSession();
            Query query = session.createQuery("from Test where id = :id");
            query.setInteger("id",testId);
            Test testToReturn = (Test) query.uniqueResult();
            return testToReturn;
    }
   
}
