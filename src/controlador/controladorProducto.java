
package controlador;

import dao.daoProducto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.ModeloProducto;
import vista.Producto;

/**
 *
 * @author dave_
 */
public class controladorProducto implements ActionListener{
    
    //Instancia de clases
    daoProducto daoproduct = new daoProducto();
    ModeloProducto modproduct = new ModeloProducto();
    Producto producto = new Producto();

    public controladorProducto() {
        
        producto.setVisible(true);
        producto.btnGuardarProducto.addActionListener(this);
        producto.btnEditarProducto.addActionListener(this);
        producto.btnEliminarProducto.addActionListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == producto.btnGuardarProducto){
            guardarProducto();
        }
    }
    
    public void guardarProducto(){
        
        System.out.println("Se preciono el boton guardar");
        modproduct.setNombre_producto(producto.txtNombreProducto.getText());
        modproduct.setPrecio_producto(Double.parseDouble(producto.txtPrecioProducto.getText()));
        modproduct.setCantidad_producto(Integer.parseInt(producto.txtCantidadProducto.getText()));
        modproduct.setNumeroserie_producto(producto.txtNSerieProducto.getText());
        String respuesta = daoproduct.guardarProducto(modproduct);
        
        if(respuesta!=null){
            
            JOptionPane.showMessageDialog(null, respuesta);
            limpiar();
                
            }
            else{
                 JOptionPane.showMessageDialog(null, respuesta);
            }
        
    }
    
    private void limpiar(){
        
        producto.txtNombreProducto.setText("");
        producto.txtPrecioProducto.setText("");
        producto.txtCantidadProducto.setText("");
        producto.txtNSerieProducto.setText("");
        
    }
    
}
