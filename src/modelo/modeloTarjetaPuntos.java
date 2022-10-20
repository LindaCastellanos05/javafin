/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Ciriaco
 */
public class modeloTarjetaPuntos {
    
    //variables
    private int id_tarjetapuntos;
    private int dpicliente_puntos;
    private int idcajero_puntos;
    private String lat_puntos;
    private String lon_puntos;
    private String num_puntos;
    private String fecha_puntos;
    
    //constructores
    public modeloTarjetaPuntos() {
        
    }

    public modeloTarjetaPuntos(int id_tarjetapuntos, int dpicliente_puntos, int idcajero_puntos, String lat_puntos, String lon_puntos, String num_puntos, String fecha_puntos) {
        this.id_tarjetapuntos = id_tarjetapuntos;
        this.dpicliente_puntos = dpicliente_puntos;
        this.idcajero_puntos = idcajero_puntos;
        this.lat_puntos = lat_puntos;
        this.lon_puntos = lon_puntos;
        this.num_puntos = num_puntos;
        this.fecha_puntos = fecha_puntos;
    }
    
    
    //getter and setter
    public int getId_tarjetapuntos() {
        return id_tarjetapuntos;
    }

    public void setId_tarjetapuntos(int id_tarjetapuntos) {
        this.id_tarjetapuntos = id_tarjetapuntos;
    }

    public int getDpicliente_puntos() {
        return dpicliente_puntos;
    }

    public void setDpicliente_puntos(int dpicliente_puntos) {
        this.dpicliente_puntos = dpicliente_puntos;
    }

    public int getIdcajero_puntos() {
        return idcajero_puntos;
    }

    public void setIdcajero_puntos(int idcajero_puntos) {
        this.idcajero_puntos = idcajero_puntos;
    }

    public String getLat_puntos() {
        return lat_puntos;
    }

    public void setLat_puntos(String lat_puntos) {
        this.lat_puntos = lat_puntos;
    }

    public String getLon_puntos() {
        return lon_puntos;
    }

    public void setLon_puntos(String lon_puntos) {
        this.lon_puntos = lon_puntos;
    }

    public String getNum_puntos() {
        return num_puntos;
    }

    public void setNum_puntos(String num_puntos) {
        this.num_puntos = num_puntos;
    }

    public String getFecha_puntos() {
        return fecha_puntos;
    }

    public void setFecha_puntos(String fecha_puntos) {
        this.fecha_puntos = fecha_puntos;
    }
    
    
}
