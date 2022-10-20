
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.ModeloUsuario;
import vista.CrearUsuarios;

public class controladorUsuario implements ActionListener{
    
    CrearUsuarios usuario = new CrearUsuarios();
    ModeloUsuario modusuario = new ModeloUsuario();

    public controladorUsuario() {
        
        usuario.setVisible(true);
        usuario.btnGuardarUsuario.addActionListener(this);
        usuario.btnEditarUsuario.addActionListener(this);
        usuario.btnEliminarUsuario.addActionListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == usuario.btnGuardarUsuario){
            System.out.println("Se preciono en el boton guardar");
            guardarUsuario();
        }
    }
    
    private void guardarUsuario(){
        
        modusuario.setNombre_usuario(usuario.txtnombreUsuario.getText());
        modusuario.setApellido_usuario(usuario.txtapellidoUsuario.getText());
        modusuario.setCorreo_usuario(usuario.txtcorreoUsuario.getText());
        modusuario.setDireccion_usuario(usuario.txtdireccionUsuario.getText());
        modusuario.setDpi_usuario(usuario.txtdpiUsuario.getText());
        modusuario.setPwd_usuario(usuario.txtpassUsuario.getText());
        modusuario.setUser_usuario(usuario.txtuserUsuario.getText());
        modusuario.setTelefono_usuario(usuario.txttelefonoUsuario.getText());
        //modusuario.setGenero_usuario(usuario.txt);
        
    }
    
    private void limpiar(){
        
    }
    
}
