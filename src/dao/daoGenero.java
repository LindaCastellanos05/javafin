/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexion.conexion;
import controlador.crudInterface;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.modeloGenero;

/**
 *
 * @author Linda
 */
public class daoGenero extends conexion implements crudInterface{
    
    
    //variables a onexion a base
    PreparedStatement ps;
    ResultSet rs;
    Connection con;
    
    /**********************Querys**********************/
    
    String sqlinsert ="insert into genero (descripcion_genero) values (?)";
    String sqlver ="select * from genero";
    
    /**************************************************/
    
    modeloGenero modgenero = new modeloGenero();

    @Override
    public boolean agregar(Object obj) {
        boolean respuesta = false;
        modgenero = (modeloGenero) obj;
        
         try {
            con = conectar();
            ps = con.prepareStatement(sqlinsert);
            ps.setString(1, modgenero.getDescripcion_genero());
            
            if(ps.executeUpdate()==1){
               respuesta = true;
           }
            else{
               respuesta = false;
           }
           
        } catch (SQLException ex) {
            
            Logger.getLogger(daoCategoria.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        finally{
            closeConection();
       }
         
         return respuesta;
    }

    @Override
    public boolean eliminar(int id) {
        return false;
    }

    @Override
    public boolean modificar(Object obj) {
        return false;
    }

    @Override
    public List mostrartodo(Object obj) {
        return null;
    }

    @Override
    public List buscar(int i) {
       return null;
    }

    
    
    
        
}
