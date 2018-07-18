/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excecao;

/**
 *
 * @author henrique.felix
 */
public class LoginErradoException extends Exception{
    private  boolean erroId;
    private  boolean erroSenha;

    public LoginErradoException(boolean erroId, boolean erroSenha) {
        this.erroId = erroId;
        this.erroSenha = erroSenha;
    }

    public boolean isErroId() {
        return erroId;
    }

    public boolean isErroSenha() {
        return erroSenha;
    }
    
}
