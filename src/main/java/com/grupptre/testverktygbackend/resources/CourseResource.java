/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupptre.testverktygbackend.resources;

import com.grupptre.testverktygbackend.models.Course;
import com.grupptre.testverktygbackend.models.Test;
import com.grupptre.testverktygbackend.models.User;
import com.grupptre.testverktygbackend.services.CourseService;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author hampus
 */
@Path("/courses")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CourseResource {
    
     CourseService cr = new CourseService();
    
    @GET
    public List<Course> getCourses() {
        return cr.getCourses();
    }

    @GET
    @Path("/{courseId}/tests")
    public List<Test> getTestsFromCourse(@PathParam("courseId") int id) {

        return cr.getTestsFromCourse(id);
    }
    
    @POST
    @Path("/{courseId}/tests/{testId}/user/{userId}")
    public void addTestToCourseAndUser(@PathParam("courseId") int courseId,
                                       @PathParam("testId") int testId,
                                       @PathParam("userId") int userId){
        cr.addTestToCourseAndUser(courseId,testId,userId);
    }
    
    @GET
    @Path("/{courseId}/students")
    public List<User> getStudentsInCourse(@PathParam("courseId") int courseId){
        return cr.getStudentsInCourse(courseId);
    }


}
