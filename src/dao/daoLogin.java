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
import modelo.ModeloUsuario;

/**
 *
 * @author Linda
 */
public class daoLogin extends conexion {
//definicion de variables que usaremes para conectar a la base de datos
    PreparedStatement ps;
    ResultSet rs;
    Connection con;
    
    //declaracion de los querys que usaremos para acceder a la base de datos:
    //--------------------------------querys--------------------------------------------------------
    String sqlselect ="select * from usuario where user_usuario=?";
    //----------------------------------------------------------------------------------------------
    
    //metodo para verificar el login:
    public int login(ModeloUsuario usuario){
     int result=0;
        try {
            con=conectar();
            ps = con.prepareStatement(sqlselect);
            ps.setString(1, usuario.getUser_usuario());
            rs = ps.executeQuery();
            
            
            if(rs.first()){
                //inicio de sesion como admin
                if(usuario.getPwd_usuario().equals(rs.getString("pwd_usuario"))&&rs.getString("idtipo_usuario").equals("5")){
                     System.out.println("pwd"+usuario.getPwd_usuario());
                    System.out.println("si existe usuario en base y contraseña correcta");
                    result=1;
                    return result;
                    
                    //inicio de sesion como cajero
                }else if(usuario.getPwd_usuario().equals(rs.getString("pwd_usuario"))&&rs.getString("idtipo_usuario").equals("6")){
                     System.out.println("pwd"+usuario.getPwd_usuario());
                    System.out.println("si existe usuario en base y contraseña correcta");
                    result=2;
                    return result;
                    
                    //inicio de sesion como vendedor
                }else if(usuario.getPwd_usuario().equals(rs.getString("pwd_usuario"))&&rs.getString("idtipo_usuario").equals("7")){
                     System.out.println("pwd"+usuario.getPwd_usuario());
                    System.out.println("si existe usuario en base y contraseña correcta");
                    result=3;
                    return result;
                    
                    //inicio de sesion como bodeguero
                }else if(usuario.getPwd_usuario().equals(rs.getString("pwd_usuario"))&&rs.getString("idtipo_usuario").equals("8")){
                     System.out.println("pwd"+usuario.getPwd_usuario());
                    System.out.println("si existe usuario en base y contraseña correcta");
                    result=4;
                    return result;
                    
                    //inicio de sesion incorrecto
                }else{
                     System.out.println("pwd"+usuario.getPwd_usuario());
                     System.out.println("NO existe usuario en base y contraseña correcta");
                }
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(daoLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return result;
    }
    
    
   
    
}
