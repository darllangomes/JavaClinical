/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.guifx;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import negocio.Consulta;
import negocio.Paciente;

/**
 * FXML Controller class
 *
 * @author DARLLAN.GOMES
 */
public class TelaConsultarController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private Label label0;

    @FXML
    private Label label1;

    @FXML
    private Button btProntuario;

    @FXML
    private Button btVoltar3;

    @FXML
    private TextArea queixaDoUsuario;
    
    @FXML
    private Button btRegistrar;

    @FXML
    private Button btLimpar;

    @FXML
    private TextField fieldId;


    @FXML
    void fazerProntuario(ActionEvent event) {
        Paciente p = MainFx.getServidor().procurarConsulta(fieldId.getText(), LocalDate.now()).getPaciente();
        queixaDoUsuario.setText(MainFx.getServidor().gerarProntuario(p.getId()));
    }
    
    @FXML
    void limparTexto(ActionEvent event) {
        queixaDoUsuario.setText("");
    }

    @FXML
    void registrarQueixa(ActionEvent event) {
        Consulta c = MainFx.getServidor().procurarConsulta(fieldId.getText(), LocalDate.now());
        c.getProntuario().setQueixaPaciente(queixaDoUsuario.getText());
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
