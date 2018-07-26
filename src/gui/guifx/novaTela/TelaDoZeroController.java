/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.guifx.novaTela;

import gui.guifx.TelaDoInicial;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import negocio.Usuario;

/**
 * FXML Controller class
 *
 * @author Darllan Gomes
 */
public class TelaDoZeroController implements Initializable {

    /**
     * Initializes the controller class.
     */

    TelaDoInicial gui = new TelaDoInicial();
    
    
    private Parent root;
    

    private TextField TextId;

    private PasswordField SenhaField;

    void BotaoLogin(ActionEvent event) {
        Usuario u = null;
        String id = TextId.getText();
        System.out.println(id);
        if(id == null){
            
        }
        
        String senha = SenhaField.getText();
        System.out.println(senha);
    }

    void BotaoSair(ActionEvent event) {
        System.out.println("Usuario fechou o programa...!");
        System.exit(0);
    }

    void LoginUsuario(ActionEvent event) {

        //TelaDoInicial.trocaCena(1);
        System.out.println("Usuario entrando na tela de login...!");
        // TODO @author Danilo Araujo Comentar para usar Main principal
        gui.trocaCena(1);
    }
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    
}
