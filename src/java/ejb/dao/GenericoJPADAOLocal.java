/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.dao;

import javax.ejb.Local;

/**
 *
 * @author Wayo Sapiens
 */
@Local
public interface GenericoJPADAOLocal<T> {
    T crear(T entidad);
    T actualizar(T entidad);
    void eliminar(T entidad);
    T buscarPorId(Object id); 
}
