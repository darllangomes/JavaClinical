/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.guifx;

//import gui.guifx.TelaDoInicial; // TODO @author Danilo Araújo
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

    @FXML
    private Button btSair;

    @FXML
    private Label label2;

    @FXML
    private Button btLogin;

    @FXML
    private TextField TextId;

    @FXML
    private PasswordField SenhaField;

    @FXML
    void BotaoLogin(ActionEvent event) {
        LoginUsuario(event);
        
    }

    @FXML
    void BotaoSair(ActionEvent event) {

    }

    @FXML
    void LoginUsuario(ActionEvent event) {
        String carai = SenhaField.getText();
        String porra = TextId.getText();
        
        MainFx a = new MainFx();
        a.fazerLogin(porra, carai);
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    
}
