/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.ModeloUsuario;
import vista.PerfilBodeguero;

/**
 *
 * @author Linda
 */
public class controladorBodeguero {
    //instancia de clases que vamos a usar
    PerfilBodeguero bodeguero = new PerfilBodeguero();
    
    //constructor para acceder a la clase
    public controladorBodeguero(ModeloUsuario modu){
        bodeguero.setVisible(true);
    }
}
