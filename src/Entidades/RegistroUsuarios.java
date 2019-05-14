/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author flow3
 */
@Entity
@Table(name = "registro_usuarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RegistroUsuarios.findAll", query = "SELECT r FROM RegistroUsuarios r")
    , @NamedQuery(name = "RegistroUsuarios.findByIdRegistrousuarios", query = "SELECT r FROM RegistroUsuarios r WHERE r.idRegistrousuarios = :idRegistrousuarios")
    , @NamedQuery(name = "RegistroUsuarios.findByNombre", query = "SELECT r FROM RegistroUsuarios r WHERE r.nombre = :nombre")
    , @NamedQuery(name = "RegistroUsuarios.findByApellido", query = "SELECT r FROM RegistroUsuarios r WHERE r.apellido = :apellido")
    , @NamedQuery(name = "RegistroUsuarios.findByEspecialidad", query = "SELECT r FROM RegistroUsuarios r WHERE r.especialidad = :especialidad")
    , @NamedQuery(name = "RegistroUsuarios.findByTelefono", query = "SELECT r FROM RegistroUsuarios r WHERE r.telefono = :telefono")
    , @NamedQuery(name = "RegistroUsuarios.findByUsuario", query = "SELECT r FROM RegistroUsuarios r WHERE r.usuario = :usuario")
    , @NamedQuery(name = "RegistroUsuarios.findByContrase\u00f1a", query = "SELECT r FROM RegistroUsuarios r WHERE r.contrase\u00f1a = :contrase\u00f1a")})
public class RegistroUsuarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idRegistro_usuarios")
    private Integer idRegistrousuarios;
    @Basic(optional = false)
    @Column(name = "Nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "Apellido")
    private String apellido;
    @Basic(optional = false)
    @Column(name = "Especialidad")
    private String especialidad;
    @Basic(optional = false)
    @Column(name = "Telefono")
    private String telefono;
    @Basic(optional = false)
    @Column(name = "Usuario")
    private String usuario;
    @Basic(optional = false)
    @Column(name = "Contrase\u00f1a")
    private String contraseña;
    @OneToMany(mappedBy = "idr")
    private Collection<Login> loginCollection;

    public RegistroUsuarios() {
    }

    public RegistroUsuarios(Integer idRegistrousuarios) {
        this.idRegistrousuarios = idRegistrousuarios;
    }

    public RegistroUsuarios(Integer idRegistrousuarios, String nombre, String apellido, String especialidad, String telefono, String usuario, String contraseña) {
        this.idRegistrousuarios = idRegistrousuarios;
        this.nombre = nombre;
        this.apellido = apellido;
        this.especialidad = especialidad;
        this.telefono = telefono;
        this.usuario = usuario;
        this.contraseña = contraseña;
    }

    public Integer getIdRegistrousuarios() {
        return idRegistrousuarios;
    }

    public void setIdRegistrousuarios(Integer idRegistrousuarios) {
        this.idRegistrousuarios = idRegistrousuarios;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    @XmlTransient
    public Collection<Login> getLoginCollection() {
        return loginCollection;
    }

    public void setLoginCollection(Collection<Login> loginCollection) {
        this.loginCollection = loginCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRegistrousuarios != null ? idRegistrousuarios.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RegistroUsuarios)) {
            return false;
        }
        RegistroUsuarios other = (RegistroUsuarios) object;
        if ((this.idRegistrousuarios == null && other.idRegistrousuarios != null) || (this.idRegistrousuarios != null && !this.idRegistrousuarios.equals(other.idRegistrousuarios))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.RegistroUsuarios[ idRegistrousuarios=" + idRegistrousuarios + " ]";
    }
    
}
