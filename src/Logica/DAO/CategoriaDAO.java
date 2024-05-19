/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica.DAO;

import BD.ConexionBD;
import Logica.Models.Categoria;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JDiego
 */
public class CategoriaDAO {
    
    ConexionBD cn;

    public CategoriaDAO() {
        this.cn = new ConexionBD();
    }

    public List<Categoria> obtenerCategorias() {

        try {
            List<Categoria> categorias = new ArrayList<>();

            String statement = "SELECT * FROM categoria";
            PreparedStatement pg = cn.getConexion().prepareStatement(statement);
            ResultSet res = pg.executeQuery();

            while (res.next()) {
                categorias.add(new Categoria(res.getInt("id_categoria"), res.getString("nombre_categoria")));
            }
            return categorias;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }

    }
}
