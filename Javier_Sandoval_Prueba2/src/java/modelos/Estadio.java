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
public class Estadio {
   
   private int id;
   private String nombre;
   private int capacidad;
   private Ciudad ciudad;
   
    public Estadio() {
       
        
    }

    public Estadio(int id, String nombre, int capacidad, Ciudad ciudad) {
        this.id = id;
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.ciudad = ciudad;
    }
 public Estadio( String nombre, int capacidad, Ciudad ciudad) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.ciudad = ciudad;
    }
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }
   
  
   
   
    }
