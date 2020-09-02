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
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
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
@Table(name = "equipo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EquipoEntity.findAll", query = "SELECT e FROM EquipoEntity e")
    , @NamedQuery(name = "EquipoEntity.findById", query = "SELECT e FROM EquipoEntity e WHERE e.id = :id")
    , @NamedQuery(name = "EquipoEntity.findByNombre", query = "SELECT e FROM EquipoEntity e WHERE e.nombre = :nombre")
    , @NamedQuery(name = "EquipoEntity.findByCorreo", query = "SELECT e FROM EquipoEntity e WHERE e.correo = :correo")
    , @NamedQuery(name = "EquipoEntity.findByPassword", query = "SELECT e FROM EquipoEntity e WHERE e.password = :password")
    , @NamedQuery(name = "EquipoEntity.findByFundacion", query = "SELECT e FROM EquipoEntity e WHERE e.fundacion = :fundacion")
    , @NamedQuery(name = "EquipoEntity.findByRepresentante", query = "SELECT e FROM EquipoEntity e WHERE e.representante = :representante")
    , @NamedQuery(name = "EquipoEntity.findByTelefono", query = "SELECT e FROM EquipoEntity e WHERE e.telefono = :telefono")
    , @NamedQuery(name = "EquipoEntity.findByEstado", query = "SELECT e FROM EquipoEntity e WHERE e.estado = :estado")})
public class EquipoEntity implements Serializable {

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
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fundacion")
    @Temporal(TemporalType.DATE)
    private Date fundacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "representante")
    private String representante;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "telefono")
    private String telefono;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "estado")
    private String estado;
    @Lob
    @Size(max = 65535)
    @Column(name = "foto")
    private String foto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEquipo")
    private Collection<VacanteEntity> vacanteEntityCollection;
    @JoinColumn(name = "id_juego", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private JuegoEntity idJuego;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEquipo")
    private Collection<AlineacionEntity> alineacionEntityCollection;

    public EquipoEntity() {
    }

    public EquipoEntity(Integer id) {
        this.id = id;
    }

    public EquipoEntity(Integer id, String nombre, String correo, String password, Date fundacion, String representante, String telefono, String descripcion, String estado) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.password = password;
        this.fundacion = fundacion;
        this.representante = representante;
        this.telefono = telefono;
        this.descripcion = descripcion;
        this.estado = estado;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getFundacion() {
        return fundacion;
    }

    public void setFundacion(Date fundacion) {
        this.fundacion = fundacion;
    }

    public String getRepresentante() {
        return representante;
    }

    public void setRepresentante(String representante) {
        this.representante = representante;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    @XmlTransient
    public Collection<VacanteEntity> getVacanteEntityCollection() {
        return vacanteEntityCollection;
    }

    public void setVacanteEntityCollection(Collection<VacanteEntity> vacanteEntityCollection) {
        this.vacanteEntityCollection = vacanteEntityCollection;
    }

    public JuegoEntity getIdJuego() {
        return idJuego;
    }

    public void setIdJuego(JuegoEntity idJuego) {
        this.idJuego = idJuego;
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
        if (!(object instanceof EquipoEntity)) {
            return false;
        }
        EquipoEntity other = (EquipoEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.udb.www.entities.EquipoEntity[ id=" + id + " ]";
    }
    
}
