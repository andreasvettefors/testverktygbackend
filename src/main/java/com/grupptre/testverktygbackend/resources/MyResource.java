package com.grupptre.testverktygbackend.resources;

import com.grupptre.testverktygbackend.models.Test;
import com.grupptre.testverktygbackend.models.User;
import com.grupptre.testverktygbackend.repository.UserRepository;
import com.grupptre.testverktygbackend.util.HibernateUtil;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.hibernate.Session;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MyResource {
  
    UserRepository r = new UserRepository();
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getIt() {
        
        return r.getIt();
    }
 

}
