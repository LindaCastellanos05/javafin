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
import java.util.ArrayList;
import java.util.List;
import modelo.ModeloProducto;
import modelo.modeloDetalleFactura;
import modelo.modeloFacturacion;

/**
 *
 * @author Linda
 */
public class daoDetalle extends conexion implements crudInterface {
   //definicion de variables que usaremes para conectar a la base de datos
    PreparedStatement ps;
    ResultSet rs;
    Connection con;
    
    //declaracion de los querys que usaremos para acceder a la base de datos:
    //--------------------------------querys--------------------------------------------------------
    String sqlselectall ="select * from detalle_factura";
    //----------------------------------------------------------------------------------------------
    //declaracion modelos
    modeloDetalleFactura modefa = new modeloDetalleFactura();
    ModeloProducto modprod = new ModeloProducto();
    modeloFacturacion modfactura = new modeloFacturacion();
    
   ArrayList<ModeloProducto> data=new ArrayList<>();
   boolean mensaje=true;
    
    @Override
    public boolean agregar(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
