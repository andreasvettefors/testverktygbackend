/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupptre.testverktygbackend.repository;

import com.grupptre.testverktygbackend.models.Answer;
import com.grupptre.testverktygbackend.models.Question;
import com.grupptre.testverktygbackend.models.Testresult;
import com.grupptre.testverktygbackend.models.Test;
import com.grupptre.testverktygbackend.models.UserHasTest;
import com.grupptre.testverktygbackend.util.HibernateUtil;
import java.util.List;
import org.hibernate.SQLQuery;
import org.hibernate.Query;
import org.hibernate.Session;

public class TestRepository {

    public Test addTest(Test test) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(test);
        session.getTransaction().commit();
        return test;
    }

    public Test getTest(int testId) {
        Session session = HibernateUtil.getSession();
        Query query = session.createQuery("from Test where id = :id");
        query.setInteger("id", testId);
        Test testToReturn = (Test) query.uniqueResult();
        return testToReturn;
    }
    
    public Question addQuestion(int testId,Question question){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Test dbTest = (Test) session.get(Test.class, testId);
        question.setTestId(dbTest);
        session.save(question);
        session.getTransaction().commit();
        return question;
    }
    
    public Answer addAnswer(int questionId,Answer answer){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Question dbQuestion = (Question) session.get(Question.class, questionId);
        answer.setQuestionId(dbQuestion);
        session.save(answer);
        session.getTransaction().commit();
        return answer;
    }

    public List<Testresult> getResultFromTest(int studentId, int testId) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        SQLQuery q = session.createSQLQuery("SELECT user_id,test_id,question,answer,isCorrect\n"
                + "FROM testresult WHERE user_id = :studentId AND test_id = :testId");
        q.setParameter("studentId", studentId);
        q.setParameter("testId", testId);
        q.addEntity(Testresult.class);

        List<Testresult> result = q.list();

        for (Testresult t : result) {
            System.out.println(t.getQuestion());
        }

        //Testresult t = (Testresult) session.get(Testresult.class, 1);
        //List<Testresult> result = session.createCriteria(Testresult.class).list();
        //System.out.println(result.get(0).getQuestion());
        session.getTransaction().commit();

        return result;
    }
}
