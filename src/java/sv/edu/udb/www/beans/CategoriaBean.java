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
import sv.edu.udb.www.ejb.CategoriaEntityFacade;
import sv.edu.udb.www.entities.CategoriaEntity;

@Named(value = "categoriaBean")
@ManagedBean
@SessionScoped
public class CategoriaBean implements Serializable {

    private static Logger logger = Logger.getLogger(CategoriaBean.class);

    @EJB
    private CategoriaEntityFacade categoriaFacade;

    private CategoriaEntity categoria = new CategoriaEntity();

    public CategoriaBean() {
    }

    public String agregarCategoria() {
        try {

            categoriaFacade.create(this.categoria);
            logger.info("Se ha registrado una nueva categoia ");
            FacesMessage messagesuccess = new FacesMessage(FacesMessage.SEVERITY_INFO, "ÉXITO:", "Se ha registrado la categoría");
            FacesContext.getCurrentInstance().addMessage(null, messagesuccess);
            categoria.setNombre(null);
            categoria.setDescripcion(null);
            categoria.setId(null);

            return "";
        } catch (Exception e) {
            FacesMessage messageerror = new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR:", "La categoría ya existe");
            FacesContext.getCurrentInstance().addMessage(null, messageerror);
            logger.warn("La categoría ya existe ");
            return "";
        }
    }

    public String modificarCategoria() {
        try {
         
            categoriaFacade.edit(this.categoria);
            logger.info("Se ha actualizado la cateogira:" + this.categoria.getNombre());
            FacesMessage messagesuccess = new FacesMessage(FacesMessage.SEVERITY_INFO, "ÉXITO:", "Se ha modificado la categoría");
            FacesContext.getCurrentInstance().addMessage(null, messagesuccess);
            categoria.setNombre(null);
            categoria.setDescripcion(null);
            categoria.setId(null);
            return "";
        } catch (Exception e) {
            FacesMessage messageerror = new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR:", "La categoría no puede ser modificada");
            FacesContext.getCurrentInstance().addMessage(null, messageerror);
            logger.warn("La categoria "+ this.categoria.getNombre() +" no puede ser modificada");

            return "";
        }
    }

    public String eliminarCategoria(int id) {
        try {
            CategoriaEntity categoriaToFind = new CategoriaEntity();
            categoriaToFind = categoriaFacade.find(id);
            categoriaFacade.remove(categoriaToFind);
            logger.info("Se ha eliminado una categoria");
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "ÉXITO:", "La categoría se eliminó");
            FacesContext.getCurrentInstance().addMessage(null, message);
            categoria.setNombre(null);
            categoria.setDescripcion(null);
            categoria.setId(null);
            return "";
        } catch (Exception e) {
            FacesMessage messageerror = new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR:", "La categoría no puede ser eliminada");
            FacesContext.getCurrentInstance().addMessage(null, messageerror);
            logger.warn("La categoria "+ this.categoria.getNombre() +" no puede ser eliminada");
            return "";
        }
    }

    public int contarCategorias() {
        int cuenta = categoriaFacade.count();
        return cuenta;
    }

    public List<CategoriaEntity> getCategorias() {
        List<CategoriaEntity> lista = categoriaFacade.findAll();
        return lista;
    }

    public void obtenerCategoria(int id) {
        this.categoria = categoriaFacade.find(id);
    }

    /**
     * @return the categoria
     */
    public CategoriaEntity getCategoria() {
        return categoria;
    }

    /**
     * @param categoria the categoria to set
     */
    public void setCategoria(CategoriaEntity categoria) {
        this.categoria = categoria;
    }

}
