/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupptre.testverktygbackend.resources;

import com.grupptre.testverktygbackend.models.Test;
import com.grupptre.testverktygbackend.models.UserHasTest;
import com.grupptre.testverktygbackend.repository.TestRepository;
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
    
    TestResource testResource = new TestResource();
        
        
        @GET
        
        public List<UserHasTest> getTestsFromCourse(){
           
        return testResource.getTestsFromCourse();
    }
}
