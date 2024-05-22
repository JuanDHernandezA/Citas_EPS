/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica.Models;

/**
 *
 * @author JDiego
 */
public class JornadaConsultorio {
    
    private Jornada jornada;
    private Consultorio consultorio;
    private Medico medico;

    public JornadaConsultorio() {
    }

    public JornadaConsultorio(Jornada jornada, Consultorio consultorio, Medico medico) {
        this.jornada = jornada;
        this.consultorio = consultorio;
        this.medico = medico;
    }

    public Jornada getJornada() {
        return jornada;
    }

    public void setJornada(Jornada jornada) {
        this.jornada = jornada;
    }

    public Consultorio getConsultorio() {
        return consultorio;
    }

    public void setConsultorio(Consultorio consultorio) {
        this.consultorio = consultorio;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }
    
    
}
