/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica.Models;

/**
 *
 * @author JDiego
 */
public class Medico extends Usuario {
    
    //falta agenda
    private String registro_profesional;
    private Especialidad especialidad;

    /*public Medico(TipoDocumento td, String nombre, String apellido, String identificacion, String correo, String telefono, Date fecha_nacimiento, Genero genero, String registro_profesional, Especialidad especialidad, Jornada jornada) {
        super(td, nombre, apellido, identificacion, correo, telefono, fecha_nacimiento, genero);
        this.registro_profesional = registro_profesional;
        this.especialidad = especialidad;
        this.jornada = jornada;
    }*/
    
    public void abrir_agenda(){
        
    }
    
    public void atender_cita(){
        
    }

    public String getRegistro_profesional() {
        return registro_profesional;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setRegistro_profesional(String registro_profesional) {
        this.registro_profesional = registro_profesional;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }
}
