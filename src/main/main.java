/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import conexion.conexion;
import controlador.controladorCategoria;
import controlador.controladorEstado;
import controlador.controladorFactura;
import controlador.controladorLogin;
import controlador.controladorProducto;
import controlador.controladorUsuario;
import controlador.controladorVentas;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.ModeloUsuario;
import modelo.modeloCategoria;
import modelo.modeloDetalleFactura;
import modelo.modeloEstado;
import modelo.modeloFacturacion;

/**
 *
 * @author Linda
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // conectamos a la base de datos:
         conexion con = new conexion();
        try {
            con.conectar();
            //si funcionan
            modeloCategoria modacat = new modeloCategoria();
        //controladorCategoria cc = new controladorCategoria(modacat);
            ModeloUsuario modusuario = new ModeloUsuario();
        //controladorLogin clogin = new controladorLogin(modusuario);
         modeloFacturacion modfac = new modeloFacturacion();
    //controladorFactura cf = new controladorFactura(modfac);
    modeloEstado mode = new modeloEstado();
    //controladorEstado ce = new controladorEstado(mode);
     modeloDetalleFactura moddet = new modeloDetalleFactura();
     controladorVentas cv= new controladorVentas(moddet);
     
    
    
    
    //controladorProducto cp = new controladorProducto();
        //controladorUsuario cu = new controladorUsuario();
        } catch (SQLException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
