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
import javax.persistence.Lob;
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
@Table(name = "solicitud")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SolicitudEntity.findAll", query = "SELECT s FROM SolicitudEntity s")
    , @NamedQuery(name = "SolicitudEntity.findById", query = "SELECT s FROM SolicitudEntity s WHERE s.id = :id")
    , @NamedQuery(name = "SolicitudEntity.findByEstado", query = "SELECT s FROM SolicitudEntity s WHERE s.estado = :estado")})
public class SolicitudEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "estado")
    private String estado;
    @Lob
    @Size(max = 65535)
    @Column(name = "justificacion")
    private String justificacion;
    @JoinColumn(name = "id_jugador", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private JugadorEntity idJugador;
    @JoinColumn(name = "id_vacante", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private VacanteEntity idVacante;

    public SolicitudEntity() {
    }

    public SolicitudEntity(Integer id) {
        this.id = id;
    }

    public SolicitudEntity(Integer id, String estado) {
        this.id = id;
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getJustificacion() {
        return justificacion;
    }

    public void setJustificacion(String justificacion) {
        this.justificacion = justificacion;
    }

    public JugadorEntity getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(JugadorEntity idJugador) {
        this.idJugador = idJugador;
    }

    public VacanteEntity getIdVacante() {
        return idVacante;
    }

    public void setIdVacante(VacanteEntity idVacante) {
        this.idVacante = idVacante;
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
        if (!(object instanceof SolicitudEntity)) {
            return false;
        }
        SolicitudEntity other = (SolicitudEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.udb.www.entities.SolicitudEntity[ id=" + id + " ]";
    }
    
}
