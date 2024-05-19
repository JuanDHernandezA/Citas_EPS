/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica.DAO;

import BD.ConexionBD;
import Logica.Models.TipoDocumento;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JDiego
 */
public class TipoDocumentoDAO {
    
    ConexionBD cn;

    public TipoDocumentoDAO() {
        this.cn = new ConexionBD();
    }

    public List<TipoDocumento> obtenerTipos() {

        List<TipoDocumento> tipos = new ArrayList<>();

        try {
            String statement = "SELECT * FROM tipo_documento";
            PreparedStatement pg = cn.getConexion().prepareStatement(statement);
            ResultSet res = pg.executeQuery();

            while (res.next()) {
                if (!res.getString("abreviacion_tipo").equals("TI")){
                    tipos.add(new TipoDocumento(res.getInt("id_tipo"), res.getString("nombre_tipo"), res.getString("abreviacion_tipo")));
                }
                
            }

            return tipos;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }

    }
}
