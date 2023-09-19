/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.com.udea.ejb;

import co.com.udea.modelo.Conductores;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Juane
 */
@Local
public interface ConductoresFacadeLocal {

    void create(Conductores conductores);

    void edit(Conductores conductores);

    void remove(Conductores conductores);

    Conductores find(Object id);

    List<Conductores> findAll();

    List<Conductores> findRange(int[] range);

    int count();
    
    List<Conductores> getAllConductores();
}
