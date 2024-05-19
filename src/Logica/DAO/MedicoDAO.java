/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica.DAO;

import BD.ConexionBD;
import Logica.Models.Especialidad;
import Logica.Models.Genero;
import Logica.Models.Medico;
import Logica.Models.TipoDocumento;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author JDiego
 */
public class MedicoDAO {

    ConexionBD cn;

    public MedicoDAO() {
        this.cn = new ConexionBD();
    }

    public void insertarMedico(Medico medico) throws SQLException {
        String statement = "INSERT INTO medico VALUES (?,?,?,?,?,?,?,?,?,?)";
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
        pg.executeUpdate();
        pg.close();
    }

    public Medico obtenerMedico(String id) throws SQLException {

        Medico medico = new Medico();

        PreparedStatement pg = cn.getConexion().prepareStatement("SELECT *"
                + "FROM medico WHERE id_med = ?");

        pg.setString(1, id);
        ResultSet res = pg.executeQuery();

        while (res.next()) {
            medico.setTd(new TipoDocumento(res.getInt("tipo_id"),null,null));
            medico.setIdentificacion(res.getString("id_med"));
            medico.setNombre(res.getString("nombre_med"));
            medico.setApellido(res.getString("apellido_med"));
            medico.setCorreo(res.getString("correo_med"));
            medico.setTelefono(res.getString("telefono_med"));
            medico.setFecha_nacimiento(res.getDate("fecha_nacimiento_med"));
            medico.setRegistro_profesional(res.getString("registro_med"));
            medico.setGenero(new Genero(res.getInt("genero_id"),null));
            medico.setEspecialidad(new Especialidad(res.getInt("especialidad_id"),null));
        }
        return medico;
    }
}
