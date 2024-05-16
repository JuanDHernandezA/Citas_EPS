/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package citas_eps;

import BD.ConsultasDB;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author JDiego
 */
public class Citas_EPS {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        ConsultasDB con = new ConsultasDB();
        ResultSet rs;
        
        
        
        rs = con.obtenerUsuario(5);
        
        while (rs.next()) {
            System.out.println(rs.getString("id_esp"));
            System.out.println(rs.getString("nombre_esp"));  // Asegúrate de cambiar "tuColumna" por el nombre real de tu columna.
        }
        
    }
    
}
