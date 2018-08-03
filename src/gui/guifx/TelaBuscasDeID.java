/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.guifx;

import excecao.UsuarioExisteException;
import excecao.UsuarioNullException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javax.xml.soap.Text;
import negocio.Paciente;

/**
 * FXML Controller class
 *
 * @author HENRIQUE.FELIX
 */
public class TelaBuscasDeID implements Initializable {

    /**
     * Initializes the controller class.
     */
    
     @FXML
    private Button btVoltar;

    @FXML
    private Button btBuscar;

    @FXML
    private TextField fieldIdMed;

    @FXML
    private Label titulo;
    
    @FXML
    private TextArea fieldInf;

    @FXML
    private Label idUsuarioLabel;

    @FXML
    private Button btRemover;

    @FXML
    void botaoBuscar(ActionEvent event) {
        try {
            
            Paciente p=MainFx.getServidor().procurarPaciente(fieldIdMed.getText());
            //MainFx.trocaCena(0);
            fieldInf.setText(p.toString());
        } catch (UsuarioNullException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERRO: Paciente não encontrado");
            alert.setHeaderText("Id incorreto");
            alert.setContentText("tente novamente.");
            alert.showAndWait();
        }
    }

    @FXML
    void botaoVoltar(ActionEvent event) {
        MainFx.trocaCena(1);
    }
    @FXML
    void botaoRemover(ActionEvent event) {
         try {
             MainFx.getServidor().descadastrarUsuario(fieldIdMed.getText());
         } catch (UsuarioNullException ex) {
          Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERRO: Paciente não foi removido");
            alert.setHeaderText("Erro desconhecido");
            alert.setContentText("contate o suporte.");
            alert.showAndWait();   
         }
    }
    
    
    
    @FXML
    private Button btVoltar1;

    @FXML
    private Label label1;

    @FXML
    private TextArea exames;

    @FXML
    void botaoVoltar1(ActionEvent event) {

    }
    
    
     @FXML
    private Button btVoltar0;

    @FXML
    private Label label2;

    @FXML
    private TextArea consultas;

    @FXML
    void botaoVoltar0(ActionEvent event) {

    }
    
    @FXML
    private Label label0;

    @FXML
    private Label label;

    @FXML
    private Button btProntuario;

    @FXML
    private Button btVoltar3;

    @FXML
    private TextArea queixaDoUsuario;

    @FXML
    void fazerProntuario(ActionEvent event) {

    }

    @FXML
    void voltar(ActionEvent event) {

    }

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
//        consultas.setText("");
   }    
    
}
