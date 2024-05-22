/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica.Models;

/**
 *
 * @author JDiego
 */
public class Consultorio {
    
    private int id;
    private int numero;
    private Especialidad especialidad;
    private Sede sede;

    public Consultorio() {
    }

    public Consultorio(int id, int numero, Especialidad especialidad, Sede sede) {
        this.id = id;
        this.numero = numero;
        this.especialidad = especialidad;
        this.sede = sede;
    }
    
    public Consultorio(int id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    public Sede getSede() {
        return sede;
    }

    public void setSede(Sede sede) {
        this.sede = sede;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
}
