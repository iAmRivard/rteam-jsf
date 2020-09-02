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
import sv.edu.udb.www.entities.EquipoEntity;

/**
 *
 * @author Carlos Serrano
 */
@Stateless
public class EquipoEntityFacade extends AbstractFacade<EquipoEntity> {

    @PersistenceContext(unitName = "rteamprojectPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EquipoEntityFacade() {
        super(EquipoEntity.class);
    }
    
      public EquipoEntity encontrarEquipocLogin(String nombreUsuario){
          
    Query q = em.createNamedQuery("EquipoEntity.findByCorreo",EquipoEntity.class).setParameter("correo", nombreUsuario);
    List<EquipoEntity> listado = q.getResultList();
    if(!listado.isEmpty()){
        return listado.get(0);
    }
        return null;
    
    
}
}
