/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import DAO.UsuarioDao;
import Modelo.Usuario;
import Vista.Vista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author SrLob
 */
public class Controlador implements ActionListener{
    Vista v;
    Usuario u;
    UsuarioDao dao;
    
    public static void main(String[] args) {
        Controlador c = new Controlador();
    }

    public Controlador() {
        v = new Vista();
        dao = new UsuarioDao();
        
        v.btnGuardar.addActionListener(this);
                
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        
          if(e.getSource() == v.btnGuardar){
            //Aqui va el codigo para agregar registro
            u = new Usuario();
            u.setCedula((Integer.parseInt( v.txtCedulaFeligres.getText() )));
            u.setNombre(v.txtNombre.getText());
            u.setDireccion(v.txtDireccion.getText());
            u.setTelefono(v.txtTelefono.getText());
            u.setEstrato(Byte.parseByte(v.txtEstrato.getText()));
            u.setEstado(v.txtEstado.getText());
      
            if(!dao.guardar(u)){
               JOptionPane.showMessageDialog(this.v, "No se inserto el producto exitosamente.");
                
            }
           
        }
        
    }
    
    
}
