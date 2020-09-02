/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.www.beans;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import sv.edu.udb.www.ejb.SolicitudEntityFacade;
import sv.edu.udb.www.entities.SolicitudEntity;

@Named(value = "solicitudBean")
@ManagedBean
@SessionScoped
public class SolicitudBean implements Serializable {
    
    @EJB
    private SolicitudEntityFacade solicitudFacade;
    
    private SolicitudEntity solicitud = new SolicitudEntity();
    
    public SolicitudBean() {
    }
    
    public String agregarSolicitud() {
        try {
            solicitud.setEstado("Pendiente");
            solicitud.setJustificacion(null);
            solicitudFacade.create(this.solicitud);
            FacesMessage messagesuccess = new FacesMessage(FacesMessage.SEVERITY_INFO, "ÉXITO:", "Solicitud enviada con éxito.");
            FacesContext.getCurrentInstance().addMessage(null, messagesuccess);
            solicitud.setEstado(null);
            solicitud.setId(null);
            solicitud.setIdJugador(null);
            solicitud.setIdVacante(null);
            solicitud.setJustificacion(null);
            return "";
        } catch (Exception e) {
            FacesMessage messageerror = new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR:", "Ya has aplicado a esta vacante");
            FacesContext.getCurrentInstance().addMessage(null, messageerror);
            return "";
        }
    }

    /**
     * @return the solicitud
     */
    public SolicitudEntity getSolicitud() {
        return solicitud;
    }

    /**
     * @param solicitud the solicitud to set
     */
    public void setSolicitud(SolicitudEntity solicitud) {
        this.solicitud = solicitud;
    }
    
    
}
