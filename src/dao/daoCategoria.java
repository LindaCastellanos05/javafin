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
import modelo.modeloCategoria;

/**
 *
 * @author Linda
 */
public class daoCategoria extends conexion implements crudInterface {
    //definimos varibles que vamos a usar para conectar a la base de datos
    PreparedStatement ps;
    ResultSet rs;
    Connection con;
    
    //declaracion de querys que vamos a usar para categoria
    //----------------------------------querys---------------------------------------------
    String sqlinsert = "insert into categoria (descripcion_categoria) values (?)";
    String sqlmostrar = "select * from categoria";
    //-------------------------------------------------------------------------------------
    //declaracion modelo categoria:
    modeloCategoria modcat = new modeloCategoria();
    
    
    @Override
    public boolean agregar(Object obj) {
    boolean resultado = false;
    modcat = (modeloCategoria) obj;
    
        try {
            
            con = conectar();
            ps = con.prepareStatement(sqlinsert);
            ps.setString(1, modcat.getDescripcion_categoria());
            
            if(ps.executeUpdate()==1){
               resultado = true;
           }else{
               resultado = false;
           }
           
        } catch (SQLException ex) {
            
            Logger.getLogger(daoCategoria.class.getName()).log(Level.SEVERE, null, ex);
            
        }finally{
         closeConection();
       }
     
        return resultado;  
    }

    @Override
    public boolean eliminar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modificar(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List mostrartodo(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List buscar(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
