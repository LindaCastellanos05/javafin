/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.List;

/**
 *
 * @author Linda
 */
public interface crudInterface <obj> {
    
     public boolean agregar(Object obj);
    public boolean eliminar(int id);
    public boolean modificar(Object obj);
    public List<?> mostrartodo(Object obj);
    public List<?> buscar (int i);
    
}
