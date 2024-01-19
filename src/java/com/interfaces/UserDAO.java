/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package com.interfaces;

import com.model.User;
import java.util.*;

/**
 *
 * @author Luis Quintano
 */
public interface UserDAO {
    public boolean insertUser(User user) throws Exception;
    
    public List<User> getAllUsers() throws Exception;
    
    public User getUserById(String id) throws Exception;
    
    public List<User> getUsersByYearBirth(int yearbirth) throws Exception;
}
