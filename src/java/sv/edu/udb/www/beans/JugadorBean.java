package sv.edu.udb.www.beans;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import sv.edu.udb.www.ejb.EquipoEntityFacade;
import sv.edu.udb.www.ejb.JugadorEntityFacade;
import sv.edu.udb.www.ejb.JuegoEntityFacade;
import sv.edu.udb.www.ejb.UsuarioEntityFacade;
import sv.edu.udb.www.entities.EquipoEntity;
import sv.edu.udb.www.entities.JugadorEntity;
import sv.edu.udb.www.entities.JuegoEntity;
import sv.edu.udb.www.entities.UsuarioEntity;

@Named(value = "jugadorBean")
@ManagedBean
@SessionScoped
public class JugadorBean implements Serializable {

    @EJB
    private JugadorEntityFacade jugadorFacade;

    @EJB
    private JuegoEntityFacade juegoFacade;

    @EJB
    private UsuarioEntityFacade usuarioFacade;

    private EquipoEntity equipoEntity;

    private JugadorEntity jugador = new JugadorEntity();

    @PersistenceContext(unitName = "rteamprojectPU")
    private EntityManager em;

    public JugadorBean() {
    }

    public String agregarJugador(UsuarioEntity usuarioEntity) {
        try {
            this.jugador.setIdUsuario(usuarioEntity);
            jugadorFacade.create(this.jugador);
            FacesMessage messagesuccess = new FacesMessage(FacesMessage.SEVERITY_INFO, "ÉXITO:", "Jugador registrado");
            FacesContext.getCurrentInstance().addMessage(null, messagesuccess);
            jugador.setDescripcion(null);
            jugador.setId(null);
            jugador.setIdJuego(null);
            jugador.setIdUsuario(null);
            jugador.setLiga(null);
            jugador.setNivel(0);
            jugador.setPosicion(null);
            jugador.setRol(null);
            jugador.setUsuario(null);
            return "";
        } catch (Exception e) {
            FacesMessage messageerror = new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR:", "Este jugador ya existe");
            FacesContext.getCurrentInstance().addMessage(null, messageerror);
            return "";
        }
    }

    public String modificarJugador() {
        try {
            jugadorFacade.edit(this.jugador);
            FacesMessage messagesuccess = new FacesMessage(FacesMessage.SEVERITY_INFO, "ÉXITO:", "Se ha modificado el jugador");
            FacesContext.getCurrentInstance().addMessage(null, messagesuccess);
            jugador.setDescripcion(null);
            jugador.setId(null);
            jugador.setIdJuego(null);
            jugador.setIdUsuario(null);
            jugador.setLiga(null);
            jugador.setNivel(0);
            jugador.setPosicion(null);
            jugador.setRol(null);
            jugador.setUsuario(null);
            return "";
        } catch (Exception e) {
            FacesMessage messageerror = new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR:", "El jugador no puede ser modificado");
            FacesContext.getCurrentInstance().addMessage(null, messageerror);
            return "";
        }
    }

    public String eliminarJugador(int id) {
        try {
            JugadorEntity jugadorToFind = new JugadorEntity();
            jugadorToFind = jugadorFacade.find(id);
            jugadorFacade.remove(jugadorToFind);
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "ÉXITO:", "El jugador se eliminó");
            FacesContext.getCurrentInstance().addMessage(null, message);
            jugador.setDescripcion(null);
            jugador.setId(null);
            jugador.setIdJuego(null);
            jugador.setIdUsuario(null);
            jugador.setLiga(null);
            jugador.setNivel(0);
            jugador.setPosicion(null);
            jugador.setRol(null);
            jugador.setUsuario(null);
            return "";
        } catch (Exception e) {
            FacesMessage messageerror = new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR:", "Este jugador no puede ser eliminado");
            FacesContext.getCurrentInstance().addMessage(null, messageerror);
            return "";
        }
    }

    public int contarJugadores() {
        int cuenta = jugadorFacade.count();
        return cuenta;
    }

    public List<JugadorEntity> getJugadores() {
        List<JugadorEntity> lista = jugadorFacade.findAll();
        return lista;
    }

    public List<JugadorEntity> enlistarJugadoresByUser(int idUsuario) {

        List<JugadorEntity> lista = this.em.createNamedQuery("JugadorEntity.findByIdUsuario", JugadorEntity.class).setParameter("idUsuario", idUsuario).getResultList();
        return lista;
    }
    
    

    public void obtenerJugador(int id) {
        this.jugador = jugadorFacade.find(id);
    }

    /**
     * @return the jugador
     */
    public JugadorEntity getJugador() {
        return jugador;
    }

    /**
     * @param jugador the jugador to set
     */
    public void setJugador(JugadorEntity jugador) {
        this.jugador = jugador;
    }

    public List<JuegoEntity> getJuegosList() {
        return juegoFacade.findAll();
    }

    public List<UsuarioEntity> getUsuariosList() {
        return usuarioFacade.findAll();
    }

    /**
     * @return the equipoEntity
     */
    public EquipoEntity getEquipoEntity() {
        return equipoEntity;
    }

    /**
     * @param equipoEntity the equipoEntity to set
     */
    public void setEquipoEntity(EquipoEntity equipoEntity) {
        this.equipoEntity = equipoEntity;
    }

}
