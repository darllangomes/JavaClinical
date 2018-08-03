/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.guifx;

//import gui.guifx.TelaDoInicial; // TODO @author Danilo Araújo
import excecao.UsuarioNullException;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import negocio.Consulta;
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
        try {
            LoginUsuario(event);
            switch (TextId.getText().charAt(0)) {
            case '1':
                MainFx.trocaCena(1);
                break;
            case '2':
                MainFx.trocaCena(4);// TODO @author Danilo Araújo trocaCena para médico
                break;
            default:
                MainFx.trocaCena(3);// TODO @author Danilo Araújo trocaCena para paciente
                break;
        }
            
        } catch (UsuarioNullException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro no Login");
            alert.setHeaderText("Informações inválidas.");
            alert.setContentText("Usuário ou senha fornecidas estão incorretas.");
            alert.showAndWait();
        }
    }

    @FXML
    void BotaoSair(ActionEvent event) throws IOException {
        MainFx.getServidor().salvarDados();
        System.exit(0); // @author Danilo Araújo Valor padrão para encerramento de um programa sem erro
    }

    @FXML
    void LoginUsuario(ActionEvent event) throws UsuarioNullException {
        String senha = SenhaField.getText();
        String id = TextId.getText();
        MainFx.fazerLogin(id, senha);
    }
    
    
    @FXML
    private Button btVoltar;

    @FXML
    private Button btExames;

    @FXML
    private Button btConsulta;

    @FXML
    void BotaoConsulta(ActionEvent event) {
        //MainFx.trocaCena(0);
    }

    @FXML
    void BotaoExame(ActionEvent event) {
            //MainFx.trocaCena(0);
    }

    @FXML
    void BotaoVoltar(ActionEvent event) {
        MainFx.trocaCena(0);
    }
    
     @FXML
    private Button btVoltar1;

    @FXML
    private Button btListar;

    @FXML
    private Button btProntuario;

    @FXML
    void BotaoListar(ActionEvent event) {
        ArrayList <Consulta> c = MainFx.getServidor().procurarConsulta(LocalDate.now());
        listaDeConsultas.setText(c.toString());
    }

    @FXML
    void BotaoProntuario(ActionEvent event) {
        //a tela ainda não foi criada
        //MainFx.trocaCena(0);
        //acessar o servidor
    }

    @FXML
    void BotaoVoltar1(ActionEvent event) {
        MainFx.trocaCena(0);
    }
    
    @FXML
    private Label label3;
    
    @FXML
    private TextArea listaDeConsultas;
    
    @FXML
    private Button btConsultar;

    @FXML
    void BotaoConsultar(ActionEvent event) {
        MainFx.trocaCena(14);
    }
    
    @FXML
    private Label label0;

    @FXML
    private TextField queixaDoUsuario;

    @FXML
    void fazerProntuario(ActionEvent event) {

    }

    @FXML
    void voltar(ActionEvent event) {
        MainFx.trocaCena(4);
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
