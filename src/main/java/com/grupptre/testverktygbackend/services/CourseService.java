/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupptre.testverktygbackend.services;

import com.grupptre.testverktygbackend.models.Course;
import com.grupptre.testverktygbackend.models.Test;
import com.grupptre.testverktygbackend.models.User;
import com.grupptre.testverktygbackend.models.UserHasTest;
import com.grupptre.testverktygbackend.repository.CourseRepository;
import java.util.List;

/**
 *
 * @author hampus
 */
public class CourseService {

    CourseRepository cr = new CourseRepository();

    public List<Course> getCourses() {
        return cr.getCourses();
    }

    public List<Test> getTestsFromCourse(int id) {
        return cr.getTestsFromCourse(id);
    }
    
     public void addTestToCourseAndUser(int courseId,int testId,int userId){
        cr.addTestToCourseAndUser(courseId,testId,userId);
    }
     
     public List<User> getStudentsInCourse(int courseId){
         return cr.getStudentsInCourse(courseId);
     }
}
