/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica.DAO;

import BD.ConexionBD;
import Logica.Models.Agenda;
import Logica.Models.Cita;
import Logica.Models.Estado;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JDiego
 */
public class CitaDAO {

    ConexionBD cn;

    public CitaDAO() {
        this.cn = new ConexionBD();
    }

    public List obtenerCitas(int id) {

        List<Cita> citas = new ArrayList<>();
        
        try {
            PreparedStatement pg = cn.getConexion().prepareStatement("SELECT * FROM cita WHERE agenda_id = ?");
            pg.setInt(1, id);
            ResultSet rg = pg.executeQuery();

            while (rg.next()) {
                citas.add(new Cita(rg.getDate("fecha_cita"), rg.getTime("hora_inicio").toLocalTime(), rg.getTime("hora_fin").toLocalTime(), new Estado(rg.getInt("estado_id")), null, new Agenda(rg.getInt("agenda_id")), null));
            }
            return citas;
        } catch (Exception e) {
            System.out.println("error sql");
            System.out.println(e);
            return null;
        }
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
