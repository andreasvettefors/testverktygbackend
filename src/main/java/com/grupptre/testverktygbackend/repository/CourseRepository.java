/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupptre.testverktygbackend.repository;

import com.grupptre.testverktygbackend.models.Course;
import com.grupptre.testverktygbackend.models.Test;
import com.grupptre.testverktygbackend.models.User;
import com.grupptre.testverktygbackend.models.UserHasTest;
import com.grupptre.testverktygbackend.util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

/**
 *
 * @author hampus
 */
public class CourseRepository {

    public List<Course> getCourses() {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        List<Course> list = session.createCriteria(Course.class).list();

        session.getTransaction().commit();
        return list;
    }

    // hämtar alla test från en viss kurs
    public List<Test> getTestsFromCourse(int id) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        SQLQuery q = session.createSQLQuery("SELECT test.id,name,description,timeLimit,seeResult \n"
                + "FROM test JOIN user_has_test \n"
                + "ON test.id = `test_id` WHERE course_id = :courseId");
        q.addEntity(Test.class);
        q.setParameter("courseId", id);
        List<Test> tests = q.list();
        for (Test t : tests) {
            System.out.println(t);
        }
        session.getTransaction().commit();

        return tests;
    }

    public List<User> getStudentsInCourse(int courseId) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        SQLQuery q = session.createSQLQuery("SELECT * FROM user\n"
                + "JOIN user_has_course ON user_id\n"
                + "WHERE user.authorization = '0' \n"
                + "AND user_has_course.course_id = :cId\n"
                + "GROUP BY user.id;");
        q.addEntity(User.class);
        q.setParameter("cId", courseId);
        List<User> userList = q.list();
        session.getTransaction().commit();

        return userList;

    }

    public void addTestToCourseAndUser(int courseId, int testId, int userId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        System.out.println(userId + "" + testId + "" + courseId);
        SQLQuery q = session.createSQLQuery("INSERT INTO g3testverktyg.user_has_test \n"
                + "(user_id, test_id, isDone, course_id) \n"
                + "VALUES (:uId, :tId, '1', :cId);");

        q.setParameter("uId", userId);
        q.setParameter("tId", testId);
        q.setParameter("cId", courseId);

        q.executeUpdate();

        session.getTransaction().commit();
    }

}
