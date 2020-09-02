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
import sv.edu.udb.www.ejb.JuegoEntityFacade;
import sv.edu.udb.www.entities.EquipoEntity;
import sv.edu.udb.www.entities.JuegoEntity;

@Named(value = "equipoBean")
@ManagedBean
@SessionScoped
public class EquipoBean implements Serializable {

    @EJB
    private EquipoEntityFacade equipoFacade;

    @EJB
    private JuegoEntityFacade juegoFacade;

    private EquipoEntity equipo = new EquipoEntity();

    @PersistenceContext(unitName = "rteamprojectPU")
    private EntityManager em;

    public EquipoBean() {
    }

    public String agregarEquipo() {
        try {
            equipo.setEstado("Activo");
            equipoFacade.create(this.equipo);
            FacesMessage messagesuccess = new FacesMessage(FacesMessage.SEVERITY_INFO, "ÉXITO:", "Equipo registrado");
            FacesContext.getCurrentInstance().addMessage(null, messagesuccess);
            equipo.setId(null);
            equipo.setNombre(null);
            equipo.setCorreo(null);
            equipo.setPassword(null);
            equipo.setFundacion(null);
            equipo.setRepresentante(null);
            equipo.setTelefono(null);
            equipo.setDescripcion(null);
            equipo.setIdJuego(null);
            return "";
        } catch (Exception e) {
            FacesMessage messageerror = new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR:", "Este equipo ya existe");
            FacesContext.getCurrentInstance().addMessage(null, messageerror);
            return "";
        }
    }

    public String modificarEquipo() {
        try {
            equipoFacade.edit(this.equipo);
            FacesMessage messagesuccess = new FacesMessage(FacesMessage.SEVERITY_INFO, "ÉXITO:", "Se ha modificado el equipo");
            FacesContext.getCurrentInstance().addMessage(null, messagesuccess);
            equipo.setId(null);
            equipo.setNombre(null);
            equipo.setCorreo(null);
            equipo.setPassword(null);
            equipo.setFundacion(null);
            equipo.setRepresentante(null);
            equipo.setTelefono(null);
            equipo.setDescripcion(null);
            equipo.setIdJuego(null);
            return "";
        } catch (Exception e) {
            FacesMessage messageerror = new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR:", "El equipo no puede ser modificado");
            FacesContext.getCurrentInstance().addMessage(null, messageerror);
            return "";
        }
    }

    public String eliminarEquipo(int id) {
        try {
            EquipoEntity equipoToFind = new EquipoEntity();
            equipoToFind = equipoFacade.find(id);
            equipoFacade.remove(equipoToFind);
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "ÉXITO:", "El equipo se eliminó");
            FacesContext.getCurrentInstance().addMessage(null, message);
            equipo.setId(null);
            equipo.setNombre(null);
            equipo.setCorreo(null);
            equipo.setPassword(null);
            equipo.setFundacion(null);
            equipo.setRepresentante(null);
            equipo.setTelefono(null);
            equipo.setDescripcion(null);
            equipo.setIdJuego(null);
            return "";
        } catch (Exception e) {
            FacesMessage messageerror = new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR:", "Este equipo no puede ser eliminado");
            FacesContext.getCurrentInstance().addMessage(null, messageerror);
            return "";
        }
    }

    public String activarEquipo(int id) {
        try {
            EquipoEntity equipoToFind = new EquipoEntity();
            equipoToFind = equipoFacade.find(id);
            equipoToFind.setEstado("Activo");
            equipoFacade.edit(equipoToFind);
            FacesMessage messagesuccess = new FacesMessage(FacesMessage.SEVERITY_INFO, "ÉXITO:", "Equipo activado");
            FacesContext.getCurrentInstance().addMessage(null, messagesuccess);
            return "administrarEstados";
        } catch (Exception e) {
            FacesMessage messageerror = new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR:", "No se puede activar el equipo");
            FacesContext.getCurrentInstance().addMessage(null, messageerror);
            return "administrarEstados";
        }

    }

    public String desactivarEquipo(int id) {
        try {
            EquipoEntity equipoToFind = new EquipoEntity();
            equipoToFind = equipoFacade.find(id);
            equipoToFind.setEstado("Inactivo");
            equipoFacade.edit(equipoToFind);
            FacesMessage messagesuccess = new FacesMessage(FacesMessage.SEVERITY_INFO, "ÉXITO:", "Equipo desactivado");
            FacesContext.getCurrentInstance().addMessage(null, messagesuccess);
            return "administrarEstados";
        } catch (Exception e) {
            FacesMessage messageerror = new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR:", "No se puede desactivar el usuario");
            FacesContext.getCurrentInstance().addMessage(null, messageerror);
            return "administrarEstados";
        }

    }

    public int contarEquipos() {
        int cuenta = equipoFacade.count();
        return cuenta;
    }

    public List<EquipoEntity> getEquipos() {
        List<EquipoEntity> lista = equipoFacade.findAll();
        return lista;
    }
    
    public List<EquipoEntity> getEquiposActivos2() {
        List<EquipoEntity> lista = this.em.createNamedQuery("EquipoEntity.findByEstado", EquipoEntity.class).setParameter("estado", "Activo").getResultList();
        return lista;
    }


    public void obtenerEquipo(int id) {
        this.equipo = equipoFacade.find(id);
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

    public List<JuegoEntity> getJuegosList() {
        return juegoFacade.findAll();
    }

}
