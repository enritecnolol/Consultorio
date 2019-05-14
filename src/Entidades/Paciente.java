/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.logging.SimpleFormatter;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author flow3
 */
@Entity
@Table(name = "paciente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Paciente.findAll", query = "SELECT p FROM Paciente p")
    , @NamedQuery(name = "Paciente.findByIdpaciente", query = "SELECT p FROM Paciente p WHERE p.idpaciente = :idpaciente")
    , @NamedQuery(name = "Paciente.findByNombrep", query = "SELECT p FROM Paciente p WHERE p.nombrep = :nombrep")
    , @NamedQuery(name = "Paciente.findByApellido", query = "SELECT p FROM Paciente p WHERE p.apellido = :apellido")
    , @NamedQuery(name = "Paciente.findByTelefono", query = "SELECT p FROM Paciente p WHERE p.telefono = :telefono")
    , @NamedQuery(name = "Paciente.findByEdad", query = "SELECT p FROM Paciente p WHERE p.edad = :edad")
    , @NamedQuery(name = "Paciente.findByFechanac", query = "SELECT p FROM Paciente p WHERE p.fechanac = :fechanac")
    , @NamedQuery(name = "Paciente.findByEstadoCivil", query = "SELECT p FROM Paciente p WHERE p.estadoCivil = :estadoCivil")
    , @NamedQuery(name = "Paciente.findByAntecedenteop", query = "SELECT p FROM Paciente p WHERE p.antecedenteop = :antecedenteop")
    , @NamedQuery(name = "Paciente.findByEnfermedad", query = "SELECT p FROM Paciente p WHERE p.enfermedad = :enfermedad")
    , @NamedQuery(name = "Paciente.findByMedicamentos", query = "SELECT p FROM Paciente p WHERE p.medicamentos = :medicamentos")
    , @NamedQuery(name = "Paciente.findByAlergias", query = "SELECT p FROM Paciente p WHERE p.alergias = :alergias")
    , @NamedQuery(name = "Paciente.findByDireccion", query = "SELECT p FROM Paciente p WHERE p.direccion = :direccion")})
public class Paciente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpaciente")
    private Integer idpaciente;
    @Basic(optional = false)
    @Column(name = "Nombrep")
    private String nombrep;
    @Basic(optional = false)
    @Column(name = "Apellido")
    private String apellido;
    @Basic(optional = false)
    @Column(name = "Telefono")
    private String telefono;
    @Basic(optional = false)
    @Column(name = "edad")
    private int edad;
    @Basic(optional = false)
    @Column(name = "Fechanac")
    @Temporal(TemporalType.DATE)
    private Date fechanac;
    @Basic(optional = false)
    @Column(name = "EstadoCivil")
    private String estadoCivil;
    @Basic(optional = false)
    @Column(name = "Antecedente_op")
    private String antecedenteop;
    @Basic(optional = false)
    @Column(name = "Enfermedad")
    private String enfermedad;
    @Basic(optional = false)
    @Column(name = "Medicamentos")
    private String medicamentos;
    @Basic(optional = false)
    @Column(name = "Alergias")
    private String alergias;
    @Basic(optional = false)
    @Column(name = "Direccion")
    private String direccion;
    @OneToMany(mappedBy = "idAntecedentep")
    private Collection<AntecedenteP> antecedentePCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idpacientep")
    private Collection<Citas> citasCollection;

    public Paciente() {
    }

    public Paciente(Integer idpaciente) {
        this.idpaciente = idpaciente;
    }

    public Paciente(Integer idpaciente, String nombrep, String apellido, String telefono, int edad, Date fechanac, String estadoCivil, String antecedenteop, String enfermedad, String medicamentos, String alergias, String direccion) {
        this.idpaciente = idpaciente;
        this.nombrep = nombrep;
        this.apellido = apellido;
        this.telefono = telefono;
        this.edad = edad;
        this.fechanac = fechanac;
        this.estadoCivil = estadoCivil;
        this.antecedenteop = antecedenteop;
        this.enfermedad = enfermedad;
        this.medicamentos = medicamentos;
        this.alergias = alergias;
        this.direccion = direccion;
    }

    public Integer getIdpaciente() {
        return idpaciente;
    }

    public void setIdpaciente(Integer idpaciente) {
        this.idpaciente = idpaciente;
    }

    public String getNombrep() {
        return nombrep;
    }

    public void setNombrep(String nombrep) {
        this.nombrep = nombrep;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Date getFechanac() {
        return fechanac;
    }

    public void setFechanac(Date fechanac) {
        this.fechanac = fechanac;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getAntecedenteop() {
        return antecedenteop;
    }

    public void setAntecedenteop(String antecedenteop) {
        this.antecedenteop = antecedenteop;
    }

    public String getEnfermedad() {
        return enfermedad;
    }

    public void setEnfermedad(String enfermedad) {
        this.enfermedad = enfermedad;
    }

    public String getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(String medicamentos) {
        this.medicamentos = medicamentos;
    }

    public String getAlergias() {
        return alergias;
    }

    public void setAlergias(String alergias) {
        this.alergias = alergias;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @XmlTransient
    public Collection<AntecedenteP> getAntecedentePCollection() {
        return antecedentePCollection;
    }

    public void setAntecedentePCollection(Collection<AntecedenteP> antecedentePCollection) {
        this.antecedentePCollection = antecedentePCollection;
    }

    @XmlTransient
    public Collection<Citas> getCitasCollection() {
        return citasCollection;
    }

    public void setCitasCollection(Collection<Citas> citasCollection) {
        this.citasCollection = citasCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpaciente != null ? idpaciente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Paciente)) {
            return false;
        }
        Paciente other = (Paciente) object;
        if ((this.idpaciente == null && other.idpaciente != null) || (this.idpaciente != null && !this.idpaciente.equals(other.idpaciente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Paciente[ idpaciente=" + idpaciente + " ]";
    }
    public String fecha(Date fecha,String formato){
        SimpleDateFormat sdf = null;
        if (formato == null){
            sdf = new SimpleDateFormat("YYYY-MM-dd");
            
        }
        else{
            sdf = new SimpleDateFormat(formato);
            
        }
        return sdf.format(fecha);
        
        
    }
    
}
