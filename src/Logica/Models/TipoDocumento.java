/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica.Models;

/**
 *
 * @author JDiego
 */
public class TipoDocumento {
    
    private int id;
    private String nombre;
    private String abreviacion;

    public TipoDocumento(int id, String nombre, String abreviacion) {
        this.id = id;
        this.nombre = nombre;
        this.abreviacion = abreviacion;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getAbreviacion() {
        return abreviacion;
    }
}
