/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BD;

import Logica.Sede;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author JDiego
 */
public class ConsultasDB {
    
    ConexionBD cn;
    
    public ConsultasDB(){
        this.cn = new ConexionBD();
    }
    
    public ResultSet obtenerEspecialidad(int id) throws SQLException{
        PreparedStatement pg = cn.getConexion().prepareStatement("SELECT *"
                + "FROM especialidad WHERE id_esp = ?");
        
        pg.setInt(1, id);
        ResultSet rg = pg.executeQuery();
        return rg;
    }
    
    public void insertarSede(Sede sede) throws SQLException{
        String statement = "INSERT INTO sede(nombre_sede,direccion) VALUES (?,?)";
        PreparedStatement pg = cn.getConexion().prepareStatement(statement);
        pg.setString(1, sede.getNombre());
        pg.setString(2, sede.getDireccion());
        pg.executeUpdate();
        pg.close();     
    }
}
