/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupptre.testverktygbackend.resources;

import com.grupptre.testverktygbackend.services.TestService;
import com.grupptre.testverktygbackend.models.Testresult
import com.grupptre.testverktygbackend.models.Test
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
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
    
    @GET
    @Path("/{testId}")
    public Test getTest(@PathParam("testId") int id) {

        return ts.getTest(id);
    }

     @GET
     @Path("/{testId}/testresult")
     public List <Testresult> getResultFromTest(@PathParam("studentId") int userId,@PathParam("testId") int id){
     
       return ts.getResultFromTest(userId, id);
    }

}
