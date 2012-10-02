package com.sangeethlabs.shiro.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.apache.shiro.SecurityUtils;

@Path("/greet")
@Produces("application/json")
public class GreeterResource {
    @GET
    public Message ping() {
       Message message = new Message();
       
       String username = (String)SecurityUtils.getSubject().getPrincipal();
       
       message.setText("Hello " + username);
       
       return message; 
    }
}