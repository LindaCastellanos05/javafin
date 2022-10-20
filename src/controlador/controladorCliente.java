/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.daoCliente;
import dao.daoUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.modeloCliente;
import vista.CrearCliente;

/**
 *
 * @author Juan Pablo
 */
public class controladorCliente implements ActionListener, MouseListener{
    
    modeloCliente modcliente = new modeloCliente();
    daoCliente daocliente = new daoCliente();
    CrearCliente cliente = new CrearCliente();

   
    public controladorCliente(modeloCliente modelo) {
        cliente.setVisible(true);
        cliente.btnguardar.addActionListener(this);
        cliente.btneditar.addActionListener(this);
        cliente.btneliminar.addActionListener(this);
        listaclientes(cliente.tblclientes);
        
    }
    
    
    
    public void guardarcliente(){
        System.out.println("Se presiona el boton");
        if(cliente.txtnombre.getText().equals("") && cliente.txtapellido.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Llenar los campos vacios");
        }
        
        else{
            
            modcliente.setNombre_cliente(cliente.txtnombre.getText());
            modcliente.setApellido_cliente(cliente.txtapellido.getText());
            modcliente.setNit_cliente(cliente.txtnit.getText());
            modcliente.setTel_cliente(cliente.txtcelular.getText());
            modcliente.setDireccion_cliente(cliente.txtgenero.getText());
            modcliente.setDpi_cliente(cliente.txtdpi.getText());
            modcliente.setCorreo_cliente(cliente.txtcorreo.getText());
            modcliente.setIdgenero_cliente(Integer.parseInt(cliente.txtgenero.getText()));
            
            String respuesta = daocliente.guardarcliente(modcliente);
            fecha();
            
            if(respuesta != null){
                JOptionPane.showMessageDialog(null, "Se guardo el usuario");
                fecha();
            }
            else{
                JOptionPane.showMessageDialog(null, "No se guardo el usuario");
            }
        }
        
    }
    
    public void editarcliente(){
         System.out.println("Se presiona el boton");
        if(cliente.txtnombre.getText().equals("") && cliente.txtapellido.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Llenar los campos vacios");
        }
        else{
            
            modcliente.setNombre_cliente(cliente.txtnombre.getText());
            modcliente.setApellido_cliente(cliente.txtapellido.getText());
            modcliente.setNit_cliente(cliente.txtnit.getText());
            modcliente.setTel_cliente(cliente.txtcelular.getText());
            modcliente.setDireccion_cliente(cliente.txtgenero.getText());
            modcliente.setDpi_cliente(cliente.txtdpi.getText());
            modcliente.setCorreo_cliente(cliente.txtcorreo.getText());
            modcliente.setIdgenero_cliente(Integer.parseInt(cliente.txtgenero.getText()));
            
            boolean respuesta = daocliente.editarcliente(modcliente);
            
            if(respuesta != true){
                JOptionPane.showMessageDialog(null, "Se actualizo el registro");
            }
            else{
                JOptionPane.showMessageDialog(null, "No se actualizo el registro");
            }
            
        }
        
    }
    
    public void eliminarcliente(){
         System.out.println("Se presiona el boton");
        if(cliente.txtnombre.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Llenar los campos vacios");
        }
        else{
            modcliente.setNombre_cliente(cliente.txtnombre.getText());
            
            if(daocliente.eliminarcliente(modcliente)){
                JOptionPane.showMessageDialog(null, "Se elimino el registro");
            }
            else{
                JOptionPane.showMessageDialog(null, "No se actualizo el registro");
            }
        }
               

    }
    
    public void limpiarregistro(){
        cliente.txtnombre.setText("");
        cliente.txtapellido.setText("");
        cliente.txtcorreo.setText("");
        cliente.txtgenero.setText("");
        cliente.txtdpi.setText("");
        cliente.txtnit.setText("");
        cliente.txtcelular.setText("");
        cliente.txtgenero.setText("");
        
        
    }
    
    public void fecha(){
        
        Date date = new Date();
        long d = date.getTime();
        SimpleDateFormat nuevoformato = new SimpleDateFormat("yyyy-MM-dd");
        nuevoformato.format(cliente.txtfecha.getDate());
        
        
    }
    
   
    public void listaclientes(JTable tblclientes){
        DefaultTableModel mimodel = new DefaultTableModel();
        tblclientes.setModel(mimodel);
        
        mimodel.addColumn("Id");
        mimodel.addColumn("Nombre");
        mimodel.addColumn("Apellido");
        mimodel.addColumn("Fecha Nac");
        mimodel.addColumn("Nit");
        mimodel.addColumn("Celular");
        mimodel.addColumn("Direccion");
        mimodel.addColumn("Dpi");
        mimodel.addColumn("Genero");
        mimodel.addColumn("Correo");
        
        Object[] columna = new Object[10];
         int numeroregistro = daocliente.listacliente().size();
         System.out.println(numeroregistro);
         
         for(int i=0; i<numeroregistro; i++){
             columna[1] = daocliente.listacliente().get(i).getId_cliente();
             columna[2] = daocliente.listacliente().get(i).getNombre_cliente();
             columna[3] = daocliente.listacliente().get(i).getApellido_cliente();
             columna[4] = daocliente.listacliente().get(i).getFecha_nacimiento();
             columna[5] = daocliente.listacliente().get(i).getNit_cliente();
             columna[6] = daocliente.listacliente().get(i).getTel_cliente();
             columna[7] = daocliente.listacliente().get(i).getDireccion_cliente();
             columna[8] = daocliente.listacliente().get(i).getDpi_cliente();
             columna[9] = daocliente.listacliente().get(i).getIdgenero_cliente();
             columna[10] = daocliente.listacliente().get(i).getCorreo_cliente();
             mimodel.addRow(columna);
                     
         }
          
         
   
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         
        if(e.getSource() == cliente.btnguardar){
            System.out.println("Se presiono el boton");
            guardarcliente();
            limpiarregistro();
        }
        if(e.getSource() == cliente.btneditar){
            System.out.println("Se presiono el boton");
            editarcliente();
            limpiarregistro();
        }
        if(e.getSource() == cliente.btneliminar){
            System.out.println("Se presiono el boton");
            eliminarcliente();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
        if(e.getSource() == cliente.tblclientes){
            //cliente.tblclientes();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
      
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
         
    }

    @Override
    public void mouseExited(MouseEvent e) {
         
    }
    
    
}
