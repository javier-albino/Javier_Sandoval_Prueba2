/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

/**
 *
 * @author javie
 */
public class Division {
       int codigo ;
    String nombre;

    public Division(int codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public Division(String nombre) {
        this.nombre = nombre;
    }

    
    
 
    

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

  
    }
   
    

