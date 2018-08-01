/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.guifx;

//import gui.guifx.TelaDoInicial; // TODO @author Danilo Araújo
import excecao.UsuarioNullException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
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

    //MainFx gui = new MainFx();

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
        try {
            LoginUsuario(event);
            MainFx.trocaCena(1);
        } catch (UsuarioNullException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro no Login");
            alert.setHeaderText("Informações inválidas.");
            alert.setContentText("Usuário ou senha fornecidas estão incorretas.");
            alert.showAndWait();
        }
    }

    @FXML
    void BotaoSair(ActionEvent event) {
        System.exit(1);
    }

    @FXML
    void LoginUsuario(ActionEvent event) throws UsuarioNullException {
        String senha = SenhaField.getText();
        String id = TextId.getText();

        //MainFx a = new MainFx();
        MainFx.fazerLogin(id, senha);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
