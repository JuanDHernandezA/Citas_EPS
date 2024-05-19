/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica.DAO;

import BD.ConexionBD;
import Logica.Models.Paciente;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author JDiego
 */
public class PacienteDAO {
    ConexionBD cn;

    public PacienteDAO() {
        this.cn = new ConexionBD();
    }
    
    public void insertarPaciente(Paciente paciente) throws SQLException {
        String statement = "INSERT INTO paciente VALUES (?,?,?,?,?,?,?,?,?)";
        PreparedStatement pg = cn.getConexion().prepareStatement(statement);
        pg.setInt(1, paciente.getTd().getId());
        pg.setString(2, paciente.getIdentificacion());
        pg.setString(3, paciente.getNombre());
        pg.setString(4, paciente.getApellido());
        pg.setString(5, paciente.getCorreo());
        pg.setString(6, paciente.getTelefono());
        pg.setDate(7, paciente.getFecha_nacimiento());
        pg.setInt(8, paciente.getGenero().getId());
        pg.setInt(9, paciente.getCategoria().getId());
        pg.executeUpdate();
        pg.close();
    }
}
