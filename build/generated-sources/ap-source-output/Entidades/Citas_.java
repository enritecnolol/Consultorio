package Entidades;

import Entidades.Paciente;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-12-04T14:58:40")
@StaticMetamodel(Citas.class)
public class Citas_ { 

    public static volatile SingularAttribute<Citas, Integer> idCitas;
    public static volatile SingularAttribute<Citas, Date> fecha;
    public static volatile SingularAttribute<Citas, String> correo;
    public static volatile SingularAttribute<Citas, Paciente> idpacientep;

}