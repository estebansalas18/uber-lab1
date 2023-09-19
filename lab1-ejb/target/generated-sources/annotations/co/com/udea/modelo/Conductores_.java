package co.com.udea.modelo;

import co.com.udea.modelo.Vehiculos;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-09-16T13:57:39")
@StaticMetamodel(Conductores.class)
public class Conductores_ { 

    public static volatile SingularAttribute<Conductores, String> licencia;
    public static volatile SingularAttribute<Conductores, Date> fechaNacimiento;
    public static volatile SingularAttribute<Conductores, Integer> cedula;
    public static volatile SingularAttribute<Conductores, String> nombre;
    public static volatile SingularAttribute<Conductores, Vehiculos> placa;

}