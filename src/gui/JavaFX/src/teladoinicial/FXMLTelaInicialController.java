/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teladoinicial;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author HENRIQUE.FELIX
 */
public class FXMLTelaInicialController implements Initializable {
    
    @FXML private Button btSair;
    @FXML private Label label2;
    @FXML private Label label1;
    @FXML private Button btLogin;
    @FXML private TextField TextSenha;
    @FXML private TextField TextFieldSenha;
    private Parent root;
    
    
    @FXML
    private void BotaoLogin(ActionEvent event) {
        System.out.println("Usuario entrando na tela de login...!");
        try {
            this.root = FXMLLoader.load(getClass().getResource("FXMLTelaDoLogin.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(FXMLTelaInicialController.class.getName()).log(Level.SEVERE, null, ex);
        }
                TelaDoInicial.getStage().setScene(new Scene(root));
    }
    
    @FXML
    private void BotaoSair(ActionEvent event) {
        System.out.println("Usuario fechou o programa...!");
        System.exit(0);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
