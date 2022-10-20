/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.daoLogin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.ModeloUsuario;
import vista.Login;

/**
 *
 * @author Linda
 */
public class controladorLogin implements ActionListener{
//Instanciamos clases que utilizaremos:
    daoLogin daologin = new daoLogin();
    ModeloUsuario moduser = new ModeloUsuario();
    Login login = new Login();
    
    public controladorLogin(ModeloUsuario mu){
        login.setVisible(true);
        login.btningresarlogin.addActionListener(this);
        login.btnsalirlogin.addActionListener(this);
    }
    
    public void verificarInicioSesion(){
        System.out.println("se esta haciendo click en el boton");
         if(login.txtuserlogin.getText().toString().equals("")||login.txtpasslogin.getPassword().equals("")){
             JOptionPane.showMessageDialog(null, "Escriba usuario y contraseña por favor");
         }else{
             String user = login.txtuserlogin.getText().toString();
             
             //cast a String para que podamos leer el txtpassword
             String pwd = new String (login.txtpasslogin.getPassword());
             
             moduser.setUser_usuario(user);
             moduser.setPwd_usuario(pwd);
             
            int respuesta = daologin.login(moduser);
            
            //si es admin
            if(respuesta==1){
                System.out.println("Bienvenido");
                JOptionPane.showMessageDialog(null, "Bienvenido "+user);
                controladorAdmin ca = new controladorAdmin(moduser);
                
            //si es cajero
            }else if(respuesta==2){
                System.out.println("Bienvenido");
                JOptionPane.showMessageDialog(null, "Bienvenido "+user);
                controladorCajero cc = new controladorCajero(moduser);
                
            //si es vendedor    
            }else if(respuesta==3){
                System.out.println("Bienvenido");
                JOptionPane.showMessageDialog(null, "Bienvenido "+user);
                controladorVendedor cv = new controladorVendedor(moduser);
                
            //si es bodeguero
            }else if(respuesta==4){
                System.out.println("Bienvenido");
                JOptionPane.showMessageDialog(null, "Bienvenido "+user);
                controladorBodeguero cb = new controladorBodeguero(moduser);
                
            }else{
                System.out.println("Usuario y/o contraseña incorrectos :c");
                 JOptionPane.showMessageDialog(null, "Usuario y/o contraseña incorrectos :c");
            }
         }
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
    if(e.getSource().equals(login.btningresarlogin)){
        verificarInicioSesion();
    }else if (e.getSource()==login.btnsalirlogin){
        System.exit(0);
    }
    }
    
}
