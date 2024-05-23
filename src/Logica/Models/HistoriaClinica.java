/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica.Models;

/**
 *
 * @author JDiego
 */
public class HistoriaClinica {
    
    private int id;
    private String diagnostico;
    private String tratamiento;

    public HistoriaClinica() {
    }

    public HistoriaClinica(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public String getTratamiento() {
        return tratamiento;
    }
    
    
}
