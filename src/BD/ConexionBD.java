/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BD;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author JDiego
 */
public class ConexionBD {
    
    static String bd = "EPS";
    static String login = "postgres";
    static String password = "admin";
    static String url = "jdbc:postgresql://localhost:5432/"+bd;
    static String mensaje = "";
    
    Connection conexion = null;
    
    public ConexionBD(){
        try{
            Class.forName("org.postgresql.Driver");
            conexion = DriverManager.getConnection(url,login,password);
            if(conexion!=null){
                System.out.println("Connection to "+bd+ " established...");
            }
        }
        catch(HeadlessException | ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null,"Failed at: Connect to "+bd+" ...","Warning",0);
            System.out.println(e);
        }
    }
    
    public static String getMensaje() {
        return mensaje;
    }
    
    public static void setMensaje(String mensaje) {
        ConexionBD.mensaje = mensaje;
    }
    
    public Connection getConexion(){
        return conexion;
    }
    
    public void desconectar(){
        conexion = null;
    }
}
