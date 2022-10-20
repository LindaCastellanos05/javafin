/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.daoCliente;
import dao.daoDetalle;
import dao.daoFacturacion;
import dao.daoProducto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import modelo.ModeloProducto;
import modelo.modeloCliente;
import modelo.modeloDetalleFactura;
import modelo.modeloFacturacion;
import vista.Facturacion;
import vista.NuevaVenta;

/**
 *
 * @author Linda
 */
public class controladorVentas implements ActionListener, MouseListener {
    //instancia de clases
    daoFacturacion daofac = new daoFacturacion();
    daoProducto daoprod = new daoProducto();
    daoDetalle daodet = new daoDetalle();
    daoCliente daoc = new daoCliente();
    modeloFacturacion modfac = new modeloFacturacion();
    ModeloProducto modprod = new ModeloProducto();
    modeloDetalleFactura moddet = new modeloDetalleFactura();
    modeloCliente modc = new modeloCliente();
    NuevaVenta nv = new NuevaVenta();
    
    //tabla
    DefaultTableModel tablafactura = new DefaultTableModel();
    ArrayList<modeloFacturacion> dataVentas = new ArrayList<>();
    
    
    //variables
    double importe;
    int item =1;
    double total;
    double cantidadpp;
   
    public controladorVentas(modeloDetalleFactura moddet){
        nv.setVisible(true);
        nv.btnbuscarprod.addActionListener(this);
        nv.btnañadirprodNuevaVenta.addActionListener(this);
        nv.btndescartarNuevaVenta.addActionListener(this);
        nv.tblnuevaVenta.addMouseListener(this);
        nv.btneliminarNuevaVenta.addActionListener(this);
        nv.btnguardarNuevaVenta.addActionListener(this);
    }
    
    //set de la hora 
    public void fecha(){
        Date date = new Date();
             SimpleDateFormat nuevoformato= new SimpleDateFormat("yyyy-MM-dd");
             String fecha = nuevoformato.format(date);
             System.out.println("esta es la fecha"+fecha);
             
        }
    
    //buscar producto en base de datos por numero de serie:
    public void buscarproducto(){
        if(nv.txtbusquedaProductoNuevaVenta.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Ingrese el codigo del producto");
        } else{
            modprod.setNumeroserie_producto(nv.txtbusquedaProductoNuevaVenta.getText().toString());
            
            boolean respuesta = daoprod.consultarprod(modprod);
            if(respuesta ==true){
                nv.txtnombreprodNuevaVenta.setText(modprod.getNombre_producto());
                nv.txtprecioProdNuevaVenta.setText(String.valueOf(modprod.getPrecio_producto()));
               nv.txtstockProdNuevaVenta.setText(String.valueOf(modprod.getCantidad_producto()));
               nv.txtidprodnuevaventa.setText(String.valueOf(modprod.getId_producto()));
               int estado = modprod.getEstado_producto();
                
               if(estado!=7){
                    JOptionPane.showMessageDialog(null, "No hay disponibles en la sucursal");
                   limpiarareaprod();
               }
            }
        }
    }
   
    
    //agregar un producto a la factura de la vista nueva venta
    public void agregarprodventatabla(){
        try{
        if(nv.txtbusquedaProductoNuevaVenta.getText().toString().equals("")){
            JOptionPane.showMessageDialog(null, "Busque un producto para añadirlo a la venta");
        }else{
            
        
    tablafactura = (DefaultTableModel) nv.tblnuevaVenta.getModel();

    int idprod = Integer.parseInt(nv.txtidprodnuevaventa.getText().toString());
    String nitcliente = nv.txtnitClienteNuevaVenta.getText().toString();
    String dpicliente = nv.txtdpiClienteNuevaVenta.getText().toString();
    String nombreprod = nv.txtnombreprodNuevaVenta.getText().toString();
    double precioprod = Double.parseDouble(nv.txtprecioProdNuevaVenta.getText().toString());
    String cantidad = String.valueOf(nv.jspcantidadNuevaVenta.getValue().toString());
    int cantidadprod = Integer.parseInt(cantidad);
    int stockprod = Integer.parseInt(nv.txtstockProdNuevaVenta.getText().toString());
    String numeroserie = nv.txtbusquedaProductoNuevaVenta.getText().toString();
    
    //pruebas----------------------------
     System.out.println(stockprod);
         System.out.println(cantidadprod);
    //------------------------------------   
         
         //condicion para añadir producto a la factura
    if(cantidadprod <= 0){
          JOptionPane.showMessageDialog(nv, "Elija una cantidad positiva para añadir producto a la venta");  
     
        //filtro para saber si hay suficiente cantidad disponibles
    }else if(stockprod < cantidadprod){
        JOptionPane.showMessageDialog(nv, "No hay suficientes productos en existencia");  
    }else{
         importe = precioprod*cantidadprod;
          Object[] objeto = new Object[7];
        objeto[0]=item;
        objeto[1]=numeroserie;
        objeto[2]=idprod;
        objeto[3]=nombreprod;
        objeto[4]= precioprod;
        objeto[5]=cantidadprod;
        objeto[6]=importe;
        
      for(int i=0;i<nv.tblnuevaVenta.getRowCount(); i++){
          int fila=0;
          int total=0;
          
            fila= Integer.parseInt(nv.tblnuevaVenta.getValueAt(i, 5).toString());
        total+=fila;
        modfac.setCantidad_facturacion(total);
    
      }
        //descoontar del inventario
        while(modprod.getId_producto()==idprod){
            System.out.println("se esta ejecutando el while");
            
        int deduccion = stockprod-cantidadprod;
        modprod.setCantidad_producto(deduccion);
        modprod.setId_producto(idprod);
        daoprod.editarproducto(modprod);
        
        idprod++;
        
        System.out.println("esto es lo que queda:"+ modprod.getCantidad_producto());
        }
        
        tablafactura.addRow(objeto);
        nv.tblnuevaVenta.setModel(tablafactura);
        calculartotventa();
        
       item+=1; 
       
    }
    }
        }catch(Exception e){
            
        }
 
}
    
