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
public class modeloCliente {
    
    //variables
    private int id_cliente;
    private int idpuntos_cliente;
    private int idgenero_cliente;
    private String nombre_cliente;
    private String apellido_cliente;
    private String correo_cliente;
    private String direccion_cliente;
    private String tel_cliente;
    private String dpi_cliente;
    private String nit_cliente;
    private String fecha_nacimiento;
    
    
    //constructores
    public modeloCliente() {
    }

    public modeloCliente(int id_cliente, int idpuntos_cliente, int idgenero_cliente, String nombre_cliente, String apellido_cliente, String correo_cliente, String direccion_cliente, String tel_cliente, String dpi_cliente, String nit_cliente, String fecha_nacimiento) {
        this.id_cliente = id_cliente;
        this.idpuntos_cliente = idpuntos_cliente;
        this.idgenero_cliente = idgenero_cliente;
        this.nombre_cliente = nombre_cliente;
        this.apellido_cliente = apellido_cliente;
        this.correo_cliente = correo_cliente;
        this.direccion_cliente = direccion_cliente;
        this.tel_cliente = tel_cliente;
        this.dpi_cliente = dpi_cliente;
        this.nit_cliente = nit_cliente;
        this.fecha_nacimiento = fecha_nacimiento;
    }
    
    
    //getter and setter
    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getIdpuntos_cliente() {
        return idpuntos_cliente;
    }

    public void setIdpuntos_cliente(int idpuntos_cliente) {
        this.idpuntos_cliente = idpuntos_cliente;
    }

    public int getIdgenero_cliente() {
        return idgenero_cliente;
    }

    public void setIdgenero_cliente(int idgenero_cliente) {
        this.idgenero_cliente = idgenero_cliente;
    }

    public String getNombre_cliente() {
        return nombre_cliente;
    }

    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }

    public String getApellido_cliente() {
        return apellido_cliente;
    }

    public void setApellido_cliente(String apellido_cliente) {
        this.apellido_cliente = apellido_cliente;
    }

    public String getCorreo_cliente() {
        return correo_cliente;
    }

    public void setCorreo_cliente(String correo_cliente) {
        this.correo_cliente = correo_cliente;
    }

    public String getDireccion_cliente() {
        return direccion_cliente;
    }

    public void setDireccion_cliente(String direccion_cliente) {
        this.direccion_cliente = direccion_cliente;
    }

    public String getTel_cliente() {
        return tel_cliente;
    }

    public void setTel_cliente(String tel_cliente) {
        this.tel_cliente = tel_cliente;
    }

    public String getDpi_cliente() {
        return dpi_cliente;
    }

    public void setDpi_cliente(String dpi_cliente) {
        this.dpi_cliente = dpi_cliente;
    }

    public String getNit_cliente() {
        return nit_cliente;
    }

    public void setNit_cliente(String nit_cliente) {
        this.nit_cliente = nit_cliente;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }
}
