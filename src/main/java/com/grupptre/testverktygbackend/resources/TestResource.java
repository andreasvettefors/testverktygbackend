/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupptre.testverktygbackend.resources;

import com.grupptre.testverktygbackend.models.Answer;
import com.grupptre.testverktygbackend.models.Question;
import com.grupptre.testverktygbackend.models.Test;
import com.grupptre.testverktygbackend.services.TestService;
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
@Path("/tests")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TestResource {

    TestService ts = new TestService();

    @POST
    //@Produces(MediaType.APPLICATION_JSON)
    public Test addTest(Test test) {
        return ts.addTest(test);
    }

    @POST
    @Path("/{testId}/questions")
    public Question addQuestion(@PathParam("testId") int testId, Question question) {
        return ts.addQuestion(testId, question);
    }

    @POST
    @Path("/{testId}/questions/{questionId}/answers")
    public Answer addAnswer(@PathParam("questionId") int questionId, Answer answer) {
        return ts.addAnswer(questionId, answer);
    }

    @GET
    @Path("/{testId}")
    public Test getTest(@PathParam("testId") int id) {

        return ts.getTest(id);
    }

}
