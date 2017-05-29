/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupptre.testverktygbackend.resources;

import com.grupptre.testverktygbackend.models.Testresult;
import com.grupptre.testverktygbackend.models.UserHasTest;
import com.grupptre.testverktygbackend.services.TestService;
import com.grupptre.testverktygbackend.services.UserService;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Andreas Vettefors (contact@vettefors.se)
 */
@Path("/students")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class StudentResource {
    
    UserService us = new UserService();
    TestService ts = new TestService();
    
    @GET
    @Path("/{studentId}/tests")
    public List<UserHasTest> getTest(@PathParam("studentId") int id) {
        return us.getUserTests(id);
    }
    
     @GET
     @Path("/{studentId}/tests/{testId}/testresult")
     public List <Testresult> getResultFromTest(@PathParam("studentId") int userId,@PathParam("testId") int id){
     
       return ts.getResultFromTest(userId, id);
    }
    
}
