/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.Date;

/**
 *
 * @author flow3
 */
public class Persona {
    private String Nombre;
    private String Apellido;
    private String Telefono;
    private int Edad;
    private String direccion;
    private Date fechanac;
    private String Antecedent_op;
    private String Enfermedades;
    private String Medicamentos;
    private String Alergia;
    private String Estadoc;

    public Persona(String Nombre, String Apellido, String Telefono, int Edad, String direccion, Date fechanac, String Antecedent_op, String Enfermedades, String Medicamentos, String Alergia, String Estadoc) {
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Telefono = Telefono;
        this.Edad = Edad;
        this.direccion = direccion;
        this.fechanac = fechanac;
        this.Antecedent_op = Antecedent_op;
        this.Enfermedades = Enfermedades;
        this.Medicamentos = Medicamentos;
        this.Alergia = Alergia;
        this.Estadoc = Estadoc;
    }

    public Persona() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int Edad) {
        this.Edad = Edad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Date getFechanac() {
        return fechanac;
    }

    public void setFechanac(Date fechanac) {
        this.fechanac = fechanac;
    }

    public String getAntecedent_op() {
        return Antecedent_op;
    }

    public void setAntecedent_op(String Antecedent_op) {
        this.Antecedent_op = Antecedent_op;
    }

    public String getEnfermedades() {
        return Enfermedades;
    }

    public void setEnfermedades(String Enfermedades) {
        this.Enfermedades = Enfermedades;
    }

    public String getMedicamentos() {
        return Medicamentos;
    }

    public void setMedicamentos(String Medicamentos) {
        this.Medicamentos = Medicamentos;
    }

    public String getAlergia() {
        return Alergia;
    }

    public void setAlergia(String Alergia) {
        this.Alergia = Alergia;
    }

    public String getEstadoc() {
        return Estadoc;
    }

    public void setEstadoc(String Estadoc) {
        this.Estadoc = Estadoc;
    }
    
}
