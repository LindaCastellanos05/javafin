/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.ModeloUsuario;
import vista.PerfilVendedor;

/**
 *
 * @author Linda
 */
public class controladorVendedor {
    //instanciamos clases que usamos:
    PerfilVendedor vendedor = new PerfilVendedor();
    
    
    //constructor para acceder a la clase
    public controladorVendedor(ModeloUsuario modu){
        vendedor.setVisible(true);
    }
}
