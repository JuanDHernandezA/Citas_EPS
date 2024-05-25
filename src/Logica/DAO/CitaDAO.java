/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica.DAO;

import BD.ConexionBD;
import Logica.Models.Agenda;
import Logica.Models.Cita;
import Logica.Models.Especialidad;
import Logica.Models.Estado;
import Logica.Models.HistoriaClinica;
import Logica.Models.Paciente;
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
            PreparedStatement pg = cn.getConexion().prepareStatement("SELECT * FROM cita WHERE agenda_id = ? ORDER BY id_cita");
            pg.setInt(1, id);
            ResultSet rg = pg.executeQuery();

            while (rg.next()) {
                citas.add(new Cita(rg.getInt("id_cita"),rg.getDate("fecha_cita"), rg.getTime("hora_inicio").toLocalTime(), rg.getTime("hora_fin").toLocalTime(), new Estado(rg.getInt("estado_id")), null, new Agenda(rg.getInt("agenda_id")), null));
            }
            return citas;
        } catch (Exception e) {
            System.out.println("error sql");
            System.out.println(e);
            return null;
        }
    }
    
    public List obtenerCitasEsp(Especialidad esp) {

        List<Cita> citas = new ArrayList<>();
        
        try {
            PreparedStatement pg = cn.getConexion().prepareStatement("SELECT * FROM cita INNER JOIN agenda ON cita.agenda_id = agenda.id_agenda INNER JOIN medico ON agenda.medico_id = medico.id_med WHERE medico.especialidad_id = ? AND cita.estado_id = 1");
            pg.setInt(1, esp.getId());
            ResultSet rg = pg.executeQuery();

            while (rg.next()) {
                citas.add(new Cita(rg.getInt("id_cita"),rg.getDate("fecha_cita"), rg.getTime("hora_inicio").toLocalTime(), rg.getTime("hora_fin").toLocalTime(), new Estado(rg.getInt("estado_id")), null, new Agenda(rg.getInt("agenda_id")), null));
            }
            return citas;
        } catch (Exception e) {
            System.out.println("error sql");
            System.out.println(e);
            return null;
        }
    }
    
    public Cita obtenerCita(int id) {

        Cita cita = null;
        
        try {
            PreparedStatement pg = cn.getConexion().prepareStatement("SELECT * FROM cita WHERE id_cita = ?");
            pg.setInt(1, id);
            ResultSet rg = pg.executeQuery();

            while (rg.next()) {
                cita = new Cita(rg.getInt("id_cita"),rg.getDate("fecha_cita"), rg.getTime("hora_inicio").toLocalTime(), rg.getTime("hora_fin").toLocalTime(), new Estado(rg.getInt("estado_id")), new Paciente(rg.getString("paciente_id")), new Agenda(rg.getInt("agenda_id")), new HistoriaClinica(rg.getInt("hc_id")));
            }
            return cita;
        } catch (Exception e) {
            System.out.println("error sql");
            System.out.println(e);
            return null;
        }
    }
    
    public List obtenerCitaPaciente(Paciente paciente) {

        List<Cita> citas = new ArrayList<>();
        
        try {
            PreparedStatement pg = cn.getConexion().prepareStatement("SELECT * FROM cita WHERE paciente_id = ?");
            pg.setString(1, paciente.getIdentificacion());
            ResultSet rg = pg.executeQuery();

            while (rg.next()) {
                Cita cita = new Cita(rg.getInt("id_cita"),rg.getDate("fecha_cita"), rg.getTime("hora_inicio").toLocalTime(), rg.getTime("hora_fin").toLocalTime(), new Estado(rg.getInt("estado_id")), null, new Agenda(rg.getInt("agenda_id")), null);
                citas.add(cita);
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
    
    public void insertarPaciente(Cita cita, Paciente paciente) throws SQLException {
        
        String statement = "UPDATE cita SET paciente_id = ? WHERE id_cita = ? ";
        PreparedStatement pg = cn.getConexion().prepareStatement(statement);
        pg.setString(1, paciente.getIdentificacion());
        pg.setInt(2, cita.getId());
        pg.executeUpdate();
        pg.close();
    }
    
    public void cancelarCita(Cita cita) throws SQLException {
        
        String statement = "UPDATE cita SET paciente_id = null WHERE id_cita = ? ";
        PreparedStatement pg = cn.getConexion().prepareStatement(statement);
        pg.setInt(1, cita.getId());
        pg.executeUpdate();
        pg.close();
    }
    
    public void insertarEstado(int estado, Cita cita) throws SQLException {
        
        String statement = "UPDATE cita SET estado_id = ? WHERE id_cita = ? ";
        PreparedStatement pg = cn.getConexion().prepareStatement(statement);
        pg.setInt(1, estado);
        pg.setInt(2, cita.getId());
        pg.executeUpdate();
        pg.close();
    }
    
    public void insertarHC(int hc, Cita cita) throws SQLException {
        
        String statement = "UPDATE cita SET hc_id = ? WHERE id_cita = ? ";
        PreparedStatement pg = cn.getConexion().prepareStatement(statement);
        pg.setInt(1, hc);
        pg.setInt(2, cita.getId());
        pg.executeUpdate();
        pg.close();
    }
}
