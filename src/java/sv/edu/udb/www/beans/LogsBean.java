package sv.edu.udb.www.beans;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import sv.edu.udb.www.ejb.LogsEntityFacade;
import sv.edu.udb.www.entities.LogsEntity;

@Named(value = "logBean")
@ManagedBean
@SessionScoped
public class LogsBean implements Serializable {

    @EJB
    private LogsEntityFacade logsFacade;

    private LogsEntity logs = new LogsEntity();

    public LogsBean() {
    }
    
    public int contarPlataformas() {
        int cuenta = logsFacade.count();
        return cuenta;
    }

    public List<LogsEntity> getPlataformas() {
        List<LogsEntity> lista = logsFacade.findAll();
        return lista;
    }


}
