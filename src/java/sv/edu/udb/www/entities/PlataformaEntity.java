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
@Table(name = "plataforma")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PlataformaEntity.findAll", query = "SELECT p FROM PlataformaEntity p")
    , @NamedQuery(name = "PlataformaEntity.findById", query = "SELECT p FROM PlataformaEntity p WHERE p.id = :id")
    , @NamedQuery(name = "PlataformaEntity.findByNombre", query = "SELECT p FROM PlataformaEntity p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "PlataformaEntity.findByLanzamiento", query = "SELECT p FROM PlataformaEntity p WHERE p.lanzamiento = :lanzamiento")})
public class PlataformaEntity implements Serializable {

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
    @Column(name = "lanzamiento")
    @Temporal(TemporalType.DATE)
    private Date lanzamiento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPlataforma")
    private Collection<JuegoEntity> juegoEntityCollection;

    public PlataformaEntity() {
    }

    public PlataformaEntity(Integer id) {
        this.id = id;
    }

    public PlataformaEntity(Integer id, String nombre, Date lanzamiento) {
        this.id = id;
        this.nombre = nombre;
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

    public Date getLanzamiento() {
        return lanzamiento;
    }

    public void setLanzamiento(Date lanzamiento) {
        this.lanzamiento = lanzamiento;
    }

    @XmlTransient
    public Collection<JuegoEntity> getJuegoEntityCollection() {
        return juegoEntityCollection;
    }

    public void setJuegoEntityCollection(Collection<JuegoEntity> juegoEntityCollection) {
        this.juegoEntityCollection = juegoEntityCollection;
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
        if (!(object instanceof PlataformaEntity)) {
            return false;
        }
        PlataformaEntity other = (PlataformaEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.udb.www.entities.PlataformaEntity[ id=" + id + " ]";
    }
    
}
