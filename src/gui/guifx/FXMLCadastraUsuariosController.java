/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.guifx;

//import gui.guifx.TelaDoInicial; // TODO @author Danilo Araújo
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author HENRIQUE.FELIX
 */




public class FXMLCadastraUsuariosController implements Initializable {

    /**
     * Initializes the controller class.
     */
    MainFx gui = new MainFx(); // TODO @author Danilo Araújo
    private Parent root;
    
    
    @FXML
    private Button btCadastrarRecp;
    
     @FXML
    private Button btVoltar;

    @FXML
    private Button btCadastrarMed;

    @FXML
    private Button btCadastroPac;

    @FXML
    private Label label2;

    @FXML
    void botaoCadastroMed(ActionEvent event) {
        this.gui.trocaCena(5);
    }

    @FXML
    void botaoCadastroPac(ActionEvent event) {
        this.gui.trocaCena(7);
    }

    @FXML
    void botaoRecp(ActionEvent event) {
        this.gui.trocaCena(6);
    }
    @FXML
    void botaoVoltar(ActionEvent event){
        MainFx.trocaCena(0);
    }
        
    
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
