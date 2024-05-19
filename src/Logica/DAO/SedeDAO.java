/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica.DAO;

import BD.ConexionBD;
import Logica.Models.Sede;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JDiego
 */
public class SedeDAO {

    ConexionBD cn;

    public SedeDAO() {
        this.cn = new ConexionBD();
    }

    public List<Sede> obtenerSedes() {

        try {
            List<Sede> sedes = new ArrayList<>();

            String statement = "SELECT * FROM sede";
            PreparedStatement pg = cn.getConexion().prepareStatement(statement);
            ResultSet res = pg.executeQuery();

            while (res.next()) {
                sedes.add(new Sede(res.getInt("id_sede"), res.getString("nombre_sede"), res.getString("direccion")));
            }
            return sedes;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }

    }

    public void insertarSede(Sede sede) throws SQLException {
        String statement = "INSERT INTO sede(nombre_sede,direccion) VALUES (?,?)";
        PreparedStatement pg = cn.getConexion().prepareStatement(statement);
        pg.setString(1, sede.getNombre());
        pg.setString(2, sede.getDireccion());
        pg.executeUpdate();
        pg.close();
    }
}
