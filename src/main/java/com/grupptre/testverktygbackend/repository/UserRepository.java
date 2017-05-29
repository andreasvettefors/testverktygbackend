/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupptre.testverktygbackend.repository;

import com.grupptre.testverktygbackend.models.Studentanswer;
import com.grupptre.testverktygbackend.models.Test;
import com.grupptre.testverktygbackend.models.User;
import com.grupptre.testverktygbackend.models.UserHasTest;
import com.grupptre.testverktygbackend.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
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
        session.getTransaction().commit();
        return list;
    }

    public List<UserHasTest> getUserTests(int userId) {
        Session session = HibernateUtil.getSession();
        Query query = session.createQuery("from UserHasTest where user_id = :id");
        query.setInteger("id", userId);
        List<UserHasTest> tests = query.list();
        return tests;
    }

    public void saveStudentAnswer(int userId, int questionId, int answerId) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        SQLQuery q = session.createSQLQuery(""
                + "INSERT INTO g3testverktyg.studentanswer (user_id, question_id, answer_id) "
                + "VALUES (:uid, :qid, :aid);");

        q.setParameter("uid", userId);
        q.setParameter("qid", questionId);
        q.setParameter("aid", answerId);

        q.executeUpdate();
        session.getTransaction().commit();

    }
}
