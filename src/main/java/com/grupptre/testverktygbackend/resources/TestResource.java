/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupptre.testverktygbackend.resources;

import com.grupptre.testverktygbackend.models.Test;
import com.grupptre.testverktygbackend.models.User;
import com.grupptre.testverktygbackend.repository.TestRepository;
import com.grupptre.testverktygbackend.repository.UserRepository;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("test")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TestResource {
    
    
  
    TestRepository r = new TestRepository();
    @POST
    //@Produces(MediaType.APPLICATION_JSON)
    public Test addTest(Test test) {
        return r.addTest(test);
    }
    
}
