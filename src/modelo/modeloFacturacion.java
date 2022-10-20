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
public class modeloFacturacion {
    //declaracion de variables del modelo:
    private int id_facturacion, idcajero_facturacion, idcliente_facturacion, idpuntos_facturacion, cantidad_facturacion;
    private double monto_facturacion;
    private String fecha_facturacion, nit_facturacion, latitud_facturacion, longitud_facturacion;
    
    //constructores

    public modeloFacturacion() {
    }

    public modeloFacturacion(int id_facturacion, int idcajero_facturacion, int idcliente_facturacion, int idpuntos_facturacion, int cantidad_facturacion, double monto_facturacion, String fecha_facturacion, String nit_facturacion, String latitud_facturacion, String longitud_facturacion) {
        this.id_facturacion = id_facturacion;
        this.idcajero_facturacion = idcajero_facturacion;
        this.idcliente_facturacion = idcliente_facturacion;
        this.idpuntos_facturacion = idpuntos_facturacion;
        this.cantidad_facturacion = cantidad_facturacion;
        this.monto_facturacion = monto_facturacion;
        this.fecha_facturacion = fecha_facturacion;
        this.nit_facturacion = nit_facturacion;
        this.latitud_facturacion = latitud_facturacion;
        this.longitud_facturacion = longitud_facturacion;
    }

    //getters y setters
    public int getId_facturacion() {
        return id_facturacion;
    }

    public void setId_facturacion(int id_facturacion) {
        this.id_facturacion = id_facturacion;
    }

    public int getIdcajero_facturacion() {
        return idcajero_facturacion;
    }

    public void setIdcajero_facturacion(int idcajero_facturacion) {
        this.idcajero_facturacion = idcajero_facturacion;
    }

    public int getIdcliente_facturacion() {
        return idcliente_facturacion;
    }

    public void setIdcliente_facturacion(int idcliente_facturacion) {
        this.idcliente_facturacion = idcliente_facturacion;
    }

    public int getIdpuntos_facturacion() {
        return idpuntos_facturacion;
    }

    public void setIdpuntos_facturacion(int idpuntos_facturacion) {
        this.idpuntos_facturacion = idpuntos_facturacion;
    }

    public int getCantidad_facturacion() {
        return cantidad_facturacion;
    }

    public void setCantidad_facturacion(int cantidad_facturacion) {
        this.cantidad_facturacion = cantidad_facturacion;
    }

    public double getMonto_facturacion() {
        return monto_facturacion;
    }

    public void setMonto_facturacion(double monto_facturacion) {
        this.monto_facturacion = monto_facturacion;
    }

    public String getFecha_facturacion() {
        return fecha_facturacion;
    }

    public void setFecha_facturacion(String fecha_facturacion) {
        this.fecha_facturacion = fecha_facturacion;
    }

    public String getNit_facturacion() {
        return nit_facturacion;
    }

    public void setNit_facturacion(String nit_facturacion) {
        this.nit_facturacion = nit_facturacion;
    }

    public String getLatitud_facturacion() {
        return latitud_facturacion;
    }

    public void setLatitud_facturacion(String latitud_facturacion) {
        this.latitud_facturacion = latitud_facturacion;
    }

    public String getLongitud_facturacion() {
        return longitud_facturacion;
    }

    public void setLongitud_facturacion(String longitud_facturacion) {
        this.longitud_facturacion = longitud_facturacion;
    }
    
}
