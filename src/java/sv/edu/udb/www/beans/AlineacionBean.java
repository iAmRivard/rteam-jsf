package sv.edu.udb.www.beans;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import org.apache.log4j.Logger;
import sv.edu.udb.www.ejb.AlineacionEntityFacade;
import sv.edu.udb.www.entities.AlineacionEntity;

@Named(value = "alineacionBean")
@ManagedBean
@SessionScoped
public class AlineacionBean implements Serializable {

    private static Logger logger = Logger.getLogger(Navigator.class);

    @EJB
    private AlineacionEntityFacade alineacionFacade;

    private AlineacionEntity alineacion = new AlineacionEntity();

    public AlineacionBean() {

    }

    public String agregarAlineacion() {
        this.alineacion.setEstado("Activa");
        try {
            alineacionFacade.create(this.alineacion);
            FacesMessage messagesuccess = new FacesMessage(FacesMessage.SEVERITY_INFO, "ÉXITO:", "Alineación registrada");
            FacesContext.getCurrentInstance().addMessage(null, messagesuccess);
            alineacion.setId(null);
            alineacion.setIdEquipo(null);
            alineacion.setIdJugador(null);
            alineacion.setPosicion(null);
            alineacion.setDescripcion(null);
            alineacion.setEstado(null);
            logger.info("Alineación registrada");
            return "";
        } catch (Exception e) {
            FacesMessage messageerror = new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR:", "Hubo un error en el sistema");
            FacesContext.getCurrentInstance().addMessage(null, messageerror);
            logger.warn("Hubo un error en el sistema");
            return "";
        }
    }

    public String modificarAlineacion() {
        try {
            alineacionFacade.edit(this.alineacion);
            FacesMessage messagesuccess = new FacesMessage(FacesMessage.SEVERITY_INFO, "ÉXITO:", "Se ha modificado la alineación");
            FacesContext.getCurrentInstance().addMessage(null, messagesuccess);
            alineacion.setId(null);
            alineacion.setIdEquipo(null);
            alineacion.setIdJugador(null);
            alineacion.setPosicion(null);
            alineacion.setDescripcion(null);
            alineacion.setEstado(null);
            return "";
        } catch (Exception e) {
            FacesMessage messageerror = new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR:", "La alineación no puede ser modificada");
            FacesContext.getCurrentInstance().addMessage(null, messageerror);
            return "";
        }
    }

    public String eliminarAlineacion(int id) {
        try {
            AlineacionEntity alineacionToFind = new AlineacionEntity();
            alineacionToFind = alineacionFacade.find(id);
            alineacionFacade.remove(alineacionToFind);
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "ÉXITO:", "La alineación se eliminó");
            FacesContext.getCurrentInstance().addMessage(null, message);
            alineacion.setId(null);
            alineacion.setIdEquipo(null);
            alineacion.setIdJugador(null);
            alineacion.setPosicion(null);
            alineacion.setDescripcion(null);
            alineacion.setEstado(null);
            return "";
        } catch (Exception e) {
            FacesMessage messageerror = new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR:", "La alineación no puede ser eliminada");
            FacesContext.getCurrentInstance().addMessage(null, messageerror);
            return "";
        }
    }

    public int contarAlineacions() {
        int cuenta = alineacionFacade.count();
        return cuenta;
    }

    public List<AlineacionEntity> getAlineaciones() {
        List<AlineacionEntity> lista = alineacionFacade.findAll();
        return lista;
    }

    public void obtenerAlineacion(int id) {
        this.alineacion = alineacionFacade.find(id);
    }

    /**
     * @return the alineacion
     */
    public AlineacionEntity getAlineacion() {
        return alineacion;
    }

    /**
     * @param alineacion the alineacion to set
     */
    public void setAlineacion(AlineacionEntity alineacion) {
        this.alineacion = alineacion;
    }

}
