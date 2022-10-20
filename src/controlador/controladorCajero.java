/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.ModeloUsuario;
import vista.PerfilCajero;

/**
 *
 * @author Linda
 */
public class controladorCajero {
    //vamos a instanciar las clases que necesitamos:
    PerfilCajero cajero = new PerfilCajero();
    
    public controladorCajero(ModeloUsuario modu){
        cajero.setVisible(true);
    }
}
