/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexion.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.ModeloProducto;
import modelo.modeloCliente;

/**
 *
 * @author Linda
 */
public class daoCliente extends conexion {
    //Variables necesarias
    PreparedStatement ps;
    ResultSet rs;
    Connection con;
    
    //declaracion de modelos:
    modeloCliente modc = new modeloCliente();
    
  
    //linda: buscar cliente para registrarlo en la venta:
   public boolean consultarcliente(Object obj) {
        modc =(modeloCliente) obj;
         String sql ="SELECT * FROM cliente WHERE dpi_cliente=?";
        try {
            con = conectar();
            ps = con.prepareStatement(sql);
            
            ps.setString(1, modc.getDpi_cliente());
            rs = ps.executeQuery();
            
            if(rs.next()) {
               
               modc.setId_cliente(rs.getInt("id_cliente"));
           
               return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(daoProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
   
   public String guardarcliente(modeloCliente cliente){
       
       int respuesta;
       String mensaje ="";
       
       //Querys para guardar cliente
        String sqlinsert ="INSERT INTO cliente (nombre_cliente, apellido_cliente, correo_cliente, direccion_cliente, telefono_cliente, dpi_cliente, nit_cliente, genero_cliente, fecha_nacimiento) Values(?,?,?,?,?,?,?,?,?)";
       
        try{
            con = conectar();
            ps = con.prepareStatement(sqlinsert);
            
            ps.setString(1, cliente.getNombre_cliente());
            ps.setString(2, cliente.getApellido_cliente());
            ps.setString(3, cliente.getCorreo_cliente());
            ps.setString(4, cliente.getDireccion_cliente());
            ps.setString(5, cliente.getTel_cliente());
            ps.setString(6, cliente.getDpi_cliente());
            ps.setString(7, cliente.getNit_cliente());
            ps.setInt(8, cliente.getIdgenero_cliente());
            ps.setString(9, cliente.getFecha_nacimiento());
            respuesta = ps.executeUpdate();
            
              if (respuesta == 1) {
                mensaje = "Se guardo el registro de cliente";
                JOptionPane.showMessageDialog(null, mensaje);
                } 
              else {
                mensaje = "No se guardo el registro de cliente";
                JOptionPane.showMessageDialog(null, mensaje);
            }
        }
        catch(SQLException ex){
            Logger.getLogger(daoUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
   
        finally{
            closeConection();
       }
        
       return mensaje;
       
   }
   
   public boolean editarcliente(modeloCliente cliente){
       
       int respuesta;
       boolean mensaje = true;
       
       //Querys para actualizar cliente
       String sqlupdate ="UPDATE cliente SET nombre_cliente=?, apellido_cliente=?, correo_cliente=?, direccion_cliente=?, telefono_cliente=?, dpi_cliente=?, nit_cliente=?, genero_cliente=?, fecha_nacimiento=? where id_cliente=?";
       
       try{
            ps = con.prepareStatement(sqlupdate);
           
            ps.setString(1, cliente.getNombre_cliente());
            ps.setString(2, cliente.getApellido_cliente());
            ps.setString(3, cliente.getCorreo_cliente());
            ps.setString(4, cliente.getDireccion_cliente());
            ps.setString(5, cliente.getTel_cliente());
            ps.setString(6, cliente.getDpi_cliente());
            ps.setString(7, cliente.getNit_cliente());
            ps.setInt(8, cliente.getIdgenero_cliente());
            ps.setString(9, cliente.getFecha_nacimiento());
            
            respuesta = ps.executeUpdate();
            
            if (respuesta == 1) {
               mensaje = true;
            }
            else {
               mensaje = false;
            }
           
       }
       catch(SQLException ex){
            Logger.getLogger(daoUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       finally{
            closeConection();
       }
       
       return mensaje;
   }
   
   public boolean eliminarcliente(modeloCliente cliente){
       
       int respuesta;
       boolean mensaje = true;
       
       //Querys para actualizar cliente
       String sqldelete ="delete from cliente where nombre_cliente=?";
       
       try{
           
           ps = con.prepareStatement(sqldelete);
           
           ps.setString(1, cliente.getNombre_cliente());
           respuesta = ps.executeUpdate();
           
            if (respuesta == 1) {
               mensaje = true;
            }
            else {
               mensaje = false;
            }
       }
       
       catch(SQLException ex){
            Logger.getLogger(daoUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       finally{
            closeConection();
       }
       
       return mensaje;
   }
   
   
   public ArrayList<modeloCliente> listacliente(){
       
       ArrayList<modeloCliente> lista = null;
       
       String sql ="select * from cliente";
       
            try {
                con = conectar();
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                
                lista = new ArrayList();
                
                while(rs.next()){
                    modeloCliente modcliente = new modeloCliente();
                    modcliente.setId_cliente(rs.getInt("Id"));
                    modcliente.setNombre_cliente(rs.getString("Nombre"));
                    modcliente.setApellido_cliente(rs.getString("Apellido"));
                    modcliente.setFecha_nacimiento(rs.getString("Fecha"));
                    modcliente.setCorreo_cliente(rs.getString("Correo"));
                    modcliente.setDireccion_cliente(rs.getString("Direccion"));
                    modcliente.setTel_cliente(rs.getString("Telefono"));
                    modcliente.setDpi_cliente(rs.getString("Dpi"));
                    modcliente.setNit_cliente(rs.getString("Nit"));
                    modcliente.setIdgenero_cliente(rs.getInt("Genero"));
                    lista.add(modcliente);
                }
                

            } 
            catch (SQLException ex) {
                Logger.getLogger(daoUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
       
       
       return lista;
   }
}
