/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica.DAO;

import BD.ConexionBD;
import Logica.Models.Jornada;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author JDiego
 */
public class JornadaDAO {
    
    ConexionBD cn;

    public JornadaDAO() {
        this.cn = new ConexionBD();
    }

    public List<Jornada> obtenerJornadas() {

        try {
            List<Jornada> jornadas = new ArrayList<>();

            String statement = "SELECT * FROM jornada";
            PreparedStatement pg = cn.getConexion().prepareStatement(statement);
            ResultSet res = pg.executeQuery();

            while (res.next()) {
                jornadas.add(new Jornada(res.getInt("id_jornada"),res.getString("nombre_jornada"), res.getTime("hora_inicio").toLocalTime(), res.getTime("hora_fin").toLocalTime()));
            }
            return jornadas;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }

    }
    
    public Jornada obtenerJornada(Jornada j) {

        Jornada jornada = null;
        
        try {
            String statement = "SELECT * FROM jornada WHERE id_jornada=?";
            PreparedStatement pg = cn.getConexion().prepareStatement(statement);
            pg.setInt(1, j.getId());
            ResultSet res = pg.executeQuery();

            while (res.next()) {
                jornada = new Jornada(res.getInt("id_jornada"),res.getString("nombre_jornada"), res.getTime("hora_inicio").toLocalTime(), res.getTime("hora_fin").toLocalTime());
            }
            return jornada;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }

    }
}
