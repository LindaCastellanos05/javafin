/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Linda
 */
public class modeloGenero {
    //declaracion
    private String descripcion_genero;
    private int id_genero;
    //contructor vacio

    public modeloGenero() {
    }
    //getters y setters

    public String getDescripcion_genero() {
        return descripcion_genero;
    }

    public void setDescripcion_genero(String descripcion_genero) {
        this.descripcion_genero = descripcion_genero;
    }

    public int getId_genero() {
        return id_genero;
    }

    public void setId_genero(int id_genero) {
        this.id_genero = id_genero;
    }
    
}
