/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.pojo;

import com.interfaces.UserDAO;
import com.model.User;
import com.utils.Configuration;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Luis Quintano
 */
public class UserDAOimpl implements UserDAO, AutoCloseable {
    static {  //los bloques staticos se llaman solo la primera vez que alguien hace un new de esta clase.
        try {
            Class.forName(Configuration.DRIVER);  //cargamos el driver mediante la ruta que está en la variable tipo final.
        } catch (Exception e) {
            System.out.println("Error al cargar el Driver");
            e.printStackTrace();
            System.exit(1);  //termina el programa.
        }
    }
    
    
    //constructor
    Connection conexion = null;
    public UserDAOimpl() throws Exception {  //no hace falta el try/catch porque ya se lanza la Exception.
        conexion = DriverManager.getConnection(Configuration.URLCONNECTION, Configuration.USER, Configuration.PASSW);
    }
    
    
    //metodos
    @Override
    public boolean insertUser(User user) throws Exception {
        boolean usuarioInsertado;
        String query = "insert into users(id, name, rol, yearbirth) "
                     + " values(?, ?, ?, ?) ";
        
        try (PreparedStatement sentencia = conexion.prepareStatement(query);){
            sentencia.setString(1, user.getId());
            sentencia.setString(2, user.getName());
            sentencia.setString(3, user.getRol());
            sentencia.setInt(4, user.getYearbirth());
            
            int r = sentencia.executeUpdate();
            if (r == 0) {
                usuarioInsertado = true;
            } else {
                usuarioInsertado = false;
            }
        } catch (Exception e) {
            throw e;
        }
        return usuarioInsertado;
    }
    
    @Override
    public List<User> getAllUsers() throws Exception {
        List<User> users = new ArrayList<User>();
        User u = null;
        String query = "select id, name, rol, yearbirth "
                     + " from users "
                     + " order by id ";
        
        try (
                PreparedStatement sentencia = conexion.prepareStatement(query);
                ResultSet resultado = sentencia.executeQuery();
            ){
            while (resultado.next()) {  //cuando te pueden salir varios registros con la consulta ponemos el while.
                u = new User(
                                resultado.getString("id"),
                                resultado.getString("name"),
                                resultado.getString("rol"),
                                resultado.getInt("yearbirth")
                             );
                users.add(u);  //vamos añadiendo cada Vuelo al ArrayList de Vuelos.
            }
        } catch (Exception e) {
            throw e;
        }
        return users;
    }
    
    @Override
    public User getUserById(String id) throws Exception {
        User u = null;
        String query = "select id, name, rol, yearbirth "
                     + " from users "
                     + " where id = ? ";
        
        ResultSet resultado = null;
        try (PreparedStatement sentencia = conexion.prepareStatement(query);){
            sentencia.setString(1, id);
            resultado = sentencia.executeQuery();
            
            if (resultado.next()) {  //cuando solo te saca un registro porque se ha buscado por el valor idVuelo que solo te puede sacar un registro se pone el if.
                u = new User(
                                resultado.getString("id"),
                                resultado.getString("name"),
                                resultado.getString("rol"),
                                resultado.getInt("yearbirth")
                             );
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (resultado != null) {
                resultado.close();
            }
        }
        return u;
    }

    @Override
    public List<User> getUsersByYearBirth(int yearbirth) throws Exception {
        List<User> users = new ArrayList<User>();
        User u = null;
        String query = "select id, name, rol, yearbirth "
                     + " from users "
                     + " where yearbirth = ? "
                     + " order by id ";
        
        ResultSet resultado = null;
        try (PreparedStatement sentencia = conexion.prepareStatement(query);){
            sentencia.setInt(1, yearbirth);
            resultado = sentencia.executeQuery();
            while (resultado.next()) {  //cuando te pueden salir varios registros con la consulta ponemos el while.
                u = new User(
                                resultado.getString("id"),
                                resultado.getString("name"),
                                resultado.getString("rol"),
                                resultado.getInt("yearbirth")
                             );
                users.add(u);  //vamos añadiendo cada Vuelo al ArrayList de Vuelos.
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (resultado != null) {
                resultado.close();
            }
        }
        return users;
    }
    
    
    //metodo para que sea clsoeable en el ty-catch with resources.
    @Override
    public void close() throws Exception {  //no hace falta el try/catch porque ya se lanza la Exception.
        if (conexion != null) {
            conexion.close();
        }
    }
}
