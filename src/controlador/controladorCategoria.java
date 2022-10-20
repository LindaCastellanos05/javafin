/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.daoCategoria;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import modelo.modeloCategoria;
import vista.CrearCategoria;

/**
 *
 * @author Linda
 */
public class controladorCategoria implements ActionListener, MouseListener{
    //Instanciar clases que vamos a usar:
    daoCategoria dc = new daoCategoria();
    modeloCategoria mc = new modeloCategoria();
    CrearCategoria cc = new CrearCategoria();
    
    public controladorCategoria(modeloCategoria modcat){
        cc.setVisible(true);
        this.cc.btnguardarcategoria.addActionListener(this);
        
    }
    
    public void agregar(){
        System.out.println("se esta haciendo click en el boton");
        
        if(cc.txtnombrecategoria.getText().toString().equals("")){
            JOptionPane.showMessageDialog(null, "Ingrese una categoria para agregar");
        }else{
        String nombre = cc.txtnombrecategoria.getText().toString();
        mc.setDescripcion_categoria(nombre);
    }
        
        boolean respuesta = dc.agregar(mc);
         
           
           if(respuesta){
               JOptionPane.showMessageDialog(cc, "Se ha guardado correctamente");
               limpiar();
               
           } else{
                JOptionPane.showMessageDialog(cc, "No se ha podido guardar");
           }
           
    }
    
    public void limpiar(){
        cc.txtnombrecategoria.setText("");
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
    if(e.getSource()==cc.btnguardarcategoria){
        System.out.println("se esta haciendo click en el boton");
        agregar();
    }   
    }

    @Override
    public void mouseClicked(MouseEvent e) {
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
