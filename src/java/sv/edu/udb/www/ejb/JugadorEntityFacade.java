/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.www.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import sv.edu.udb.www.entities.JugadorEntity;

/**
 *
 * @author Carlos Serrano
 */
@Stateless
public class JugadorEntityFacade extends AbstractFacade<JugadorEntity> {

    @PersistenceContext(unitName = "rteamprojectPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public JugadorEntityFacade() {
        super(JugadorEntity.class);
    }
    
}
