/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupptre.testverktygbackend.resources;

import com.grupptre.testverktygbackend.models.Test;
import com.grupptre.testverktygbackend.models.User;
import com.grupptre.testverktygbackend.models.UserHasTest;
import com.grupptre.testverktygbackend.services.LoginService;
import com.grupptre.testverktygbackend.services.UserService;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PathParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author hampus
 */
@Path("users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {

    UserService us = new UserService();

    @GET
    public List<User> getAllUsers() {

        return us.getAllUsers();
    }

    @POST
    @Path("/login")
    public User login(User user) {
        LoginService ls = new LoginService();
        return ls.login(user);
    }

    @Path("/{id}")
    @GET
    public User getUser(@PathParam("id") int id) {

        return us.getUser(id);
    }

    @POST
    @Path("/studentanswers")
    public void saveStudentAnswer(@QueryParam("studentId") int studentId,
            @QueryParam("questionId") int questionId,
            @QueryParam("answerId") int answerId) {
        System.out.println("studId: " + studentId);
        System.out.println("questionId: " + questionId);
        System.out.println("answerId: " + answerId);
        us.saveStudentAnswer(studentId, questionId, answerId);
    }

    @Path("/students")
    public StudentResource test() {
        return new StudentResource();
    }

}
