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
public class Registropaciente {
    private int idAntecedente;
    private String Sintemas;
    private String Diagnostico;
    private String Indicacion;

    public Registropaciente(int idAntecedente, String Sintemas, String Diagnostico, String Indicacion) {
        this.idAntecedente = idAntecedente;
        this.Sintemas = Sintemas;
        this.Diagnostico = Diagnostico;
        this.Indicacion = Indicacion;
    }

    public int getIdAntecedente() {
        return idAntecedente;
    }

    public void setIdAntecedente(int idAntecedente) {
        this.idAntecedente = idAntecedente;
    }

    public String getSintemas() {
        return Sintemas;
    }

    public void setSintemas(String Sintemas) {
        this.Sintemas = Sintemas;
    }

    public String getDiagnostico() {
        return Diagnostico;
    }

    public void setDiagnostico(String Diagnostico) {
        this.Diagnostico = Diagnostico;
    }

    public String getIndicacion() {
        return Indicacion;
    }

    public void setIndicacion(String Indicacion) {
        this.Indicacion = Indicacion;
    }
           
}
