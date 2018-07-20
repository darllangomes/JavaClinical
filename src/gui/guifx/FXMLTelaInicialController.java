/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.guifx;

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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 *
 * @author HENRIQUE.FELIX
 */
public class FXMLTelaInicialController implements Initializable {
    
    @FXML private Button btSair;
    @FXML private Label erroNoLogin;
    @FXML private Label label1;
    @FXML private Button btLogin;
    @FXML private TextField TextId;
    @FXML private PasswordField SenhaField;
    @FXML private Button btCadastroUsuario;
    @FXML private Button btMArcarExame;
    @FXML private Button btBuscarMedico;
    @FXML private Button btBuscaUsuario;
    @FXML private Button btRemoverUsuario;
    @FXML private Button btMarcarConsulta;
    @FXML private Button btVoltar;
    
    
    private Parent root;
    
    
    @FXML
    private void LoginUsuario(ActionEvent event) {
        String id = TextId.getText();
        System.out.println(id);
        
        String senha = SenhaField.getText();
        System.out.println(senha);
        
    }
    
    @FXML
    void BotaoLogin(ActionEvent event) {
        
        LoginUsuario(event);
        
        System.out.println("Usuario entrando na tela de login...!");
        try {
            this.root = FXMLLoader.load(getClass().getResource("FXMLTelaRecepcao.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(FXMLTelaRecepcaoController.class.getName()).log(Level.SEVERE, null, ex);
        }
                TelaDoInicial.getStage().setScene(new Scene(root));
    }
    
    @FXML
    void BotaoSair(ActionEvent event) {
        System.out.println("Usuario fechou o programa...!");
        System.exit(0);
        
    }
    
    @FXML
    private void BotaoVoltar(ActionEvent event) {
        System.out.println("Voltando para a tela inicial...");
        try {
            this.root = FXMLLoader.load(getClass().getResource("FXMLTelaInicial.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(FXMLTelaInicialController.class.getName()).log(Level.SEVERE, null, ex);
        }
                TelaDoInicial.getStage().setScene(new Scene(root));
    }
    
    
 
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
