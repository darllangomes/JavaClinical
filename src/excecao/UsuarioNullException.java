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
public class UsuarioNullException extends Exception{

    public UsuarioNullException() {
    }
    
    public String getMessage() {
        return "Erro!\nA informação recebida está vazia!\nCaso este erro persistir, acione o suporte!";
    }
}
