/*
POST: 
    Header: CONTENT-TYPE : APPLICATION/XML
    Body: <?xml.........

por id y por año
*/
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.service;

import com.model.User;
import com.pojo.UserDAOimpl;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.util.*;

/**
 *
 * @author Luis Quintano
 */
@Path("/users")
public class UserService {
    
    //GET
    @GET  //el protocolo get.
    @Path("/getAllUsersXML")  //http://localhost:8080/WebApplication1/resources/users/getAllUsersXML
    @Produces(MediaType.APPLICATION_XML)  //te produce algo de tipo xml.
    public List<User> getAllUsersXML() {
        List<User> users = new ArrayList<>();
        
        try (UserDAOimpl userDAOimpl = new UserDAOimpl();){
            users = userDAOimpl.getAllUsers();
        } catch(Exception ex) {
            System.err.println("ERROR: " + ex);
        }
        return users;
    }
    
    @GET  //el protocolo get.
    @Path("/getAllUsersJSON")  //http://localhost:8080/WebApplication1/resources/users/getAllUsersJSON
    @Produces(MediaType.APPLICATION_JSON)  //te produce algo de tipo xml.
    public List<User> getAllUsersJSON() {
        List<User> users = new ArrayList<>();
        
        try (UserDAOimpl userDAOimpl = new UserDAOimpl();){
            users = userDAOimpl.getAllUsers();
        } catch(Exception ex) {
            System.err.println("ERROR: " + ex);
        }
        return users;
    }
    
    @GET  //el protocolo get.
    @Path("/getUserByIdXML/{id}")  //http://localhost:8080/WebApplication1/resources/users/getUserByIdXML/1
    @Produces(MediaType.APPLICATION_XML)  //te produce algo de tipo xml.
    public User getUserByIdXML(@PathParam("id") String id) {
        User u = null;
        
        try (UserDAOimpl userDAOimpl = new UserDAOimpl();){
            u = userDAOimpl.getUserById(id);
        } catch(Exception ex) {
            System.err.println("ERROR: " + ex);
        }
        return u;
    }
    
    @GET  //el protocolo get.
    @Path("/getUserByIdJSON/{id}")  //http://localhost:8080/WebApplication1/resources/users/getUserByIdJSON/1
    @Produces(MediaType.APPLICATION_JSON)  //te produce algo de tipo xml.
    public User getUserByIdJSON(@PathParam("id") String id) {
        User u = null;
        
        try (UserDAOimpl userDAOimpl = new UserDAOimpl();){
            u = userDAOimpl.getUserById(id);
        } catch(Exception ex) {
            System.err.println("ERROR: " + ex);
        }
        return u;
    }
    
    @GET  //el protocolo get.
    @Path("/getUsersByYearBirthXML/{yearbirth}")  //http://localhost:8080/WebApplication1/resources/users/getUsersByYearBirthXML/1999
    @Produces(MediaType.APPLICATION_XML)  //te produce algo de tipo xml.
    public List<User> getUsersByYearBirthXML(@PathParam("yearbirth") int yearbirth) {
        List<User> users = new ArrayList<>();
        
        try (UserDAOimpl userDAOimpl = new UserDAOimpl();){
            users = userDAOimpl.getUsersByYearBirth(yearbirth);
        } catch(Exception ex) {
            System.err.println("ERROR: " + ex);
        }
        return users;
    }
    
    @GET  //el protocolo get.
    @Path("/getUsersByYearBirthJSON/{yearbirth}")  //http://localhost:8080/WebApplication1/resources/users/getUsersByYearBirthJSON/1999
    @Produces(MediaType.APPLICATION_JSON)  //te produce algo de tipo xml.
    public List<User> getUsersByYearBirthJSON(@PathParam("yearbirth") int yearbirth) {
        List<User> users = new ArrayList<>();
        
        try (UserDAOimpl userDAOimpl = new UserDAOimpl();){
            users = userDAOimpl.getUsersByYearBirth(yearbirth);
        } catch(Exception ex) {
            System.err.println("ERROR: " + ex);
        }
        return users;
    }
    
    
    //POST
    @POST  //el protocolo get.
    @Path("/post/createUserXML")  //http://localhost:8080/WebApplication1/resources/users/post/createUserXML
    @Produces(MediaType.APPLICATION_XML)  //te produce algo de tipo xml.
    @Consumes(MediaType.APPLICATION_XML)  //como es POST el usuario va a meter datos y hay que poner el post.
    public List<User> createUserXML(List<User> users) {  //esta lista se la pasa al método desde el body.
        List<User> usersAdded = new ArrayList<>();
        
        try (UserDAOimpl userDAOimpl = new UserDAOimpl();){
            for (User user : users) {
                if (userDAOimpl.insertUser(user)) {  //si este metodo devuelve true....
                    usersAdded.add(user);  //añadimos el usuario a la lista.
                }
            }
        } catch(Exception ex) {
            System.err.println("ERROR: " + ex);
        }
        return usersAdded;
    }
    
    @POST  //el protocolo get.
    @Path("/post/createUserJSON")  //http://localhost:8080/WebApplication1/resources/users/post/createUserJSON
    @Produces(MediaType.APPLICATION_JSON)  //te produce algo de tipo json.
    @Consumes(MediaType.APPLICATION_JSON)  //como es POST el usuario va a meter datos y hay que poner el post.
    public List<User> createUserJSON(List<User> lu) {
        List<User> r = new ArrayList<>();
        
        try (UserDAOimpl userDAOimpl = new UserDAOimpl();){
            for (User user : lu) {
                if (userDAOimpl.insertUser(user)) {  //si este metodo devuelve true....
                    r.add(user);  //añadimos el usuario a la lista.
                }
            }
        } catch(Exception ex) {
            System.err.println("ERROR: " + ex);
        }
        return r;
    }
}
