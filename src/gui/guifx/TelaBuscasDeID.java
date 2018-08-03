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
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javax.xml.soap.Text;

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
    private Label idUsuarioLabel;

    @FXML
    void botaoBuscar(ActionEvent event) {

    }

    @FXML
    void botaoVoltar(ActionEvent event) {

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

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
