/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.com.udea.ejb;

import co.com.udea.modelo.Vehiculos;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Juane
 */
@Local
public interface VehiculosFacadeLocal {

    void create(Vehiculos vehiculos);

    void edit(Vehiculos vehiculos);

    void remove(Vehiculos vehiculos);

    Vehiculos find(Object id);

    List<Vehiculos> findAll();

    List<Vehiculos> findRange(int[] range);

    int count();
    
    List<Vehiculos> getAllVehiculos();
}
