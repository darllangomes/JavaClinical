/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.guifx;

import excecao.UsuarioNullException;
import gui.guifx.MainFx;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javax.xml.soap.Text;
import negocio.Medico;
import negocio.Paciente;
import dados.RepositorioUsuario;
import negocio.ControladorUsuario;
import negocio.IServidor;
import negocio.Id;
import negocio.Servidor;

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
    private TextArea dadosMedico;


    @FXML
    private Button btBuscar;

    @FXML
    private Label titulo;

    @FXML
    private Label textIdMed;

    @FXML
    private TextField filedIdMed;

    @FXML
    void botaoBuscar(ActionEvent event) {
           //MainFx.trocaCena(0);
           // criar tela de busca
            String id = filedIdMed.getText();
        System.out.println(id);
        try {
            Medico m = MainFx.getServidor().procurarMedico(id);
            dadosMedico.setText(m.toString());
           
            
        } catch (UsuarioNullException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro ao buscar paciente");
            alert.setHeaderText("Informações inválidas.");
            alert.setContentText(ex.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    void botaoVoltar(ActionEvent event) {
       MainFx.trocaCena(1);
    }

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
