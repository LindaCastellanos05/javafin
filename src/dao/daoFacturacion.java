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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.modeloFacturacion;

/**
 *
 * @author Linda
 */
public class daoFacturacion extends conexion implements crudInterface{
  //definicion de variables que usaremes para conectar a la base de datos
    PreparedStatement ps;
    ResultSet rs;
    Connection con;
    
    //declaracion de los querys que usaremos para acceder a la base de datos:
    //--------------------------------querys--------------------------------------------------------
    String sqlselectall ="select * from facturacion";
    String buscarfechas ="select * from facturacion where fecha_facturacion=?";
    String insertar ="insert into facturacion(cantidad_facturacion, monto_facturacion, fecha_facturacion, "
            + "nit_facturacion, idcajero_facturacion, idcliente_facturacion) values(?,?,?,?,?,?)";
    //----------------------------------------------------------------------------------------------
    //declaracion modelos
    modeloFacturacion modfactura = new modeloFacturacion();
    
    @Override
    public boolean agregar(Object obj) {
    boolean resultado = false;
    modfactura =(modeloFacturacion)obj;
    
        try {
          con=conectar();
          ps=con.prepareStatement(insertar);
          
          ps.setInt(1,modfactura.getCantidad_facturacion());
          ps.setDouble(2, modfactura.getMonto_facturacion());
          ps.setString(3, modfactura.getFecha_facturacion());
          ps.setString(4, modfactura.getNit_facturacion());
          ps.setInt(5, modfactura.getIdcajero_facturacion());
          ps.setInt(6, modfactura.getIdcliente_facturacion());
          
           if(ps.executeUpdate()==1){
               resultado = true;
               System.out.println("se guardo");
           }else{
               resultado = false;
               System.out.println("NO se guardo");
           }
          
        }catch(SQLException ex){
            Logger.getLogger(daoFacturacion.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("algo paso");
        }
        mostrartodo(modfactura);
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
        //establezco mi objeto
        modfactura = (modeloFacturacion) obj;
        
        //Creo mi lista
        ArrayList<modeloFacturacion> lista=null;
         
        try {
            con = conectar();
            ps = con.prepareStatement(sqlselectall);
            rs=ps.executeQuery();
            
             lista=new ArrayList();
             
            //lleno la lista con los datos que obtengo en la base de datos
            while(rs.next()){
                
                modeloFacturacion modfactura = new modeloFacturacion();
                
                modfactura.setCantidad_facturacion(rs.getInt("cantidad_facturacion"));
                modfactura.setFecha_facturacion(rs.getString("fecha_facturacion"));
                modfactura.setId_facturacion(rs.getInt("id_facturacion"));
                modfactura.setIdcajero_facturacion(rs.getInt("idcajero_facturacion"));
                modfactura.setIdcliente_facturacion(rs.getInt("idcliente_facturacion"));
                modfactura.setMonto_facturacion(rs.getDouble("monto_facturacion"));
                modfactura.setNit_facturacion(rs.getString("nit_facturacion"));
                
                lista.add(modfactura);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(daoFacturacion.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }finally{
            closeConection();
        }
        return lista;
           }

    @Override
    public List buscar(int id) {
      List<modeloFacturacion> listaid = new ArrayList<>();
          try{
             con = conectar();
             ps= con.prepareStatement(buscarfechas);
             ps.setInt(1, id);
             
             rs = ps.executeQuery();
             
             if(rs.first()){
                 modfactura.setCantidad_facturacion(rs.getInt("cantidad_facturacion"));
              
               
               listaid.add(modfactura);
               
             }
             return listaid;
             
          }catch(SQLException e){
              java.util.logging.Logger.getLogger(conexion.class.getName()).log(Level.SEVERE, null, e);
           return null;
          }finally{
              closeConection();
          }   
    }
     public List buscarfecha(String fecha) {
      List<modeloFacturacion> listaid = new ArrayList<>();
          try{
             con = conectar();
             ps= con.prepareStatement(buscarfechas);
             ps.setString(1, fecha);
             
             rs = ps.executeQuery();
             
             if(rs.first()){
                 modfactura.setCantidad_facturacion(rs.getInt("cantidad_facturacion"));
              
                 System.out.println(modfactura.getCantidad_facturacion());
                  System.out.println(fecha);
                 
               
               listaid.add(modfactura);
               
             }
             return listaid;
             
          }catch(SQLException e){
              java.util.logging.Logger.getLogger(conexion.class.getName()).log(Level.SEVERE, null, e);
           return null;
          }finally{
              closeConection();
          }   
    }
}
