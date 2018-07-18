/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excecao;

/**
 *
 * @author daniloaraujo1990@hotmail.com
 */
public class UsuarioExisteException extends Exception{
    // Exceção vai alterar a tela de login
    private static final String msg = "Usuário já existe";
    public UsuarioExisteException() {
    }
    
    @Override
    public String getMessage() {
        return msg;
    }
}
