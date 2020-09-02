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
import sv.edu.udb.www.ejb.UsuarioEntityFacade;
import sv.edu.udb.www.entities.UsuarioEntity;

@Named(value = "usuarioBean")
@ManagedBean
@SessionScoped
public class UsuarioBean implements Serializable {

    @EJB
    private UsuarioEntityFacade usuarioFacade;

    private UsuarioEntity usuario = new UsuarioEntity();
    
    private EntityManager em;

    public UsuarioBean() {
    }

    public String agregarUsuario() {
        this.usuario.setEstado("Activo");
        this.usuario.setRol("Jugador");
        try {
            usuarioFacade.create(this.usuario);
            FacesMessage messagesuccess = new FacesMessage(FacesMessage.SEVERITY_INFO, "ÉXITO:", "Te has registrado");
            FacesContext.getCurrentInstance().addMessage(null, messagesuccess);
            usuario.setClave(null);
            usuario.setCorreo(null);
            usuario.setEstado(null);
            usuario.setNacimiento(null);
            usuario.setNombre(null);
            usuario.setRol(null);
            usuario.setId(null);
            return "";
        } catch (Exception e) {
            FacesMessage messageerror = new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR:", "El correo electrónico ya ha sido registrado");
            FacesContext.getCurrentInstance().addMessage(null, messageerror);
            return "";
        }
    }

    public String activarUsuario(int id) {
        try {
            UsuarioEntity usuarioToFind = new UsuarioEntity();
            usuarioToFind = usuarioFacade.find(id);
            usuarioToFind.setEstado("Activo");
            usuarioFacade.edit(usuarioToFind);
            FacesMessage messagesuccess = new FacesMessage(FacesMessage.SEVERITY_INFO, "ÉXITO:", "Usuario activado");
            FacesContext.getCurrentInstance().addMessage(null, messagesuccess);
            return "administrarEstados";
        } catch (Exception e) {
            FacesMessage messageerror = new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR:", "No se puede activar el usuario");
            FacesContext.getCurrentInstance().addMessage(null, messageerror);
            return "administrarEstados";
        }

    }
    
    public String desactivarUsuario(int id) {
        try {
            UsuarioEntity usuarioToFind = new UsuarioEntity();
            usuarioToFind = usuarioFacade.find(id);
            usuarioToFind.setEstado("Inactivo");
            usuarioFacade.edit(usuarioToFind);
            FacesMessage messagesuccess = new FacesMessage(FacesMessage.SEVERITY_INFO, "ÉXITO:", "Usuario desactivado");
            FacesContext.getCurrentInstance().addMessage(null, messagesuccess);
            return "administrarEstados";
        } catch (Exception e) {
            FacesMessage messageerror = new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR:", "No se puede desactivar el usuario");
            FacesContext.getCurrentInstance().addMessage(null, messageerror);
            return "administrarEstados";
        }

    }

    public List<UsuarioEntity> getUsuarios() {
        List<UsuarioEntity> lista = usuarioFacade.findAll();
        return lista;
    }
    
    /*public List<UsuarioEntity> getUsuariosActivos() {
        List<UsuarioEntity> lista = em.createNamedQuery("UsuarioEntity.findByEstado").setParameter("estado", "Activo").getResultList();
        return lista;
    }*/

    /**
     * @return the usuario
     */
    public UsuarioEntity getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(UsuarioEntity usuario) {
        this.usuario = usuario;
    }

    public int contarUsuarios() {
        int cuenta = usuarioFacade.count();
        return cuenta;
    }

}
