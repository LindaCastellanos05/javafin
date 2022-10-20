/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.daoEstado;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.modeloEstado;
import vista.CrearEstado;

/**
 *
 * @author Linda
 */
public class controladorEstado implements ActionListener{
    //instancia de clases que usaremos:
    modeloEstado mode = new modeloEstado();
    daoEstado daoEstado = new daoEstado();
    CrearEstado ce = new CrearEstado();
    
    //creamos nuestro constructor para acceder a la clase y sus metodos...
    public controladorEstado(modeloEstado mode){
        ce.setVisible(true);
        ce.btnguardarEstado.addActionListener(this);
    }
 public void agregar(){
        System.out.println("se esta haciendo click en el boton");
        
        if(ce.txtnombreEstado.getText().toString().equals("")){
            JOptionPane.showMessageDialog(null, "Ingrese un estado para agregar");
        }else{
        String nombre = ce.txtnombreEstado.getText().toString();
        mode.setDescripcion_estado(nombre);
    }
        
        boolean respuesta = daoEstado.agregar(mode);
         
           
           if(respuesta){
               JOptionPane.showMessageDialog(null, "Se ha guardado correctamente");
               limpiar();
               
           } else{
                JOptionPane.showMessageDialog(null, "No se ha podido guardar");
           }
           
    }
 
 public void limpiar(){
     ce.txtnombreEstado.setText("");
 }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==ce.btnguardarEstado){
            agregar();
        }
    }
}
