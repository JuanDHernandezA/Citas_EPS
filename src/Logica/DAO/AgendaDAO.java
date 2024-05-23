/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica.DAO;

import BD.ConexionBD;
import Logica.Models.Agenda;
import Logica.Models.Especialidad;
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

    public ResultSet obtenerAgenda(int id) throws SQLException {
        PreparedStatement pg = cn.getConexion().prepareStatement("SELECT * FROM agenda WHERE id_agenda = ?");
        pg.setInt(1, id);
        ResultSet rg = pg.executeQuery();
        return rg;
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
