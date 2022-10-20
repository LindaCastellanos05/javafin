/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import controlador.controladorCategoria;
import controlador.controladorLogin;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.ModeloUsuario;
import modelo.modeloCategoria;

/**
 *
 * @author Linda
 */
public class conexion {
    //declaraciones
    String driver="com.mysql.jdbc.Driver";
    String user="root";
    String pass="";
    String url="jdbc:mysql://localhost:3306/proyecto_fincurso";
      
    Connection con=null;
    
    
    public Connection conectar() throws SQLException{
        try{
            Class.forName(driver);
            
            con=(Connection)DriverManager.getConnection(url, user, pass);
            
            if(con!=null){
                System.out.println("conexion establecida con Exito");
            }
            
        }catch(ClassNotFoundException e){
            Logger.getLogger(conexion.class.getName()).log(Level.SEVERE,null,e);
            
        }catch(SQLException ex){
            Logger.getLogger(conexion.class.getName()).log(Level.SEVERE,null,ex);
            
        } finally{
            //closeConection();
        }
        return con;
    }
    
      public void closeConection(){
         try {
             con.close();
         } catch (SQLException ex) {
             Logger.getLogger(conexion.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
    public static void main(String[] args) throws SQLException{
        conexion con = new conexion();
        con.conectar();
        /*//Linda:prueba agregar categoria---si sirve
        modeloCategoria modacat = new modeloCategoria();
        controladorCategoria cc = new controladorCategoria(modacat);
        */
       /* //Linda:prueba iniciar sesion login:---si sirve
        ModeloUsuario modusuario = new ModeloUsuario();
        controladorLogin clogin = new controladorLogin(modusuario);
       */
        }  
    }
    

