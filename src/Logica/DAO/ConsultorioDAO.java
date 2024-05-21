/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica.DAO;

import BD.ConexionBD;
import Logica.Models.Consultorio;
import Logica.Models.Jornada;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JDiego
 */
public class ConsultorioDAO {

    ConexionBD cn;

    public ConsultorioDAO() {
        this.cn = new ConexionBD();
    }

    //CONSULTORIOS
    public int insertarConsultorio(Consultorio con) throws SQLException {
        String statement = "INSERT INTO consultorio(numero_con,especialidad_id,sede_id) VALUES (?,?,?) RETURNING id_con";
        PreparedStatement pg = cn.getConexion().prepareStatement(statement);
        pg.setInt(1, con.getNumero());
        pg.setInt(2, con.getEspecialidad().getId());
        pg.setInt(3, con.getSede().getId());
        //pg.executeUpdate();
        ResultSet resultSet = pg.executeQuery();
        int idGenerado = 0;
        if (resultSet.next()) {
            idGenerado = resultSet.getInt("id_con");
            System.out.println("ID generado: " + idGenerado);
        }
        pg.close();
        return idGenerado;
    }

    public void jornadaConsultorio(int con) throws SQLException {

        List<Jornada> jornadas;
        JornadaDAO jornadaDAO = new JornadaDAO();

        jornadas = jornadaDAO.obtenerJornadas();

        for (Jornada jornada : jornadas) {
            String statement = "INSERT INTO jornada_consultorio(jornada_id,consultorio_id) VALUES (?,?)";
            PreparedStatement pg = cn.getConexion().prepareStatement(statement);
            pg.setInt(1, jornada.getId());
            pg.setInt(2, con);
            pg.executeUpdate();
            pg.close();
        }

    }
}
