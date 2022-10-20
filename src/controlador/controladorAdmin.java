/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.ModeloUsuario;
import vista.PerfilAdmin;

/**
 *
 * @author Linda
 */
public class controladorAdmin {
    //instanciaremos las clases que vamos a utilizar en nuestro controlador
    PerfilAdmin admin = new PerfilAdmin();
   
    
    public controladorAdmin(ModeloUsuario modusuario){
        admin.setVisible(true);
    }
}
