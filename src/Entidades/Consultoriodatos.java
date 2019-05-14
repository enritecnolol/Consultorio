/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author flow3
 */
@Entity
@Table(name = "consultoriodatos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Consultoriodatos.findAll", query = "SELECT c FROM Consultoriodatos c")
    , @NamedQuery(name = "Consultoriodatos.findByIdConsultoriodatos", query = "SELECT c FROM Consultoriodatos c WHERE c.idConsultoriodatos = :idConsultoriodatos")
    , @NamedQuery(name = "Consultoriodatos.findByNombreconsultorio", query = "SELECT c FROM Consultoriodatos c WHERE c.nombreconsultorio = :nombreconsultorio")
    , @NamedQuery(name = "Consultoriodatos.findByTelefono", query = "SELECT c FROM Consultoriodatos c WHERE c.telefono = :telefono")
    , @NamedQuery(name = "Consultoriodatos.findByDireccion", query = "SELECT c FROM Consultoriodatos c WHERE c.direccion = :direccion")
    , @NamedQuery(name = "Consultoriodatos.findByCorreo", query = "SELECT c FROM Consultoriodatos c WHERE c.correo = :correo")
    , @NamedQuery(name = "Consultoriodatos.findByMensageconsultorio", query = "SELECT c FROM Consultoriodatos c WHERE c.mensageconsultorio = :mensageconsultorio")})
public class Consultoriodatos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idConsultoriodatos")
    private Integer idConsultoriodatos;
    @Basic(optional = false)
    @Column(name = "Nombreconsultorio")
    private String nombreconsultorio;
    @Basic(optional = false)
    @Column(name = "Telefono")
    private String telefono;
    @Basic(optional = false)
    @Column(name = "Direccion")
    private String direccion;
    @Basic(optional = false)
    @Column(name = "Correo")
    private String correo;
    @Basic(optional = false)
    @Column(name = "Mensageconsultorio")
    private String mensageconsultorio;

    public Consultoriodatos() {
    }

    public Consultoriodatos(Integer idConsultoriodatos) {
        this.idConsultoriodatos = idConsultoriodatos;
    }

    public Consultoriodatos(Integer idConsultoriodatos, String nombreconsultorio, String telefono, String direccion, String correo, String mensageconsultorio) {
        this.idConsultoriodatos = idConsultoriodatos;
        this.nombreconsultorio = nombreconsultorio;
        this.telefono = telefono;
        this.direccion = direccion;
        this.correo = correo;
        this.mensageconsultorio = mensageconsultorio;
    }

    public Integer getIdConsultoriodatos() {
        return idConsultoriodatos;
    }

    public void setIdConsultoriodatos(Integer idConsultoriodatos) {
        this.idConsultoriodatos = idConsultoriodatos;
    }

    public String getNombreconsultorio() {
        return nombreconsultorio;
    }

    public void setNombreconsultorio(String nombreconsultorio) {
        this.nombreconsultorio = nombreconsultorio;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getMensageconsultorio() {
        return mensageconsultorio;
    }

    public void setMensageconsultorio(String mensageconsultorio) {
        this.mensageconsultorio = mensageconsultorio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idConsultoriodatos != null ? idConsultoriodatos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Consultoriodatos)) {
            return false;
        }
        Consultoriodatos other = (Consultoriodatos) object;
        if ((this.idConsultoriodatos == null && other.idConsultoriodatos != null) || (this.idConsultoriodatos != null && !this.idConsultoriodatos.equals(other.idConsultoriodatos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Consultoriodatos[ idConsultoriodatos=" + idConsultoriodatos + " ]";
    }
    
}
