/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.dao;

import entidades.Chart;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author Wayo Sapiens
 */
@Stateless
public class BubbleDAO extends GenericoJPADAO<Chart> implements BubbleDAOLocal {

    @Override
    public List<Chart> listaTodos() {
        List<Chart> lista=null;
        Query q = em.createQuery("SELECT object(u) FROM Chart as u");
        System.out.println("Ver query: "+q.toString());
        lista=  q.getResultList();
        return lista;
    }

    @Override
    public List<Chart> listaTodosIngresos() {
        List<Chart> lista=null;
        Query q = em.createQuery("SELECT u.ingresos FROM Chart as u");
        System.out.println("Ver query: "+q.toString());
        lista=  q.getResultList();
        return lista;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
}
