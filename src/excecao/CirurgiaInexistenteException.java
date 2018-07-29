/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excecao;

/**
 *
 * @author Darllan Gomes
 */
public class CirurgiaInexistenteException extends Exception {
    
    public CirurgiaInexistenteException(){
        
    }
    
    @Override
    public String getMessage() {
        return "Cirurgia não marcada";
    }
}
