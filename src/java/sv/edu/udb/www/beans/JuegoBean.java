package sv.edu.udb.www.beans;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import sv.edu.udb.www.ejb.JuegoEntityFacade;
import sv.edu.udb.www.entities.JuegoEntity;
import sv.edu.udb.www.ejb.CategoriaEntityFacade;
import sv.edu.udb.www.entities.CategoriaEntity;
import sv.edu.udb.www.ejb.PlataformaEntityFacade;
import sv.edu.udb.www.entities.PlataformaEntity;

@Named(value = "juegoBean")
@ManagedBean
@SessionScoped
public class JuegoBean implements Serializable {

    @EJB
    private JuegoEntityFacade juegoFacade;
    
    @EJB
    private CategoriaEntityFacade categoriaFacade;
    
    @EJB
    private PlataformaEntityFacade plataformaFacade;

    private JuegoEntity juego = new JuegoEntity();

    public JuegoBean() {
    }

    public String agregarJuego() {
        try {
            juegoFacade.create(this.juego);
            FacesMessage messagesuccess = new FacesMessage(FacesMessage.SEVERITY_INFO, "ÉXITO:", "Juego registrado");
            FacesContext.getCurrentInstance().addMessage(null, messagesuccess);
            juego.setId(null);
            juego.setNombre(null);
            juego.setDescripcion(null);
            juego.setLanzamiento(null);
            juego.setIdCategoria(null);
            juego.setIdPlataforma(null);
            juego.setFoto(null);
            return "";
        } catch (Exception e) {
            FacesMessage messageerror = new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR:", "Este juego ya existe");
            FacesContext.getCurrentInstance().addMessage(null, messageerror);
            return "";
        }
    }

    public String modificarJuego() {
        try {
            juegoFacade.edit(this.juego);
            FacesMessage messagesuccess = new FacesMessage(FacesMessage.SEVERITY_INFO, "ÉXITO:", "Se ha modificado el juego");
            FacesContext.getCurrentInstance().addMessage(null, messagesuccess);
            juego.setId(null);
            juego.setNombre(null);
            juego.setDescripcion(null);
            juego.setLanzamiento(null);
            juego.setIdCategoria(null);
            juego.setIdPlataforma(null);
            juego.setFoto(null);
            return "";
        } catch (Exception e) {
            FacesMessage messageerror = new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR:", "El juego no puede ser modificado");
            FacesContext.getCurrentInstance().addMessage(null, messageerror);
            return "";
        }
    }

    public String eliminarJuego(int id) {
        try {
            JuegoEntity juegoToFind = new JuegoEntity();
            juegoToFind = juegoFacade.find(id);
            juegoFacade.remove(juegoToFind);
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "ÉXITO:", "El juego se eliminó");
            FacesContext.getCurrentInstance().addMessage(null, message);
            juego.setId(null);
            juego.setNombre(null);
            juego.setDescripcion(null);
            juego.setLanzamiento(null);
            juego.setIdCategoria(null);
            juego.setIdPlataforma(null);
            juego.setFoto(null);
            return "";
        } catch (Exception e) {
            FacesMessage messageerror = new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR:", "El juego no puede ser eliminado");
            FacesContext.getCurrentInstance().addMessage(null, messageerror);
            return "";
        }
    }

    public int contarJuegos() {
        int cuenta = juegoFacade.count();
        return cuenta;
    }

    public List<JuegoEntity> getJuegos() {
        List<JuegoEntity> lista = juegoFacade.findAll();
        return lista;
    }

    public void obtenerJuego(int id) {
        this.juego = juegoFacade.find(id);
    }

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
    
    public List<CategoriaEntity> getCategoriasList(){
        return categoriaFacade.findAll();
    }
    
    public List<PlataformaEntity> getPlataformasList(){
        return plataformaFacade.findAll();
    }
}
