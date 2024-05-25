/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica.DAO;

import BD.ConexionBD;
import Logica.Models.Especialidad;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JDiego
 */
public class EspecialidadDAO {

    ConexionBD cn;

    public EspecialidadDAO() {
        this.cn = new ConexionBD();
    }

    public List<Especialidad> obtenerEspecialidades() {

        List<Especialidad> sedes = new ArrayList<>();

        try {
            String statement = "SELECT * FROM especialidad";
            PreparedStatement pg = cn.getConexion().prepareStatement(statement);
            ResultSet res = pg.executeQuery();

            while (res.next()) {
                sedes.add(new Especialidad(res.getInt("id_esp"), res.getString("nombre_esp")));
            }

            return sedes;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }

    }

    public Especialidad obtenerEspecialidad(int id){

        Especialidad esp = new Especialidad();

        try {
            PreparedStatement pg = cn.getConexion().prepareStatement("SELECT * FROM especialidad WHERE id_esp = ?");
            pg.setInt(1, id);
            ResultSet res = pg.executeQuery();

            while (res.next()) {
                esp = new Especialidad(res.getInt("id_esp"), res.getString("nombre_esp"));
            }
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }

        return esp;
    }

    public void insertarEspecialidad(Especialidad esp) throws SQLException {
        String statement = "INSERT INTO especialidad(nombre_esp) VALUES (?)";
        PreparedStatement pg = cn.getConexion().prepareStatement(statement);
        pg.setString(1, esp.getNombre());
        pg.executeUpdate();
        pg.close();
    }
}
