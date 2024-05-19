/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica.DAO;

import BD.ConexionBD;
import Logica.Models.Categoria;
import Logica.Models.Genero;
import Logica.Models.Paciente;
import Logica.Models.TipoDocumento;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 *
 * @author JDiego
 */
public class PacienteDAO {
    ConexionBD cn;

    public PacienteDAO() {
        this.cn = new ConexionBD();
    }
    
    public void insertarPaciente(Paciente paciente) throws SQLException {
        String statement = "INSERT INTO paciente VALUES (?,?,?,?,?,?,?,?,?)";
        PreparedStatement pg = cn.getConexion().prepareStatement(statement);
        pg.setInt(1, paciente.getTd().getId());
        pg.setString(2, paciente.getIdentificacion());
        pg.setString(3, paciente.getNombre());
        pg.setString(4, paciente.getApellido());
        pg.setString(5, paciente.getCorreo());
        pg.setString(6, paciente.getTelefono());
        pg.setDate(7, paciente.getFecha_nacimiento());
        pg.setInt(8, paciente.getGenero().getId());
        pg.setInt(9, paciente.getCategoria().getId());
        pg.executeUpdate();
        pg.close();
    }
    
    public Paciente obtenerPaciente(String id) throws SQLException {

        Paciente paciente = new Paciente();

        PreparedStatement pg = cn.getConexion().prepareStatement("SELECT *"
                + "FROM paciente WHERE id_pac = ?");

        pg.setString(1, id);
        ResultSet res = pg.executeQuery();

        while (res.next()) {
            paciente.setTd(new TipoDocumento(res.getInt("tipo_id"),null,null));
            paciente.setIdentificacion(res.getString("id_pac"));
            paciente.setNombre(res.getString("nombre_pac"));
            paciente.setApellido(res.getString("apellido_pac"));
            paciente.setCorreo(res.getString("correo_pac"));
            paciente.setTelefono(res.getString("telefono_pac"));
            paciente.setFecha_nacimiento(res.getDate("fecha_nacimiento_pac"));
            paciente.setGenero(new Genero(res.getInt("genero_id"),null));
            paciente.setCategoria(new Categoria(res.getInt("categoria_pac"),null));
        }
        return paciente;
    }
}
