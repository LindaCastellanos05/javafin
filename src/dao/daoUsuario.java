
package dao;

import conexion.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.ModeloUsuario;

/**
 *
 * @author dave_
 */
public class daoUsuario extends conexion{
    
    PreparedStatement ps;
    ResultSet rs;
    Connection con;
    ModeloUsuario modusuario = new ModeloUsuario();
    
    //Queries
    String insert = "INSERT INTO usuario (nombre_usuario,pwd_usuario,user_usuario,correo_usuario,telefono_usuario,"
    + "idtipo_usuario,fechanac_usuario,direccion_usuario,dpi_usuario,Apellido_usuario,latitud_usuario,longitud_usuario,genero_usuario) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    
    public String guardarUsuario(ModeloUsuario usuario){
        int respuesta;
        String mensaje = "";
        
        try{
            
            con = conectar();
            ps = con.prepareStatement(insert);
            ps.setString(1, usuario.getNombre_usuario());
            ps.setString(2, usuario.getPwd_usuario());
            ps.setString(3, usuario.getUser_usuario());
            ps.setString(4, usuario.getCorreo_usuario());
            ps.setString(5, usuario.getTelefono_usuario());
            ps.setInt(6, usuario.getIdtipo_usuario());
            ps.setString(7, usuario.getFechanac_usuario());
            ps.setString(8, usuario.getDireccion_usuario());
            ps.setString(9, usuario.getDpi_usuario());
            ps.setString(10, usuario.getApellido_usuario());
            ps.setString(11, usuario.getLatitud_usuario());
            ps.setString(12, usuario.getLongitud_usuario());
            ps.setInt(13, usuario.getGenero_usuario());
            respuesta = ps.executeUpdate();
            
            if(respuesta ==1){
              mensaje="guardado";
              JOptionPane.showMessageDialog(null, mensaje);
          }
          else{
               mensaje="error al guardar";
               JOptionPane.showMessageDialog(null, mensaje);
          }
            
        }catch(SQLException ex){
            Logger.getLogger(daoUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return mensaje;
    }
    
}
