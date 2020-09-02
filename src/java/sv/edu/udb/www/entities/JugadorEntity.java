/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.www.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Carlos Serrano
 */
@Entity
@Table(name = "jugador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "JugadorEntity.findAll", query = "SELECT j FROM JugadorEntity j")
    , @NamedQuery(name = "JugadorEntity.findById", query = "SELECT j FROM JugadorEntity j WHERE j.id = :id")
    , @NamedQuery(name = "JugadorEntity.findByUsuario", query = "SELECT j FROM JugadorEntity j WHERE j.usuario = :usuario")
    , @NamedQuery(name = "JugadorEntity.findByRol", query = "SELECT j FROM JugadorEntity j WHERE j.rol = :rol")
    , @NamedQuery(name = "JugadorEntity.findByPosicion", query = "SELECT j FROM JugadorEntity j WHERE j.posicion = :posicion")
    , @NamedQuery(name = "JugadorEntity.findByLiga", query = "SELECT j FROM JugadorEntity j WHERE j.liga = :liga")
    , @NamedQuery(name = "JugadorEntity.findByIdUsuario", query = "SELECT j FROM JugadorEntity j WHERE j.idUsuario.id = :idUsuario")
    , @NamedQuery(name = "JugadorEntity.findByJuego", query = "SELECT  j FROM JugadorEntity j  WHERE j.idJuego.id = :idJuegoParam AND j.idUsuario.id = :idUsuarioParam")
    , @NamedQuery(name = "JugadorEntity.findByDescripcion", query = "SELECT j FROM JugadorEntity j WHERE j.descripcion = :descripcion")
    , @NamedQuery(name = "JugadorEntity.findByNivel", query = "SELECT j FROM JugadorEntity j WHERE j.nivel = :nivel")})
public class JugadorEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "usuario")
    private String usuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "rol")
    private String rol;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "posicion")
    private String posicion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "liga")
    private String liga;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nivel")
    private int nivel;
    @JoinColumn(name = "id_juego", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private JuegoEntity idJuego;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private UsuarioEntity idUsuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idJugador")
    private Collection<SolicitudEntity> solicitudEntityCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idJugador")
    private Collection<AlineacionEntity> alineacionEntityCollection;

    public JugadorEntity() {
    }

    public JugadorEntity(Integer id) {
        this.id = id;
    }

    public JugadorEntity(Integer id, String usuario, String rol, String posicion, String liga, String descripcion, int nivel) {
        this.id = id;
        this.usuario = usuario;
        this.rol = rol;
        this.posicion = posicion;
        this.liga = liga;
        this.descripcion = descripcion;
        this.nivel = nivel;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public String getLiga() {
        return liga;
    }

    public void setLiga(String liga) {
        this.liga = liga;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public JuegoEntity getIdJuego() {
        return idJuego;
    }

    public void setIdJuego(JuegoEntity idJuego) {
        this.idJuego = idJuego;
    }

    public UsuarioEntity getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(UsuarioEntity idUsuario) {
        this.idUsuario = idUsuario;
    }

    @XmlTransient
    public Collection<SolicitudEntity> getSolicitudEntityCollection() {
        return solicitudEntityCollection;
    }

    public void setSolicitudEntityCollection(Collection<SolicitudEntity> solicitudEntityCollection) {
        this.solicitudEntityCollection = solicitudEntityCollection;
    }

    @XmlTransient
    public Collection<AlineacionEntity> getAlineacionEntityCollection() {
        return alineacionEntityCollection;
    }

    public void setAlineacionEntityCollection(Collection<AlineacionEntity> alineacionEntityCollection) {
        this.alineacionEntityCollection = alineacionEntityCollection;
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
        if (!(object instanceof JugadorEntity)) {
            return false;
        }
        JugadorEntity other = (JugadorEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.udb.www.entities.JugadorEntity[ id=" + id + " ]";
    }

}
