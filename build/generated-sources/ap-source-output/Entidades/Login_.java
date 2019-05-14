package Entidades;

import Entidades.RegistroUsuarios;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-12-04T14:58:41")
@StaticMetamodel(Login.class)
public class Login_ { 

    public static volatile SingularAttribute<Login, Integer> idlogin;
    public static volatile SingularAttribute<Login, RegistroUsuarios> idr;
    public static volatile SingularAttribute<Login, String> usuario;
    public static volatile SingularAttribute<Login, String> contrasena;

}