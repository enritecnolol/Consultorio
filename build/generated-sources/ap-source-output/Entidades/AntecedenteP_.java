package Entidades;

import Entidades.Paciente;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-12-04T14:58:41")
@StaticMetamodel(AntecedenteP.class)
public class AntecedenteP_ { 

    public static volatile SingularAttribute<AntecedenteP, Integer> idAntcp;
    public static volatile SingularAttribute<AntecedenteP, Paciente> idAntecedentep;
    public static volatile SingularAttribute<AntecedenteP, String> diagnostico;
    public static volatile SingularAttribute<AntecedenteP, String> sintomas;
    public static volatile SingularAttribute<AntecedenteP, String> indicacion;

}