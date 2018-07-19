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
public class ConsultaInexistenteException extends Exception{

    public ConsultaInexistenteException() {
    }
    
    @Override
    public String getMessage() {
        return "Consulta não marcada";
    }
}
