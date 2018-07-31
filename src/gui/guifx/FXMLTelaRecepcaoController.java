/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.guifx;

//import gui.guifx.TelaDoInicial; // TODO @author Danilo Araújo
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

/**
 * FXML Controller class
 *
 * @author HENRIQUE.FELIX
 */
public class FXMLTelaRecepcaoController implements Initializable {
    AgoraEuAchoQueVai gui = new AgoraEuAchoQueVai();
    /**
     * Initializes the controller class.
     */
   

    @FXML
    private Button btCadastroUsuario;

    @FXML
    private Button btMArcarExame;

    @FXML
    private Button btBuscarMedico;

    @FXML
    private Button btBuscaUsuario;

    @FXML
    private Button btRemoverUsuario;

    @FXML
    private Button btMarcarConsulta;

    @FXML
    private Button btVoltar;

    @FXML
    private Label label1;

    @FXML
    void BotaoVoltar(ActionEvent event) {

    }

    @FXML
    void botaoCadastroUsu(ActionEvent event) {

    }
 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}