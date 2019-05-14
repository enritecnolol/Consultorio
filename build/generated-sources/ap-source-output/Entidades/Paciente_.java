package Entidades;

import Entidades.AntecedenteP;
import Entidades.Citas;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-12-04T14:58:40")
@StaticMetamodel(Paciente.class)
public class Paciente_ { 

    public static volatile SingularAttribute<Paciente, String> nombrep;
    public static volatile SingularAttribute<Paciente, String> enfermedad;
    public static volatile SingularAttribute<Paciente, String> direccion;
    public static volatile SingularAttribute<Paciente, String> estadoCivil;
    public static volatile SingularAttribute<Paciente, Integer> idpaciente;
    public static volatile SingularAttribute<Paciente, Integer> edad;
    public static volatile SingularAttribute<Paciente, String> medicamentos;
    public static volatile SingularAttribute<Paciente, String> alergias;
    public static volatile SingularAttribute<Paciente, String> antecedenteop;
    public static volatile SingularAttribute<Paciente, String> apellido;
    public static volatile SingularAttribute<Paciente, Date> fechanac;
    public static volatile CollectionAttribute<Paciente, Citas> citasCollection;
    public static volatile SingularAttribute<Paciente, String> telefono;
    public static volatile CollectionAttribute<Paciente, AntecedenteP> antecedentePCollection;

}