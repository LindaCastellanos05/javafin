
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

/**
 *
 * @author dave_
 */
public class daoProducto extends conexion{
    //Variables necesarias
    PreparedStatement ps;
    ResultSet rs;
    Connection con;
    
    //Query necesarios para Producto
    /*************Query****************/
    String insertar = "INSERT INTO producto (nombre_producto,numeroserie_producto,precio_producto,cantidad_producto,"
    + "estado_producto,categoria_producto) VALUES (?,?,?,?,?,?)";
    String mostrar = "SELECT * FROM producto";
    /*********************************/
    
    //declaracion de modelos:
    ModeloProducto modprod = new ModeloProducto();
    
    public String guardarProducto(ModeloProducto producto){
        int respuesta;
        String mensaje = "";
        
        try{
            
            con = conectar();
            ps = con.prepareStatement(insertar);
            ps.setString(1, producto.getNombre_producto());
            ps.setString(2, producto.getNumeroserie_producto());
            ps.setDouble(3, producto.getPrecio_producto());
            ps.setInt(4, producto.getCantidad_producto());
            ps.setInt(5, producto.getEstado_producto());
            ps.setInt(6, producto.getCategoria_producto());
            respuesta = ps.executeUpdate();
            
            if(respuesta == 1){
                mensaje = "Guardado";
                JOptionPane.showMessageDialog(null, mensaje);
            }
            else{
                mensaje = "Error al Guardar";
                JOptionPane.showMessageDialog(null, mensaje);
            }
            
        }
        catch(SQLException ex){
            java.util.logging.Logger.getLogger(daoProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            closeConection();
       }
        
        return mensaje;
    }
    //linda: buscar productos para hacer la venta:
   public boolean consultarprod(Object obj) {
        modprod =(ModeloProducto) obj;
         String sql = "SELECT * FROM producto WHERE numeroserie_producto=?";
        try {
            con = conectar();
            ps = con.prepareStatement(sql);
            
            ps.setString(1, modprod.getNumeroserie_producto());
            rs = ps.executeQuery();
            
            if(rs.next()) {
                
               modprod.setCantidad_producto(rs.getInt("cantidad_producto"));
               modprod.setEstado_producto(rs.getInt("estado_producto"));
               modprod.setNombre_producto(rs.getString("nombre_producto"));
               modprod.setPrecio_producto(rs.getDouble("precio_producto"));
               modprod.setId_producto(rs.getInt("id_producto"));
           
               return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(daoProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
   
   //linda: editar en bd
     public boolean editarproducto(ModeloProducto prod){
     int respuesta;
     boolean mensaje=true;
    
    //conexion
     try {
       con=conectar();
       String sql="UPDATE producto SET  cantidad_producto=? where id_producto=? ";
    
         ps=con.prepareStatement(sql);
         
         ps.setInt(1,prod.getCantidad_producto());
         ps.setInt(2, prod.getId_producto());
         
            
          respuesta=ps.executeUpdate();
          
          if(respuesta==1){
              mensaje=true;
          }
          else{
              mensaje=false;
          }
          
          
         
     } catch (SQLException ex) {
         Logger.getLogger(daoProducto.class.getName()).log(Level.SEVERE, null, ex);
     }
     finally{
    
     }
    
        
        return mensaje;
 
   
   
      }
}
