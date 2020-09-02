/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.www.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Carlos Serrano
 */
@Entity
@Table(name = "usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsuarioEntity.findAll", query = "SELECT u FROM UsuarioEntity u")
    , @NamedQuery(name = "UsuarioEntity.findById", query = "SELECT u FROM UsuarioEntity u WHERE u.id = :id")
    , @NamedQuery(name = "UsuarioEntity.findByNombre", query = "SELECT u FROM UsuarioEntity u WHERE u.nombre = :nombre")
    , @NamedQuery(name = "UsuarioEntity.findByCorreo", query = "SELECT u FROM UsuarioEntity u WHERE u.correo = :correo")
    , @NamedQuery(name = "UsuarioEntity.findByClave", query = "SELECT u FROM UsuarioEntity u WHERE u.clave = :clave")
    , @NamedQuery(name = "UsuarioEntity.findByNacimiento", query = "SELECT u FROM UsuarioEntity u WHERE u.nacimiento = :nacimiento")
    , @NamedQuery(name = "UsuarioEntity.findByEstado", query = "SELECT u FROM UsuarioEntity u WHERE u.estado = :estado")
    , @NamedQuery(name = "UsuarioEntity.findByRol", query = "SELECT u FROM UsuarioEntity u WHERE u.rol = :rol")})
public class UsuarioEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "correo")
    private String correo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "clave")
    private String clave;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nacimiento")
    @Temporal(TemporalType.DATE)
    private Date nacimiento;
    @Size(max = 200)
    @Column(name = "estado")
    private String estado;
    @Size(max = 200)
    @Column(name = "rol")
    private String rol;
    @Lob
    @Size(max = 65535)
    @Column(name = "foto")
    private String foto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario")
    private Collection<JugadorEntity> jugadorEntityCollection;

    public UsuarioEntity() {
    }

    public UsuarioEntity(Integer id) {
        this.id = id;
    }

    public UsuarioEntity(Integer id, String nombre, String correo, String clave, Date nacimiento) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.clave = clave;
        this.nacimiento = nacimiento;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Date getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(Date nacimiento) {
        this.nacimiento = nacimiento;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    @XmlTransient
    public Collection<JugadorEntity> getJugadorEntityCollection() {
        return jugadorEntityCollection;
    }

    public void setJugadorEntityCollection(Collection<JugadorEntity> jugadorEntityCollection) {
        this.jugadorEntityCollection = jugadorEntityCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioEntity)) {
            return false;
        }
        UsuarioEntity other = (UsuarioEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.udb.www.entities.UsuarioEntity[ id=" + id + " ]";
    }
    
}
