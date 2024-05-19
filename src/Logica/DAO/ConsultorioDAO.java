/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica.DAO;

import BD.ConexionBD;
import Logica.Models.Consultorio;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author JDiego
 */
public class ConsultorioDAO {
    ConexionBD cn;
    
    public ConsultorioDAO(){
        this.cn = new ConexionBD();
    }
    
    //CONSULTORIOS
    public void insertarConsultorio(Consultorio con) throws SQLException{
        String statement = "INSERT INTO consultorio(numero_con,especialidad_id,sede_id) VALUES (?,?,?)";
        PreparedStatement pg = cn.getConexion().prepareStatement(statement);
        pg.setInt(1, con.getNumero());
        pg.setInt(2, con.getEspecialidad().getId());
        pg.setInt(3, con.getSede().getId());
        pg.executeUpdate();
        pg.close();     
    }
}
