/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica.Models;

/**
 *
 * @author JDiego
 */
public class Estado {
    
    private int id;
    private String estado;

    public Estado() {
    }

    public Estado(int id) {
        this.id = id;
    }

    public Estado(int id, String estado) {
        this.id = id;
        this.estado = estado;
    }
    public int getId() {
        return id;
    }

    public String getEstado() {
        return estado;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}
