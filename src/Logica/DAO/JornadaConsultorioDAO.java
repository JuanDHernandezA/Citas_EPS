/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica.DAO;

import BD.ConexionBD;
import Logica.Models.Consultorio;
import Logica.Models.Jornada;
import Logica.Models.JornadaConsultorio;
import Logica.Models.Medico;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author JDiego
 */
public class JornadaConsultorioDAO {
    
    ConexionBD cn;

    public JornadaConsultorioDAO() {
        this.cn = new ConexionBD();
    }

    public List<JornadaConsultorio> obtenerJC() {

        List<JornadaConsultorio> jornada_consultorio = new ArrayList<>();

        try {
            String statement = "SELECT * FROM jornada_consultorio";
            PreparedStatement pg = cn.getConexion().prepareStatement(statement);
            ResultSet res = pg.executeQuery();

            while (res.next()) {
                
                JornadaConsultorio jc = new JornadaConsultorio();
                
                jc.setJornada(new Jornada(res.getInt("jornada_id")));
                jc.setConsultorio(new Consultorio(res.getInt("consultorio_id")));
                
                jornada_consultorio.add(jc);
            }

            return jornada_consultorio;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }

    }
    
    public List<JornadaConsultorio> obtenerJCEsp(int esp) {

        List<JornadaConsultorio> jornada_consultorio = new ArrayList<>();

        try {
            String statement = "SELECT * FROM jornada_consultorio INNER JOIN consultorio ON jornada_consultorio.consultorio_id = consultorio.id_con WHERE consultorio.especialidad_id = ?";
            PreparedStatement pg = cn.getConexion().prepareStatement(statement);
            pg.setInt(1, esp);
            ResultSet res = pg.executeQuery();

            while (res.next()) {
                
                JornadaConsultorio jc = new JornadaConsultorio();
                
                jc.setJornada(new Jornada(res.getInt("jornada_id")));
                jc.setConsultorio(new Consultorio(res.getInt("consultorio_id")));
                jc.setMedico(new Medico(res.getString("medico_id")));
                
                jornada_consultorio.add(jc);
            }

            return jornada_consultorio;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
    
    public JornadaConsultorio obtenerJCMed(Medico medico) {

        JornadaConsultorio jornada_consultorio = new JornadaConsultorio();

        try {
            String statement = "SELECT * FROM jornada_consultorio WHERE medico_id = ?";
            PreparedStatement pg = cn.getConexion().prepareStatement(statement);
            pg.setString(1, medico.getIdentificacion());
            ResultSet res = pg.executeQuery();

            while (res.next()) {
                jornada_consultorio.setJornada(new Jornada(res.getInt("jornada_id")));
                jornada_consultorio.setConsultorio(new Consultorio(res.getInt("consultorio_id")));
                jornada_consultorio.setMedico(new Medico(res.getString("medico_id")));
            }

            
            return jornada_consultorio;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}
