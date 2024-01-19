/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.model;

import jakarta.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Luis Quintano
 */
//@Entity  //define que es una entidad dentro de una database.
//@Table(name = "estudiantes")  //para poner el nombre de la Tabla en vez de como el nombre de la clase se lo ponemos nosotros.
@XmlRootElement
public class User {
//    @Id  //siempre tiene que estar encima del atributo que quieras que sea el id (Primary Key).
//    @GeneratedValue(strategy = GenerationType.IDENTITY)  //para que se auto incremente solo.
//    @Column(name = "id")  //para que la columna de la tabla se llame como le digas.
    private String id;
    
//    @Column(name = "nombre")  //para que la columna de la tabla se llame como le digas.
    private String name;
    
//    @Column(name = "rol")  //para que la columna de la tabla se llame como le digas.
    private String rol;
    
//    @Column(name = "yearbirth")  //para que la columna de la tabla se llame como le digas.
    private int yearbirth;
    
    //constructores
    public User() {
    }

    public User(String id, String name, String rol, int yearBirth) {
        this.id = id;
        this.name = name;
        this.rol = rol;
        this.yearbirth = yearBirth;
    }
    
    //toString
    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name=" + name + ", rol=" + rol + ", yearBirth=" + yearbirth + '}';
    }
    
    //getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public int getYearbirth() {
        return yearbirth;
    }

    public void setYearbirth(int yearbirth) {
        this.yearbirth = yearbirth;
    }
    
    
}
