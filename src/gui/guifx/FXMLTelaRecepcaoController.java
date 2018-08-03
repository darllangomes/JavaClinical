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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author HENRIQUE.FELIX
 */
public class FXMLTelaRecepcaoController implements Initializable {
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
        MainFx.trocaCena(0);
    }

    @FXML
    void botaoCadastroUsu(ActionEvent event) {
        MainFx.trocaCena(2);
    }
    
    @FXML
    void buscarUsuario(ActionEvent event) {
        MainFx.trocaCena(9);
    }
    
    @FXML
    void buscarMedico(ActionEvent event) {
        MainFx.trocaCena(10);
    }
    
    @FXML
    void marcarExame(ActionEvent even){
        MainFx.trocaCena(12);
    }
 
    @FXML
    private Label label0;

    @FXML
    private Label label2;

    @FXML
    private Button btProntuario;

    @FXML
    private Button btVoltar1;

    @FXML
    private TextField queixaDoUsuario;
    
    


    @FXML
    void fazerProntuario(ActionEvent event) {

    }
    
    @FXML
    void marcarConsulta(ActionEvent event) {
        MainFx.trocaCena(11);
    }
    
    @FXML
    void btMArcarExame(ActionEvent event) {
        MainFx.trocaCena(11);
    }
    @FXML
    void btRemoverUsuario(ActionEvent event){
        MainFx.trocaCena(13);
    }
        
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   

    @FXML
    void voltar(ActionEvent event) {

    }

    
}