    //calcular el total de la venta 
    public void calculartotventa(){
    total = 0;
   double totalproductos =0;
    
    for(int i=0; i<nv.tblnuevaVenta.getRowCount(); i++){
        cantidadpp = Double.parseDouble(nv.tblnuevaVenta.getValueAt(i, 4).toString());
       double precio = Double.parseDouble(nv.tblnuevaVenta.getValueAt(i, 5).toString());
        total+=(cantidadpp*precio);
        totalproductos +=cantidadpp;
     
    }
    nv.lbltotalventa.setText(String.valueOf(total));
       modfac.setMonto_facturacion(totalproductos);
}

    public void limpiarareaprod(){
        nv.txtbusquedaProductoNuevaVenta.setText("");
        nv.txtidprodnuevaventa.setText("");
        nv.txtnombreprodNuevaVenta.setText("");
        nv.txtstockProdNuevaVenta.setText("");
        nv.txtprecioProdNuevaVenta.setText("");
        nv.jspcantidadNuevaVenta.setValue(0);
        
    }
    //ver las ventas hechas en vista ventas
  public void vertablaguardarventa(){
             int numfilas = nv.tblnuevaVenta.getColumnCount();
                      
       String[] par = new String[numfilas];
       for( int i =0; i< numfilas; i++){
       par [i]= String .valueOf(nv.tblnuevaVenta.getValueAt(nv.tblnuevaVenta.getSelectedRow(), i));
 }
      
       nv.txtbusquedaProductoNuevaVenta.setText(par[1]);
       nv.txtidprodnuevaventa.setText(par[2]);
       nv.txtnombreprodNuevaVenta.setText(par[3]);
       nv.txtprecioProdNuevaVenta.setText(par[4]);
       int cantidad = Integer.parseInt(par[5]);
       nv.jspcantidadNuevaVenta.setValue(cantidad);
       
        //buscar el producto para ver el stock que quedo:
          
            modprod.setNumeroserie_producto(nv.txtbusquedaProductoNuevaVenta.getText().toString());
            
            boolean respuesta = daoprod.consultarprod(modprod);
            if(respuesta ==true){
               nv.txtstockProdNuevaVenta.setText(String.valueOf(modprod.getCantidad_producto()));
            }

  System.out.println("se esta haciendo click en la tabla");
  }
  
  //eliminar el producto añadido a la factura:
  public void eliminarproducto(){
      if(nv.txtidprodnuevaventa.getText().toString().equals("")){
           JOptionPane.showMessageDialog(nv, "Seleccione un producto añadido en la venta para eliminar");
      }else{
          String cantidad = String.valueOf(nv.jspcantidadNuevaVenta.getValue().toString());
          int cantidadprod = Integer.parseInt(cantidad);
          int idprod = Integer.parseInt(nv.txtidprodnuevaventa.getText().toString());
          int cantidaddisp =Integer.parseInt(nv.txtstockProdNuevaVenta.getText().toString());
         
          
           //añadir cantidad de regreseo al inventario
        while(modprod.getId_producto()==idprod){
            System.out.println("se esta ejecutando el while");
            
        int stockreset = cantidadprod+cantidaddisp;
        modprod.setCantidad_producto(stockreset);
        modprod.setId_producto(idprod);
        daoprod.editarproducto(modprod);
        
        idprod++;
        
        JOptionPane.showMessageDialog(nv, "Se elimino el producto de la venta");
    
        System.out.println("esto es lo que queda:"+ modprod.getCantidad_producto());
        }
          
      }
  }
  //lo utilizaremos para eliminar la fila del producto eliminado de la tabla de ventas
  public void eliminarfila(){
        if(nv.tblnuevaVenta.getSelectedRow()!=-1){
           tablafactura.removeRow(nv.tblnuevaVenta.getSelectedRow());
       limpiarareaprod();
       calculartotventa();
      }
         
 
  }
  
