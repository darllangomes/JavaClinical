/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.guifx.novaTela;

import gui.guifx.TelaDoInicial;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javax.xml.soap.Text;

/**
 * FXML Controller class
 *
 * @author HENRIQUE.FELIX
 */




public class FXMLCadastraUsuariosController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    TelaDoInicial gui = new TelaDoInicial();
    private Parent root;
    
    
     @FXML
    private Button btCadastrarRecp;

    @FXML
    private Button btCadastrarMed;

    @FXML
    private Button btCadastroPac;

    @FXML
    private Text titulo;

    @FXML
    void botaoCadastroMed(ActionEvent event) {

    }

    @FXML
    void botaoCadastroPac(ActionEvent event) {

    }

    @FXML
    void botaoRecp(ActionEvent event) {

    }
    
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
