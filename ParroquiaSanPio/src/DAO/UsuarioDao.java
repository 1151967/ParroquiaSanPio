/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Modelo.Usuario;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author SrLob
 */
public class UsuarioDao {
    
    Conexion c;

    public UsuarioDao() {
        c = new Conexion();
                
    }
    
        public boolean guardar(Usuario u){
    
        String sql = "INSERT INTO usuario (cedula,nombre,direccion,telefono,estrato,estado) VALUES(?,?,?,?,?,?)";
        try {
            PreparedStatement ps = (PreparedStatement) c.obtener().prepareStatement(sql);
            ps.setInt(1, u.getCedula());
            ps.setString(2, u.getNombre());
            ps.setString(3, u.getDireccion());
            ps.setString(4, u.getTelefono());
            ps.setByte(5, u.getEstrato());
            ps.setString(6, u.getEstado());
            ps.execute();
            c.cerrar();
            ps.close();
            ps = null;
            return true;
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
            
    
    }
    
    
}
