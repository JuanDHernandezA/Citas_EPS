/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica.DAO;

import BD.ConexionBD;
import Logica.Models.Genero;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author JDiego
 */
public class GeneroDAO {
    
    ConexionBD cn;

    public GeneroDAO() {
        this.cn = new ConexionBD();
    }

    public List<Genero> obtenerGeneros() {

        List<Genero> generos = new ArrayList<>();

        try {
            String statement = "SELECT * FROM genero";
            PreparedStatement pg = cn.getConexion().prepareStatement(statement);
            ResultSet res = pg.executeQuery();

            while (res.next()) {
                generos.add(new Genero(res.getInt("id_genero"), res.getString("nombre_genero")));
            }

            return generos;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }

    }
}