  //aqui vamos a añadir la venta total a la bd para despues ser mostrada en ventana facturacion
  public void guardarventabd(){
      //validaciones para el envio de la factura a la bd
      if(nv.lbltotalventa.getText().toString().equals("0.0")||nv.lbltotalventa.getText().toString().equals("")){
           JOptionPane.showMessageDialog(nv, "Añada productos para empezar una nueva venta");
   
      }else  if(nv.txtnitClienteNuevaVenta.getText().toString().equals("")){
           JOptionPane.showMessageDialog(nv, "Añada nit para guardar la venta");
           
      }else if(nv.txtidusuarioventas.getText().toString().equals("")){
          JOptionPane.showMessageDialog(nv, "Ingrese su numero de cajero");
   
      }else{
         //nos servira para buscar el id del cliente si es que se ha creado una cuenta con anterioridad:
         String dpicliente = nv.txtdpiClienteNuevaVenta.getText().toString();
         
         String nitcliente = nv.txtnitClienteNuevaVenta.getText().toString();
         int idcajero = Integer.parseInt(nv.txtidusuarioventas.getText().toString());
         double monto = Double.parseDouble(nv.lbltotalventa.getText().toString());
          
         //buscar cliente para ver si existe 
          modc.setDpi_cliente(dpicliente);
         
          boolean respuesta = daoc.consultarcliente(modc);
          int idcliente;
            if(respuesta == true){
                if(modc.getId_cliente()!=0){
               idcliente = modc.getId_cliente();
                }else{
                    idcliente = 3;
                }
            }else{
               idcliente = 3;
            }
            
        
        System.out.println("id: "+idcliente);
        //pasar a formato fecha
        LocalDate fechadhoy = LocalDate.now();//si sirve
        
        //pruebas-----------------------------------------
         System.out.println(fechadhoy);
         //---------------------------------------------------
         
         //contar la cantidad de productos que van a ser vendidos:
          int totalproductos =0;
    
    for(int i=0; i<nv.tblnuevaVenta.getRowCount(); i++){
        cantidadpp = Integer.parseInt(nv.tblnuevaVenta.getValueAt(i, 5).toString());
        totalproductos +=cantidadpp;
     
    }
     //setteamos el modelo factura:
       modfac.setCantidad_facturacion(totalproductos);
         System.out.println("cantidad: "+modfac.getCantidad_facturacion());
         
         modfac.setFecha_facturacion(String.valueOf(fechadhoy));
         modfac.setIdcajero_facturacion(idcajero);
         modfac.setIdcliente_facturacion(idcliente);
         modfac.setMonto_facturacion(monto);
         modfac.setNit_facturacion(nitcliente);
         
        boolean respuesta2 = daofac.agregar(modfac);
            if(respuesta ==true){
                JOptionPane.showMessageDialog(nv, "se guardó la venta");
                tablafactura.getDataVector().removeAllElements();
                nv.tblnuevaVenta.updateUI();
                limpiarareaprod();
                nv.txtdpiClienteNuevaVenta.setText("");
                nv.txtnitClienteNuevaVenta.setText("");
                nv.txtidusuarioventas.setText("");
                nv.lbltotalventa.setText("");
            }
      }
  }
    
    @Override
    public void actionPerformed(ActionEvent e) {
    if(e.getSource()==nv.btnbuscarprod){
        buscarproducto();
    }else if(e.getSource()==nv.btnañadirprodNuevaVenta){
         agregarprodventatabla();
         limpiarareaprod();
    }else if(e.getSource()==nv.btndescartarNuevaVenta){
        nv.setVisible(false);
    }else if(e.getSource()==nv.btneliminarNuevaVenta){
        eliminarproducto();
        eliminarfila();
    }else if(e.getSource()==nv.btnguardarNuevaVenta){
        guardarventabd();
    }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource()==nv.tblnuevaVenta){
            vertablaguardarventa();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
            
}
