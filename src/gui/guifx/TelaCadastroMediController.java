/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.guifx;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author christian.lira
 */
public class TelaCadastroMediController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private TextField filedCpf;

    @FXML
    private TextField fieldIdade;

    @FXML
    private TextField filedNome;

    @FXML
    private Button btVoltar;

    @FXML
    private Button btCadastro;

    @FXML
    private PasswordField fieldSenha;

    @FXML
    private PasswordField fieldExpecialidade;

    @FXML
    private Label label1;

    @FXML
    private Label label2;

    @FXML
    private Label label3;

    @FXML
    private Label label4;

    @FXML
    private Label label5;

    @FXML
    private Label label6;

    @FXML
    private Label label7;

    @FXML
    void cadastrar(ActionEvent event) {
      //Acessar o Servidor
    }

    @FXML
    void voltar(ActionEvent event) {
           MainFx.trocaCena(2);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
