/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author flow3
 */
public class Login {
    private String usuario;
    private String contraseña;
    private int Idlogin;

    public Login(String usuario, String contraseña) {
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.Idlogin = Idlogin;
    }


    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public int getIdlogin() {
        return Idlogin;
    }

    public void setIdlogin(int Idlogin) {
        this.Idlogin = Idlogin;
    }
    
    
}
