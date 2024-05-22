/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica.Models;

import java.time.LocalTime;

/**
 *
 * @author JDiego
 */
public class Jornada {
    
    private int id;
    private String nombre;
    private LocalTime hora_inicio;
    private LocalTime hora_fin;

    public Jornada(int id, String nombre, LocalTime hora_inicio, LocalTime hora_fin) {
        this.id = id;
        this.nombre = nombre;
        this.hora_inicio = hora_inicio;
        this.hora_fin = hora_fin;
    }

    public Jornada(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public LocalTime getHora_inicio() {
        return hora_inicio;
    }

    public LocalTime getHora_fin() {
        return hora_fin;
    }
    
    
}
