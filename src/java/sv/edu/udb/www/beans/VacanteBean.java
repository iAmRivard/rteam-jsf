package sv.edu.udb.www.beans;

import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import sv.edu.udb.www.ejb.EquipoEntityFacade;
import sv.edu.udb.www.ejb.VacanteEntityFacade;
import sv.edu.udb.www.entities.EquipoEntity;
import sv.edu.udb.www.entities.JuegoEntity;
import sv.edu.udb.www.entities.JugadorEntity;
import sv.edu.udb.www.entities.VacanteEntity;

@Named(value = "vacanteBean")
@ManagedBean
@SessionScoped
public class VacanteBean implements Serializable {

    /**
     * @return the juego
     */
    public JuegoEntity getJuego() {
        return juego;
    }

    /**
     * @param juego the juego to set
     */
    public void setJuego(JuegoEntity juego) {
        this.juego = juego;
    }
    @EJB
    private EquipoEntityFacade equipoFacade;
    
    @EJB
    private VacanteEntityFacade vacanteFacade;

    private VacanteEntity vacante = new VacanteEntity();
    private EquipoEntity equipo = new EquipoEntity();
    private JuegoEntity juego = new JuegoEntity();
    
    private int idJuegoUrl;
    
    @PersistenceContext(unitName = "rteamprojectPU")
    private EntityManager em;
    
    private int idEquipoURL;

    public VacanteBean() {
    }

    public String agregarVacante() {
        try {
            this.vacante.setEstado("Activa");
            this.vacante.setFecha(new Date());
            vacanteFacade.create(this.vacante);
            FacesMessage messagesuccess = new FacesMessage(FacesMessage.SEVERITY_INFO, "EXITO:", "Se ha registrado la vacante");
            FacesContext.getCurrentInstance().addMessage(null, messagesuccess);
            vacante.setId(null);
            vacante.setNombre(null);
            vacante.setDescripcion(null);
            vacante.setRequisitos(null);
            vacante.setIdEquipo(null);
            vacante.setEstado(null);
            vacante.setFecha(null);
            return "";
        } catch (Exception e) {
            FacesMessage messageerror = new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR:", "La vacante ya existe");
            FacesContext.getCurrentInstance().addMessage(null, messageerror);
            return "";
        }
    }

    public String modificarVacante() {
        try {
            vacanteFacade.edit(this.vacante);
            FacesMessage messagesuccess = new FacesMessage(FacesMessage.SEVERITY_INFO, "ÉXITO:", "Se ha modificado la vacante");
            FacesContext.getCurrentInstance().addMessage(null, messagesuccess);
            vacante.setId(null);
            vacante.setNombre(null);
            vacante.setDescripcion(null);
            vacante.setRequisitos(null);
            vacante.setIdEquipo(null);
            vacante.setEstado(null);
            vacante.setFecha(null);
            return "";
        } catch (Exception e) {
            FacesMessage messageerror = new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR:", "La vacante no puede ser modificada");
            FacesContext.getCurrentInstance().addMessage(null, messageerror);
            return "";
        }
    }
    
    public List<VacanteEntity> mostrarVacantesDeEquipo() {
        List<VacanteEntity> lista = this.em.createNamedQuery("VacanteEntity.findByIdEquipo", VacanteEntity.class).setParameter("idEquipoParam", this.equipo.getId()).setParameter("estadoEquipo", "Activo").setParameter("estadoVacante", "Activa").getResultList();
        return lista;
    }
    
    public List<JugadorEntity> jugadoresSegunJuego(int idJuego, int idUsuario) {
        List<JugadorEntity> lista = this.em.createNamedQuery("JugadorEntity.findByJuego", JugadorEntity.class).setParameter("idJuegoParam", idJuego).setParameter("idUsuarioParam", idUsuario).getResultList();
        return lista;
    }

    public String eliminarVacante(int id) {
        try {
            VacanteEntity vacanteToFind = new VacanteEntity();
            vacanteToFind = vacanteFacade.find(id);
            vacanteFacade.remove(vacanteToFind);
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "ÉXITO:", "La vacante se eliminó");
            FacesContext.getCurrentInstance().addMessage(null, message);
            vacante.setId(null);
            vacante.setNombre(null);
            vacante.setDescripcion(null);
            vacante.setRequisitos(null);
            vacante.setIdEquipo(null);
            vacante.setEstado(null);
            vacante.setFecha(null);
            return "";
        } catch (Exception e) {
            FacesMessage messageerror = new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR:", "La vacante no puede ser eliminada");
            FacesContext.getCurrentInstance().addMessage(null, messageerror);
            return "";
        }
    }

    public int contarVacantes() {
        int cuenta = vacanteFacade.count();
        return cuenta;
    }

     public List<VacanteEntity> getVacantes() {
        List<VacanteEntity> lista = vacanteFacade.findAll();
        return lista;
    }
     
     public String redireccionarAVacantesDeEquipo(int idEquipo){
         return "verVacantesDeEquipo?faces-redirect=true";
     }
     
    public void obtenerVacante(int id) {
        this.vacante = vacanteFacade.find(id);
    }

    /**
     * @return the vacante
     */
    public VacanteEntity getVacante() {
        return vacante;
    }

    /**
     * @param vacante
     */
    public void setVacante(VacanteEntity vacante) {
        this.vacante = vacante;
    }
    public List<EquipoEntity> getEquiposList(){
        return equipoFacade.findAll();
    }

    /**
     * @return the idEquipoURL
     */
    public int getIdEquipoURL() {
        return idEquipoURL;
    }

    /**
     * @param idEquipoURL the idEquipoURL to set
     */
    public void setIdEquipoURL(int idEquipoURL) {
        this.idEquipoURL = idEquipoURL;
    }

    /**
     * @return the equipo
     */
    public EquipoEntity getEquipo() {
        return equipo;
    }

    /**
     * @param equipo the equipo to set
     */
    public void setEquipo(EquipoEntity equipo) {
        this.equipo = equipo;
    }

    /**
     * @return the idJuegoUrl
     */
    public int getIdJuegoUrl() {
        return idJuegoUrl;
    }

    /**
     * @param idJuegoUrl the idJuegoUrl to set
     */
    public void setIdJuegoUrl(int idJuegoUrl) {
        this.idJuegoUrl = idJuegoUrl;
    }
}