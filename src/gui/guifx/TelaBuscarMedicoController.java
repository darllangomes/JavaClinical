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
import javafx.scene.control.TextField;
import javax.xml.soap.Text;

/**
 * FXML Controller class
 *
 * @author HENRIQUE.FELIX
 */
public class TelaBuscarMedicoController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private Button btVoltar;

    @FXML
    private Button btBuscar;

    @FXML
    private Text titulo;

    @FXML
    private Text textIdPac;

    @FXML
    private TextField filedIdPaci;

    @FXML
    void botaoBuscar(ActionEvent event) {

    }

    @FXML
    void botaoVoltar(ActionEvent event) {

    }

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
