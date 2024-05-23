/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica.DAO;

import BD.ConexionBD;
import Logica.Models.Cita;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;

/**
 *
 * @author JDiego
 */
public class CitaDAO {
    ConexionBD cn;

    public CitaDAO() {
        this.cn = new ConexionBD();
    }

    public ResultSet obtenerCita(int id) throws SQLException {
        PreparedStatement pg = cn.getConexion().prepareStatement("SELECT * FROM agenda WHERE id_cita = ?");
        pg.setInt(1, id);
        ResultSet rg = pg.executeQuery();
        return rg;
    }

    public void insertarCita(Cita cita) throws SQLException {

        int id = 0;

        String statement = "INSERT INTO cita(fecha_cita,hora_inicio,hora_fin,estado_id,agenda_id) VALUES (?,?,?,?,?)";
        PreparedStatement pg = cn.getConexion().prepareStatement(statement);
        pg.setDate(1, cita.getFecha());
        pg.setTime(2, Time.valueOf(cita.getHora_inicio()));
        pg.setTime(3, Time.valueOf(cita.getHora_fin()));
        pg.setInt(4, cita.getEstado().getId());
        pg.setInt(5, cita.getAgenda().getId());
        pg.executeUpdate();
        pg.close();
    }
}
