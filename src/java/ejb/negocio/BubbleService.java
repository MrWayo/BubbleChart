/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.negocio;

import ejb.dao.BubbleDAOLocal;
import entidades.Chart;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Wayo Sapiens
 */
@Stateless
public class BubbleService implements BubbleServiceLocal {
    @EJB
    BubbleDAOLocal bubbleDAO;
    @Override
    public List<Chart> listadoChart() {
        return bubbleDAO.listaTodos();
    }
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public List<Chart> listadoIngresos() {
        return bubbleDAO.listaTodosIngresos();
    }

    @Override
    public Chart buscarSeleccionado(Integer id) {
       Chart chart= bubbleDAO.buscarPorId(id);
         return chart; //To change body of generated methods, choose Tools | Templates.
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
