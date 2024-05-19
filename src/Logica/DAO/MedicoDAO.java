/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica.DAO;

import BD.ConexionBD;
import Logica.Models.Medico;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author JDiego
 */
public class MedicoDAO {
    
    ConexionBD cn;

    public MedicoDAO() {
        this.cn = new ConexionBD();
    }
    
    public void insertarMedico(Medico medico) throws SQLException {
        String statement = "INSERT INTO medico VALUES (?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement pg = cn.getConexion().prepareStatement(statement);
        pg.setInt(1, medico.getTd().getId());
        pg.setString(2, medico.getIdentificacion());
        pg.setString(3, medico.getNombre());
        pg.setString(4, medico.getApellido());
        pg.setString(5, medico.getCorreo());
        pg.setString(6, medico.getTelefono());
        pg.setDate(7, medico.getFecha_nacimiento());
        pg.setString(8, medico.getRegistro_profesional());
        pg.setInt(9, medico.getGenero().getId());
        pg.setInt(10, medico.getEspecialidad().getId());
        pg.executeUpdate();
        pg.close();
    }
}
