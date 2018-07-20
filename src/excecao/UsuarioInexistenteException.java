/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excecao;

/**
 *
 * @author Danilo de Araujo
 */
public class UsuarioInexistenteException extends Exception{
    // Exibe messagem de erro
    
    public UsuarioInexistenteException() {
    }
    @Override
    public String getMessage() {
        return "Usuario Inexistente";
    }
}
