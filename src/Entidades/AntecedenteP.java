/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author flow3
 */
@Entity
@Table(name = "antecedente_p")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AntecedenteP.findAll", query = "SELECT a FROM AntecedenteP a")
    , @NamedQuery(name = "AntecedenteP.findByIdAntcp", query = "SELECT a FROM AntecedenteP a WHERE a.idAntcp = :idAntcp")
    , @NamedQuery(name = "AntecedenteP.findBySintomas", query = "SELECT a FROM AntecedenteP a WHERE a.sintomas = :sintomas")
    , @NamedQuery(name = "AntecedenteP.findByDiagnostico", query = "SELECT a FROM AntecedenteP a WHERE a.diagnostico = :diagnostico")
    , @NamedQuery(name = "AntecedenteP.findByIndicacion", query = "SELECT a FROM AntecedenteP a WHERE a.indicacion = :indicacion")})
public class AntecedenteP implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdAntcp")
    private Integer idAntcp;
    @Column(name = "Sintomas")
    private String sintomas;
    @Column(name = "Diagnostico")
    private String diagnostico;
    @Column(name = "Indicacion")
    private String indicacion;
    @JoinColumn(name = "idAntecedente_p", referencedColumnName = "idpaciente")
    @ManyToOne
    private Paciente idAntecedentep;

    public AntecedenteP() {
    }

    public AntecedenteP(Integer idAntcp) {
        this.idAntcp = idAntcp;
    }

    public Integer getIdAntcp() {
        return idAntcp;
    }

    public void setIdAntcp(Integer idAntcp) {
        Integer oldIdAntcp = this.idAntcp;
        this.idAntcp = idAntcp;
        changeSupport.firePropertyChange("idAntcp", oldIdAntcp, idAntcp);
    }

    public String getSintomas() {
        return sintomas;
    }

    public void setSintomas(String sintomas) {
        String oldSintomas = this.sintomas;
        this.sintomas = sintomas;
        changeSupport.firePropertyChange("sintomas", oldSintomas, sintomas);
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        String oldDiagnostico = this.diagnostico;
        this.diagnostico = diagnostico;
        changeSupport.firePropertyChange("diagnostico", oldDiagnostico, diagnostico);
    }

    public String getIndicacion() {
        return indicacion;
    }

    public void setIndicacion(String indicacion) {
        String oldIndicacion = this.indicacion;
        this.indicacion = indicacion;
        changeSupport.firePropertyChange("indicacion", oldIndicacion, indicacion);
    }

    public Paciente getIdAntecedentep() {
        return idAntecedentep;
    }

    public void setIdAntecedentep(Paciente idAntecedentep) {
        Paciente oldIdAntecedentep = this.idAntecedentep;
        this.idAntecedentep = idAntecedentep;
        changeSupport.firePropertyChange("idAntecedentep", oldIdAntecedentep, idAntecedentep);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAntcp != null ? idAntcp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AntecedenteP)) {
            return false;
        }
        AntecedenteP other = (AntecedenteP) object;
        if ((this.idAntcp == null && other.idAntcp != null) || (this.idAntcp != null && !this.idAntcp.equals(other.idAntcp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.AntecedenteP[ idAntcp=" + idAntcp + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
