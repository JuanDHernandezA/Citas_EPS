/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica.DAO;

import BD.ConexionBD;
import Logica.Models.HistoriaClinica;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;

/**
 *
 * @author JDiego
 */
public class HCDAO {
    
    ConexionBD cn;

    public HCDAO() {
        this.cn = new ConexionBD();
    }
    
    public int insertarCita(HistoriaClinica hc) throws SQLException {

        String statement = "INSERT INTO historia_clinica(diagnostico,tratamiento) VALUES (?,?) RETURNING id_hc";
        PreparedStatement pg = cn.getConexion().prepareStatement(statement);
        pg.setString(1, hc.getDiagnostico());
        pg.setString(2, hc.getTratamiento());
        ResultSet resultSet = pg.executeQuery();
        int idGenerado = 0;
        if (resultSet.next()) {
            idGenerado = resultSet.getInt("id_hc");
            System.out.println("ID generado: " + idGenerado);
        }
        pg.close();
        return idGenerado;
    }
    
    public HistoriaClinica obtenerHC(int id){

        HistoriaClinica hc = new HistoriaClinica();

        try {
            PreparedStatement pg = cn.getConexion().prepareStatement("SELECT * FROM historia_clinica WHERE id_hc = ?");
            pg.setInt(1, id);
            ResultSet res = pg.executeQuery();

            while (res.next()) {
                hc = new HistoriaClinica(res.getInt("id_hc"), res.getString("diagnostico"),res.getString("tratamiento"));
            }
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }

        return hc;
    }
}
