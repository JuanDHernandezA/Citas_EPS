/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica.DAO;

import BD.ConexionBD;
import Logica.Models.Especialidad;
import Logica.Models.Genero;
import Logica.Models.JornadaConsultorio;
import Logica.Models.Medico;
import Logica.Models.TipoDocumento;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JDiego
 */
public class MedicoDAO {

    ConexionBD cn;

    public MedicoDAO() {
        this.cn = new ConexionBD();
    }

    public Medico obtenerMedico(String id) throws SQLException {

        Medico medico = new Medico();

        PreparedStatement pg = cn.getConexion().prepareStatement("SELECT * FROM medico WHERE id_med = ?");

        pg.setString(1, id);
        ResultSet res = pg.executeQuery();

        while (res.next()) {
            medico.setTd(new TipoDocumento(res.getInt("tipo_id"), null, null));
            medico.setIdentificacion(res.getString("id_med"));
            medico.setNombre(res.getString("nombre_med"));
            medico.setApellido(res.getString("apellido_med"));
            medico.setCorreo(res.getString("correo_med"));
            medico.setTelefono(res.getString("telefono_med"));
            medico.setFecha_nacimiento(res.getDate("fecha_nacimiento_med"));
            medico.setRegistro_profesional(res.getString("registro_med"));
            medico.setGenero(new Genero(res.getInt("genero_id"), null));
            medico.setEspecialidad(new Especialidad(res.getInt("especialidad_id"), null));
        }
        return medico;
    }
    
    public List obtenerMedicos() throws SQLException {

        List<Medico> medicos = new ArrayList();

        PreparedStatement pg = cn.getConexion().prepareStatement("SELECT * FROM medico");
        ResultSet res = pg.executeQuery();

        while (res.next()) {
            
            Medico medico = new Medico();
            
            medico.setTd(new TipoDocumento(res.getInt("tipo_id"), null, null));
            medico.setIdentificacion(res.getString("id_med"));
            medico.setNombre(res.getString("nombre_med"));
            medico.setApellido(res.getString("apellido_med"));
            medico.setCorreo(res.getString("correo_med"));
            medico.setTelefono(res.getString("telefono_med"));
            medico.setFecha_nacimiento(res.getDate("fecha_nacimiento_med"));
            medico.setRegistro_profesional(res.getString("registro_med"));
            medico.setGenero(new Genero(res.getInt("genero_id"), null));
            medico.setEspecialidad(new Especialidad(res.getInt("especialidad_id"), null));
            
            medicos.add(medico);
        }
        return medicos;
    }

    public int[] insertarMedico(Medico medico) throws SQLException {
        String statement = "INSERT INTO medico VALUES (?,?,?,?,?,?,?,?,?,?)  RETURNING id_med,especialidad_id";
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

        ResultSet resultSet = pg.executeQuery();
        int[] ids = new int[2];
        if (resultSet.next()) {
            ids[0] = resultSet.getInt("id_med");
            ids[1] = resultSet.getInt("especialidad_id");
        }
        pg.close();
        return ids;
    }

    public boolean asociarJornada(int[] medico) throws SQLException {

        JornadaConsultorioDAO jcDAO = new JornadaConsultorioDAO();
        List<JornadaConsultorio> jornada_consultorio = jcDAO.obtenerJCEsp(medico[1]);
        boolean find = false;

        for (JornadaConsultorio jc : jornada_consultorio) {
            if (jc.getMedico().getIdentificacion()== null) {
                String statement = "UPDATE jornada_consultorio SET medico_id = ? WHERE jornada_id = ? AND consultorio_id = ?";
                PreparedStatement pg = cn.getConexion().prepareStatement(statement);
                pg.setInt(1, medico[0]);
                pg.setInt(2, jc.getJornada().getId());
                pg.setInt(3, jc.getConsultorio().getId());
                pg.executeUpdate();
                pg.close();
                find = true;
                break;
            }
        }
        
        return find;
    }
    
    public void borrarMedico(int id) throws SQLException {

        PreparedStatement pg = cn.getConexion().prepareStatement("DELETE FROM medico WHERE id_med = ?");
        pg.setString(1, Integer.toString(id));
        pg.executeUpdate();
        pg.close();
    }
}
