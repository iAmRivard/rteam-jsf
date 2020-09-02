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
@Table(name = "juego")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "JuegoEntity.findAll", query = "SELECT j FROM JuegoEntity j")
    , @NamedQuery(name = "JuegoEntity.findById", query = "SELECT j FROM JuegoEntity j WHERE j.id = :id")
    , @NamedQuery(name = "JuegoEntity.findByNombre", query = "SELECT j FROM JuegoEntity j WHERE j.nombre = :nombre")
    , @NamedQuery(name = "JuegoEntity.findByLanzamiento", query = "SELECT j FROM JuegoEntity j WHERE j.lanzamiento = :lanzamiento")})
public class JuegoEntity implements Serializable {

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
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "lanzamiento")
    @Temporal(TemporalType.DATE)
    private Date lanzamiento;
    @Lob
    @Size(max = 65535)
    @Column(name = "foto")
    private String foto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idJuego")
    private Collection<JugadorEntity> jugadorEntityCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idJuego")
    private Collection<EquipoEntity> equipoEntityCollection;
    @JoinColumn(name = "id_categoria", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private CategoriaEntity idCategoria;
    @JoinColumn(name = "id_plataforma", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private PlataformaEntity idPlataforma;

    public JuegoEntity() {
    }

    public JuegoEntity(Integer id) {
        this.id = id;
    }

    public JuegoEntity(Integer id, String nombre, String descripcion, Date lanzamiento) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.lanzamiento = lanzamiento;
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

    public Date getLanzamiento() {
        return lanzamiento;
    }

    public void setLanzamiento(Date lanzamiento) {
        this.lanzamiento = lanzamiento;
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

    @XmlTransient
    public Collection<EquipoEntity> getEquipoEntityCollection() {
        return equipoEntityCollection;
    }

    public void setEquipoEntityCollection(Collection<EquipoEntity> equipoEntityCollection) {
        this.equipoEntityCollection = equipoEntityCollection;
    }

    public CategoriaEntity getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(CategoriaEntity idCategoria) {
        this.idCategoria = idCategoria;
    }

    public PlataformaEntity getIdPlataforma() {
        return idPlataforma;
    }

    public void setIdPlataforma(PlataformaEntity idPlataforma) {
        this.idPlataforma = idPlataforma;
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
        if (!(object instanceof JuegoEntity)) {
            return false;
        }
        JuegoEntity other = (JuegoEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.udb.www.entities.JuegoEntity[ id=" + id + " ]";
    }
    
}
