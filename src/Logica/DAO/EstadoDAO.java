/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica.DAO;

import BD.ConexionBD;
import Logica.Models.Estado;
import Logica.Models.Genero;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JDiego
 */
public class EstadoDAO {
    
    ConexionBD cn;

    public EstadoDAO() {
        this.cn = new ConexionBD();
    }

    public List<Estado> obtenerEstados() {

        List<Estado> estados = new ArrayList<>();

        try {
            String statement = "SELECT * FROM estado";
            PreparedStatement pg = cn.getConexion().prepareStatement(statement);
            ResultSet res = pg.executeQuery();

            while (res.next()) {
                estados.add(new Estado(res.getInt("id_estado"), res.getString("tipo_estado")));
            }

            return estados;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }

    }
}
