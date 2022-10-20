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
public class modeloDetalleFactura {
    //declaracion de variables clase modeloDetalleFactura
    private String numserie_detalle;
    private double precioprod_detalle;
    private int id_detalle, cantidad_detalle, id_producto_det, idfac_det;
    //contructores:

    public modeloDetalleFactura() {
    }

    public modeloDetalleFactura(String numserie_detalle, double precioprod_detalle, int id_detalle, int cantidad_detalle, int id_producto_det, int idfac_det) {
        this.numserie_detalle = numserie_detalle;
        this.precioprod_detalle = precioprod_detalle;
        this.id_detalle = id_detalle;
        this.cantidad_detalle = cantidad_detalle;
        this.id_producto_det = id_producto_det;
        this.idfac_det = idfac_det;
    }

    
    
    //getter y setters de las variables:

    public String getNumserie_detalle() {
        return numserie_detalle;
    }

    public void setNumserie_detalle(String numserie_detalle) {
        this.numserie_detalle = numserie_detalle;
    }

    public double getPrecioprod_detalle() {
        return precioprod_detalle;
    }

    public void setPrecioprod_detalle(double precioprod_detalle) {
        this.precioprod_detalle = precioprod_detalle;
    }

    public int getId_detalle() {
        return id_detalle;
    }

    public void setId_detalle(int id_detalle) {
        this.id_detalle = id_detalle;
    }

    public int getCantidad_detalle() {
        return cantidad_detalle;
    }

    public void setCantidad_detalle(int cantidad_detalle) {
        this.cantidad_detalle = cantidad_detalle;
    }

    public int getId_producto_det() {
        return id_producto_det;
    }

    public void setId_producto_det(int id_producto_det) {
        this.id_producto_det = id_producto_det;
    }

    public int getIdfac_det() {
        return idfac_det;
    }

    public void setIdfac_det(int idfac_det) {
        this.idfac_det = idfac_det;
    }

    
}
