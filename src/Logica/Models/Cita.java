/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica.Models;

import java.time.LocalTime;
import java.sql.Date;

/**
 *
 * @author JDiego
 */
public class Cita {
    
    private int id;
    private Date fecha;
    private LocalTime hora_inicio;
    private LocalTime hora_fin;
    private Estado estado;
    private Paciente paciente;
    private Agenda agenda;
    private HistoriaClinica hc;

    public Cita() {
    }

    public Cita(Date fecha, LocalTime hora_inicio, LocalTime hora_fin, Estado estado, Paciente paciente, Agenda agenda, HistoriaClinica hc) {
        this.fecha = fecha;
        this.hora_inicio = hora_inicio;
        this.hora_fin = hora_fin;
        this.estado = estado;
        this.paciente = paciente;
        this.agenda = agenda;
        this.hc = hc;
    }

    public int getId() {
        return id;
    }

    public Date getFecha() {
        return fecha;
    }

    public LocalTime getHora_inicio() {
        return hora_inicio;
    }

    public LocalTime getHora_fin() {
        return hora_fin;
    }

    public Estado getEstado() {
        return estado;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public Agenda getAgenda() {
        return agenda;
    }

    public HistoriaClinica getHc() {
        return hc;
    }
    
    
}
