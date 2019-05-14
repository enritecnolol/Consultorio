/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author flow3
 */
public class Paciente {
    private String Antecedente_op;
    private String Enfermedades;
    private String Medicamentos;
    private String Alergias;

    public Paciente(String Antecedente_op, String Enfermedades, String Medicamentos, String Alergias) {
        this.Antecedente_op = Antecedente_op;
        this.Enfermedades = Enfermedades;
        this.Medicamentos = Medicamentos;
        this.Alergias = Alergias;
    }

    public Paciente() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getAntecedente_op() {
        return Antecedente_op;
    }

    public void setAntecedente_op(String Antecedente_op) {
        this.Antecedente_op = Antecedente_op;
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

    public String getAlergias() {
        return Alergias;
    }

    public void setAlergias(String Alergias) {
        this.Alergias = Alergias;
    }
    
}
