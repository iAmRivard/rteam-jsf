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
@Table(name = "vacante")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VacanteEntity.findAll", query = "SELECT v FROM VacanteEntity v")
    , @NamedQuery(name = "VacanteEntity.findById", query = "SELECT v FROM VacanteEntity v WHERE v.id = :id")
    , @NamedQuery(name = "VacanteEntity.findByNombre", query = "SELECT v FROM VacanteEntity v WHERE v.nombre = :nombre")
    , @NamedQuery(name = "VacanteEntity.findByDescripcion", query = "SELECT v FROM VacanteEntity v WHERE v.descripcion = :descripcion")
    , @NamedQuery(name = "VacanteEntity.findByRequisitos", query = "SELECT v FROM VacanteEntity v WHERE v.requisitos = :requisitos")
    , @NamedQuery(name = "VacanteEntity.findByEstado", query = "SELECT v FROM VacanteEntity v WHERE v.estado = :estado")
    , @NamedQuery(name = "VacanteEntity.findByIdEquipo", query = "SELECT v FROM VacanteEntity v WHERE v.idEquipo.id = :idEquipoParam AND v.idEquipo.estado = :estadoEquipo AND v.estado = :estadoVacante")
    , @NamedQuery(name = "VacanteEntity.findByFecha", query = "SELECT v FROM VacanteEntity v WHERE v.fecha = :fecha")})
public class VacanteEntity implements Serializable {

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
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "requisitos")
    private String requisitos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "estado")
    private String estado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @JoinColumn(name = "id_equipo", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private EquipoEntity idEquipo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idVacante")
    private Collection<SolicitudEntity> solicitudEntityCollection;

    public VacanteEntity() {
    }

    public VacanteEntity(Integer id) {
        this.id = id;
    }

    public VacanteEntity(Integer id, String nombre, String descripcion, String requisitos, String estado, Date fecha) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.requisitos = requisitos;
        this.estado = estado;
        this.fecha = fecha;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getRequisitos() {
        return requisitos;
    }

    public void setRequisitos(String requisitos) {
        this.requisitos = requisitos;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public EquipoEntity getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(EquipoEntity idEquipo) {
        this.idEquipo = idEquipo;
    }

    @XmlTransient
    public Collection<SolicitudEntity> getSolicitudEntityCollection() {
        return solicitudEntityCollection;
    }

    public void setSolicitudEntityCollection(Collection<SolicitudEntity> solicitudEntityCollection) {
        this.solicitudEntityCollection = solicitudEntityCollection;
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
        if (!(object instanceof VacanteEntity)) {
            return false;
        }
        VacanteEntity other = (VacanteEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.udb.www.entities.VacanteEntity[ id=" + id + " ]";
    }

}
