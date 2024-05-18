/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package citas_eps;

import BD.ConsultasDB;
import Interfaz.VenMenuIngreso;
import Interfaz.VenRegistroSede;
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
        
        /* PARA PROBAR LA CONEXIÓN A LA BD
        ConsultasDB con = new ConsultasDB();
        ResultSet rs;
        
        rs = con.obtenerEspecialidad(5);
        
        while (rs.next()) {
            System.out.println(rs.getString("id_esp"));
            System.out.println(rs.getString("nombre_esp"));
        }*/
        
        new VenMenuIngreso();
        
    }
    
}
