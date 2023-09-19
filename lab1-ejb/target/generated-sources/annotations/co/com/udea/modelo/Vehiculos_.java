package co.com.udea.modelo;

import co.com.udea.modelo.Conductores;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-09-16T13:57:39")
@StaticMetamodel(Vehiculos.class)
public class Vehiculos_ { 

    public static volatile SingularAttribute<Vehiculos, String> marca;
    public static volatile SingularAttribute<Vehiculos, Date> anioFabricacion;
    public static volatile SingularAttribute<Vehiculos, String> color;
    public static volatile CollectionAttribute<Vehiculos, Conductores> conductoresCollection;
    public static volatile SingularAttribute<Vehiculos, String> modelo;
    public static volatile SingularAttribute<Vehiculos, String> capacidadPasajeros;
    public static volatile SingularAttribute<Vehiculos, String> placa;

}