package Entidades;

import Entidades.Login;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-12-04T14:58:41")
@StaticMetamodel(RegistroUsuarios.class)
public class RegistroUsuarios_ { 

    public static volatile SingularAttribute<RegistroUsuarios, String> apellido;
    public static volatile SingularAttribute<RegistroUsuarios, String> usuario;
    public static volatile CollectionAttribute<RegistroUsuarios, Login> loginCollection;
    public static volatile SingularAttribute<RegistroUsuarios, String> telefono;
    public static volatile SingularAttribute<RegistroUsuarios, String> nombre;
    public static volatile SingularAttribute<RegistroUsuarios, String> especialidad;
    public static volatile SingularAttribute<RegistroUsuarios, Integer> idRegistrousuarios;
    public static volatile SingularAttribute<RegistroUsuarios, String> contraseña;

}