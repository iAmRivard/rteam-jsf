/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.www.beans;

import java.io.IOException;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import sv.edu.udb.www.entities.UsuarioEntity;

/**
 *
 * @author LENOVO
 */
@Named(value = "sesion")
@SessionScoped
public class SesionController implements Serializable {

    FacesContext faces = FacesContext.getCurrentInstance();

    public String verificarSesion() {
        try {
            UsuarioEntity usuario = (UsuarioEntity) faces.getExternalContext().getSessionMap().get("usuario");


            if (usuario != null) {
                faces.getExternalContext().redirect("../login.xhtml");
            }
            
        } catch (Exception e) {
            System.out.println("Error:" + e);
        }
        return null;
    }

    public void verificarAdmin() {
        try {
            UsuarioEntity usAdmin = (UsuarioEntity) faces.getExternalContext().getSessionMap().get("administrador");

            if (usAdmin == null) {
                faces.getExternalContext().redirect("../denegado.xhtml");
            }

        } catch (IOException e) {
            System.out.println("Error:" + e);

        }

    }

    public void verificarJugador() {
        try {
            UsuarioEntity usJugador = (UsuarioEntity) faces.getExternalContext().getSessionMap().get("jugador");

            if (usJugador == null) {
                faces.getExternalContext().redirect("../denegado.xhtml");
            }

        } catch (IOException e) {
            System.out.println("Error:" + e);

        }

    }


    public String redirectIndex() {
        return "inicio";
    }

    public String redirectLogin() {
        return "login";
    }
    
    public void cerrarSesion(){
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
    }

}
