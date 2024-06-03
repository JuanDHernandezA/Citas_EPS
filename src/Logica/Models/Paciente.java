/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica.Models;

/**
 *
 * @author JDiego
 */
public class Paciente extends Usuario{
    
    private Categoria categoria;

    /*public Paciente(TipoDocumento td, String nombre, String apellido, String identificacion, String correo, String telefono, Date fecha_nacimiento, Genero genero) {
        super(td, nombre, apellido, identificacion, correo, telefono, fecha_nacimiento, genero);
    }*/

    public Paciente(String id) {
        super(id);
    }

    public Paciente() {
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
