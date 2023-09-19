/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.udea.ejb;

import co.com.udea.modelo.Conductores;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Juane
 */
@Stateless
public class ConductoresFacade extends AbstractFacade<Conductores> implements ConductoresFacadeLocal {

    @PersistenceContext(unitName = "com.udea_lab1-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ConductoresFacade() {
        super(Conductores.class);
    }
    
    @Override
    public List<Conductores> getAllConductores() {
        Query query = em.createNamedQuery("Conductores.findAll");
        return query.getResultList();
    }
}
