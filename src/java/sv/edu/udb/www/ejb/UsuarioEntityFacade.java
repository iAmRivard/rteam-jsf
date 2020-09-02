/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.www.ejb;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import sv.edu.udb.www.entities.UsuarioEntity;

/**
 *
 * @author Carlos Serrano
 */
@Stateless
public class UsuarioEntityFacade extends AbstractFacade<UsuarioEntity> {

    @PersistenceContext(unitName = "rteamprojectPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioEntityFacade() {
        super(UsuarioEntity.class);
    }
       public UsuarioEntity encontrarUsuariocLogin(String nombreUsuario){
    Query q = em.createNamedQuery("UsuarioEntity.findByCorreo",UsuarioEntity.class).setParameter("correo", nombreUsuario);
    List<UsuarioEntity> listado = q.getResultList();
    if(!listado.isEmpty()){
        return listado.get(0);
    }
    return null;
    }
}
