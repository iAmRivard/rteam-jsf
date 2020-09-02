/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.www.beans;

import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import sv.edu.udb.www.ejb.EquipoEntityFacade;
import sv.edu.udb.www.ejb.UsuarioEntityFacade;
import sv.edu.udb.www.entities.EquipoEntity;
import sv.edu.udb.www.entities.UsuarioEntity;

/**
 *
 * @author LENOVO
 */
@Named(value = "loginBean")
@SessionScoped
public class LoginBean implements Serializable {

    FacesContext faces = FacesContext.getCurrentInstance();

    private String nombreUsuario;
    private String password;
    
    private String correoEquipo;
    private String clave;

    @EJB
    private UsuarioEntityFacade usuFacade;
    private UsuarioEntity usuarioAutenticado;
    @EJB
    private EquipoEntityFacade equipoFacade;
    private EquipoEntity equipoAutenticado;

    /**
     * Creates a new instance of LoginBean
     */
    public LoginBean() {
    }

    public String autenticar() {

        usuarioAutenticado = usuFacade.encontrarUsuariocLogin(nombreUsuario);
        equipoAutenticado = equipoFacade.encontrarEquipocLogin(nombreUsuario);

        

        if (usuarioAutenticado != null) {
            if ("Activo".equals(usuarioAutenticado.getEstado())) {
                if (usuarioAutenticado.getClave().equals(password)) {
                    if ("Jugador".equals(usuarioAutenticado.getRol())) {
                        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", usuarioAutenticado);
                        return "administrador/dashboardAdmin?faces-redirect=true";
                    }
                    if ("Administrador".equals(usuarioAutenticado.getRol())) {
                        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", usuarioAutenticado);
                        return "administrador/dashboardAdmin?faces-redirect=true";
                    }
                    if ("Reclutador".equals(usuarioAutenticado.getRol())) {
                        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", usuarioAutenticado);
                        return "administrador/dashboardAdmin?faces-redirect=true";
                    }

                } else {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "La contrasena no es", "La contrasena no corresponde"));
                }
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Tu usuario no esta activo", "Tu usuario no esta activo"));

            }

        } else {
           if (getEquipoAutenticado() != null) {
            if ("Activo".equals(getEquipoAutenticado().getEstado())) {
                if (getEquipoAutenticado().getPassword().equals(password)) {
                 
                  
                        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("jugador", usuarioAutenticado);
                        return "equipo/dashboardEquipo?faces-redirect=true";
                    

                } else {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "La contrasena no es", "La contrasena no corresponde"));
                }
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Tu usuario no esta activo", "Tu usuario no esta activo"));

            }

        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "El Usuario no existe", "El Usuario no existe"));
        }
        }
         
        return null;
    }

    public String verificar() throws IOException {
       // UsuarioEntity usuario = (UsuarioEntity) faces.getExternalContext().getSessionMap().get("usuario");

        if (usuarioAutenticado.getRol() != "Jugador") {
            return "../login?faces-redirect=true";

        }
        return null;
    }
    public String salir(){
       // UsuarioEntity usuario = (UsuarioEntity) faces.getExternalContext().getSessionMap().get("usuario");

       usuarioAutenticado = null;
       equipoAutenticado = null;

     
        return null;
      
    }
    /**
     * @return the nombreUsuario
     */
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    /**
     * @param nombreUsuario the nombreUsuario to set
     */
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the usuarioAutenticado
     */
    public UsuarioEntity getUsuarioAutenticado() {
        return usuarioAutenticado;
    }

    /**
     * @param usuarioAutenticado the usuarioAutenticado to set
     */
    public void setUsuarioAutenticado(UsuarioEntity usuarioAutenticado) {
        this.usuarioAutenticado = usuarioAutenticado;
    }

    /**
     * @return the clave
     */
    public String getClave() {
        return clave;
    }

    /**
     * @param clave the clave to set
     */
    public void setClave(String clave) {
        this.clave = clave;
    }

    /**
     * @return the equipoAutenticado
     */
    public EquipoEntity getEquipoAutenticado() {
        return equipoAutenticado;
    }

    /**
     * @param equipoAutenticado the equipoAutenticado to set
     */
    public void setEquipoAutenticado(EquipoEntity equipoAutenticado) {
        this.equipoAutenticado = equipoAutenticado;
    }

}
