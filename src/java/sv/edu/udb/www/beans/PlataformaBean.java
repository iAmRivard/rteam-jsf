package sv.edu.udb.www.beans;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import sv.edu.udb.www.ejb.PlataformaEntityFacade;
import sv.edu.udb.www.entities.PlataformaEntity;

@Named(value = "plataformaBean")
@ManagedBean
@SessionScoped
public class PlataformaBean implements Serializable {

    @EJB
    private PlataformaEntityFacade plataformaFacade;

    private PlataformaEntity plataforma = new PlataformaEntity();

    public PlataformaBean() {
    }

    public String agregarPlataforma() {
        try {
            plataformaFacade.create(this.plataforma);
            FacesMessage messagesuccess = new FacesMessage(FacesMessage.SEVERITY_INFO, "ÉXITO:", "Se ha registrado la plataforma");
            FacesContext.getCurrentInstance().addMessage(null, messagesuccess);
            plataforma.setNombre(null);
            plataforma.setLanzamiento(null);
            plataforma.setId(null);
            return "";
        } catch (Exception e) {
            FacesMessage messageerror = new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR:", "La plataforma ya existe");
            FacesContext.getCurrentInstance().addMessage(null, messageerror);
            return "";
        }
    }

    public String modificarPlataforma() {
        try {
            plataformaFacade.edit(this.plataforma);
            FacesMessage messagesuccess = new FacesMessage(FacesMessage.SEVERITY_INFO, "ÉXITO:", "Se ha modificado la plataforma");
            FacesContext.getCurrentInstance().addMessage(null, messagesuccess);
            plataforma.setNombre(null);
            plataforma.setLanzamiento(null);
            plataforma.setId(null);
            return "";
        } catch (Exception e) {
            FacesMessage messageerror = new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR:", "La plataforma no puede ser modificada");
            FacesContext.getCurrentInstance().addMessage(null, messageerror);
            return "";
        }
    }

    public String eliminarPlataforma(int id) {
        try {
            PlataformaEntity plataformaToFind = new PlataformaEntity();
            plataformaToFind = plataformaFacade.find(id);
            plataformaFacade.remove(plataformaToFind);
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "ÉXITO:", "La plataforma se eliminó");
            FacesContext.getCurrentInstance().addMessage(null, message);
            plataforma.setNombre(null);
            plataforma.setLanzamiento(null);
            plataforma.setId(null);
            return "";
        } catch (Exception e) {
            FacesMessage messageerror = new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR:", "La plataforma no puede ser eliminada");
            FacesContext.getCurrentInstance().addMessage(null, messageerror);
            return "";
        }
    }

    public int contarPlataformas() {
        int cuenta = plataformaFacade.count();
        return cuenta;
    }

    public List<PlataformaEntity> getPlataformas() {
        List<PlataformaEntity> lista = plataformaFacade.findAll();
        return lista;
    }

    public void obtenerPlataforma(int id) {
        this.plataforma = plataformaFacade.find(id);
    }

    /**
     * @return the plataforma
     */
    public PlataformaEntity getPlataforma() {
        return plataforma;
    }

    /**
     * @param plataforma the categoria to set
     */
    public void setPlataforma(PlataformaEntity plataforma) {
        this.plataforma = plataforma;
    }

}
