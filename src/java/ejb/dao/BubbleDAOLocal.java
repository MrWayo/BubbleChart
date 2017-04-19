/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.dao;

import entidades.Chart;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Wayo Sapiens
 */
@Local
public interface BubbleDAOLocal extends GenericoJPADAOLocal<Chart> {
    List<Chart> listaTodos(); 
    List<Chart> listaTodosIngresos(); 
}
