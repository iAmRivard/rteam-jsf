/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.www.entities;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Carlos Serrano
 */
@Entity
@Table(name = "alineacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AlineacionEntity.findAll", query = "SELECT a FROM AlineacionEntity a")
    , @NamedQuery(name = "AlineacionEntity.findById", query = "SELECT a FROM AlineacionEntity a WHERE a.id = :id")
    , @NamedQuery(name = "AlineacionEntity.findByPosicion", query = "SELECT a FROM AlineacionEntity a WHERE a.posicion = :posicion")
    , @NamedQuery(name = "AlineacionEntity.findByDescripcion", query = "SELECT a FROM AlineacionEntity a WHERE a.descripcion = :descripcion")
    , @NamedQuery(name = "AlineacionEntity.findByEstado", query = "SELECT a FROM AlineacionEntity a WHERE a.estado = :estado")})
public class AlineacionEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "posicion")
    private String posicion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "estado")
    private String estado;
    @JoinColumn(name = "id_equipo", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private EquipoEntity idEquipo;
    @JoinColumn(name = "id_jugador", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private JugadorEntity idJugador;

    public AlineacionEntity() {
    }

    public AlineacionEntity(Integer id) {
        this.id = id;
    }

    public AlineacionEntity(Integer id, String posicion, String descripcion, String estado) {
        this.id = id;
        this.posicion = posicion;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
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

    public EquipoEntity getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(EquipoEntity idEquipo) {
        this.idEquipo = idEquipo;
    }

    public JugadorEntity getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(JugadorEntity idJugador) {
        this.idJugador = idJugador;
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
        if (!(object instanceof AlineacionEntity)) {
            return false;
        }
        AlineacionEntity other = (AlineacionEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.udb.www.entities.AlineacionEntity[ id=" + id + " ]";
    }
    
}
