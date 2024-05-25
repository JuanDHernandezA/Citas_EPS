/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica.DAO;

import BD.ConexionBD;
import Logica.Models.Agenda;
import Logica.Models.Especialidad;
import Logica.Models.Medico;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JDiego
 */
public class AgendaDAO {

    ConexionBD cn;

    public AgendaDAO() {
        this.cn = new ConexionBD();
    }

    public Agenda obtenerAgendaMed(Medico medico) throws SQLException {
        
        Agenda agenda = new Agenda();
        
        PreparedStatement pg = cn.getConexion().prepareStatement("SELECT * FROM agenda WHERE medico_id = ?");
        pg.setString(1, medico.getIdentificacion());
        ResultSet rg = pg.executeQuery();
        
        while (rg.next()) {
            agenda.setId(rg.getInt("id_agenda"));
            agenda.setFecha_inicio(rg.getDate("fecha_inicio_agenda").toLocalDate());
            agenda.setFecha_fin(rg.getDate("fecha_fin_agenda").toLocalDate());
            agenda.setMedico(medico);
        }
        return agenda;
    }

    public List obtenerAgendas() throws SQLException {
        
        List<Agenda> agendas = new ArrayList<>();
        
        PreparedStatement pg = cn.getConexion().prepareStatement("SELECT * FROM agenda");
        ResultSet rg = pg.executeQuery();
        
        while (rg.next()) {
            Agenda agenda = new Agenda();
            
            agenda.setId(rg.getInt("id_agenda"));
            agenda.setFecha_inicio(rg.getDate("fecha_inicio_agenda").toLocalDate());
            agenda.setFecha_fin(rg.getDate("fecha_fin_agenda").toLocalDate());
            agenda.setMedico(new Medico(rg.getString("medico_id")));
            
            agendas.add(agenda);
        }
        return agendas;
    }
    
    public int insertarAgenda(Agenda agenda) throws SQLException {

        int id = 0;

        String statement = "INSERT INTO agenda(fecha_inicio_agenda,fecha_fin_agenda,medico_id) VALUES (?,?,?) RETURNING id_agenda";
        PreparedStatement pg = cn.getConexion().prepareStatement(statement);
        pg.setDate(1, Date.valueOf(agenda.getFecha_inicio()));
        pg.setDate(2, Date.valueOf(agenda.getFecha_fin()));
        pg.setString(3, agenda.getMedico().getIdentificacion());
        ResultSet resultSet = pg.executeQuery();
        if (resultSet.next()) {
            id = resultSet.getInt("id_agenda");
            System.out.println("ID generado: " + id);
        }
        pg.close();
        return id;
    }
}
