/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.daoFacturacion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import modelo.modeloFacturacion;
import vista.Facturacion;

/**
 *
 * @author Linda
 */
public class controladorFactura implements ActionListener, MouseListener {
     //instancia de clases
    daoFacturacion daofac = new daoFacturacion();
    modeloFacturacion modfac = new modeloFacturacion();
    Facturacion factura = new Facturacion();
    daoFacturacion daofacturacion = new daoFacturacion();
    //tabla
    DefaultTableModel tablafactura = new DefaultTableModel();
    ArrayList<modeloFacturacion> dataVentas = new ArrayList<>();
    TableRowSorter trs;
    
    public controladorFactura(modeloFacturacion modfac){
        factura.setVisible(true);
        ventasRealizadas(factura.tblventasfacturacion);
        factura.tblventasfacturacion.addMouseListener(this);
        factura.btnfacturacion1.addActionListener(this);
        totaldeventas();
        factura.btncancel.addActionListener(this);
        
    }
    
    //mostrar el historial de ventas 
    public void ventasRealizadas(JTable tbl){
        factura.tblventasfacturacion.setModel(tablafactura);
        Object[] col= new Object[7];
        
        tablafactura.addColumn("ID");
        tablafactura.addColumn("CANTIDAD");
        tablafactura.addColumn("MONTO");
        tablafactura.addColumn("FECHA");
        tablafactura.addColumn("NIT");
        tablafactura.addColumn("ID CLIENTE");
        tablafactura.addColumn("ID CAJERO");
        
        
        
       
         dataVentas = (ArrayList<modeloFacturacion>) daofacturacion.mostrartodo(modfac);
          int numeroventas = daofacturacion.mostrartodo(modfac).size();
        System.out.println(numeroventas);
        
        
        //lleno mi tabla con los datos previamente ingresados en la base de datos
        for(int i=0; i<numeroventas; i++){
           
         col[0] = dataVentas.get(i).getId_facturacion();
         col[1] = dataVentas.get(i).getCantidad_facturacion();
         col[2] = dataVentas.get(i).getMonto_facturacion();
         col[3] = dataVentas.get(i).getFecha_facturacion();
         col[4] = dataVentas.get(i).getNit_facturacion();
         col[5] = dataVentas.get(i).getIdcliente_facturacion();
         col[6] = dataVentas.get(i).getIdcajero_facturacion();
        
         
         tablafactura.addRow(col);
         
         
        }
        factura.tblventasfacturacion.setModel(tablafactura);
        
    }
    //buscar facturaciones por fechas seleccionadas
    public void buscar(){
        
            if(factura.txtfechaFac.getDate()==null){
                JOptionPane.showMessageDialog(null, "Debe seleccionar una fecha para proceder a la busqueda");
            }else{
                //pasar a formato fecha
           Date date = new Date();
             SimpleDateFormat nuevoformato= new SimpleDateFormat("yyyy-MM-dd");
               SimpleDateFormat simpleTime = new SimpleDateFormat("hh:mm:ss");
             String fecha0=nuevoformato.format(factura.txtfechaFac.getDate());
             String hora = simpleTime.format(date);
          
             String fecha =fecha0 +" "+hora;
             
        daofac.buscarfecha(fecha0);
        
         if(daofac.buscarfecha(fecha0).isEmpty()){
           JOptionPane.showMessageDialog(null, "error, no hay facturas en fecha seleccionada");
          
         }else{
             //Usamos el Tablerowsorter para poder filtrar los datos de la tabla segun la fecha que buscamos
           System.out.println(fecha0);
           trs = new TableRowSorter(tablafactura);   
           trs.setRowFilter(RowFilter.regexFilter(fecha0, 3));
              factura.tblventasfacturacion.setRowSorter(trs);
              totaldeventas();
            }
            }
           
        
        
    }
    //calcular el total de ganancias de ventas
    public void totaldeventas(){
 
   double fila=0;
   double total=0;
   
    for(int i=0; i<factura.tblventasfacturacion.getRowCount(); i++){
        fila= Double.parseDouble(factura.tblventasfacturacion.getValueAt(i, 2).toString());
        total+=fila;
     
    }
    factura.lbltotalventas.setText(String.valueOf("   Q"+total));
}
    //accion de ver la tabla en los edit text
    public void vertabla(){
         int numfilas = factura.tblventasfacturacion.getColumnCount();
                      
       String[] par = new String[numfilas];
       for( int i =0; i< numfilas; i++){
       par [i]= String .valueOf(factura.tblventasfacturacion.getValueAt(factura.tblventasfacturacion.getSelectedRow(), i));
 }
 
       //colocar cada dato:
       factura.txtcantidadFac.setText(par[1]);
       factura.txtidfac.setText(par[0]);
       factura.txtmontoFac.setText(par[2]);
       
       
       
      /* LocalDateTime localDateTime = LocalDateTime.parse(par[3]);
       Date convertedDatetime = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
       factura.txtfechaFac.setDate(convertedDatetime);*/
       
       
       factura.txtnitFac.setText(par[4]);
       factura.txtclienteFac.setText(par[5]);
       factura.txtusuarioFac.setText(par[6]);
       
       

  System.out.println("se esta haciendo click en la tabla");
  
    }
    
    //metodo para cuando querramos regresar al principio a ver todas las facturas
    public void resetTable(){
         factura.tblventasfacturacion.setRowSorter(null);
           totaldeventas();
           factura.txtfechaFac.setDate(null);
           factura.txtcantidadFac.setText("");
           factura.txtclienteFac.setText("");
           factura.txtidfac.setText("");
           factura.txtmontoFac.setText("");
           factura.txtnitFac.setText("");
           factura.txtusuarioFac.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource()== factura.btnfacturacion1){
           buscar();
       }if(e.getSource()==factura.btncancel){
           resetTable();
       }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource()== factura.tblventasfacturacion){
            vertabla();
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
