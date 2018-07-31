/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.guifx.novaTela;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javax.xml.soap.Text;

/**
 * FXML Controller class
 *
 * @author HENRIQUE.FELIX
 */
public class TelaCadastroRecpController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private Text titulo;

    @FXML
    private Text textRecp;

    @FXML
    private Text textCpf;

    @FXML
    private TextField filedCpf;

    @FXML
    private Text textIdade;

    @FXML
    private TextField fieldIdade;

    @FXML
    private Text textSenha;

    @FXML
    private Text textNome;

    @FXML
    private TextField filedNome;

    @FXML
    private Button btVoltar;

    @FXML
    private Button btCadastro;

    @FXML
    private PasswordField fieldSenha;

    @FXML
    void cadastrar(ActionEvent event) {

    }

    @FXML
    void voltar(ActionEvent event) {

    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
