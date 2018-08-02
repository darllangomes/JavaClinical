/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.guifx;

import excecao.UsuarioNullException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ObservableListValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import negocio.Paciente;

/**
 * FXML Controller class
 *
 * @author HENRIQUE.FELIX
 */
public class TelaBuscarPacienteController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Button btVoltar;

    @FXML
    private Button btBuscar;

    @FXML
    private TextField filedIdPaci;

    @FXML
    private Label label1;

    @FXML
    private Label label2;
    
     @FXML
    private TextArea dadosPaciente;

    
    /*private TableView<Paciente> tabelaPaciente;
    
     @FXML
    private TableColumn<Paciente, String> colunaNomePaciente;

    @FXML
    private TableColumn<Paciente, Integer> colunaIdadePaciente;

    @FXML
    private TableColumn<Paciente, String> colunaCpfPaciente;*/


    @FXML
    void botaoBuscar(ActionEvent event) {
        //acessar o servidor
        String id = filedIdPaci.getText();
        System.out.println(id);
        try {
            Paciente p = MainFx.getServidor().procurarPaciente(id);
            dadosPaciente.setText(p.toString());
            /*p.setColumms();
            ObservableList<Paciente> lista = listaPaciente(p);
            if(lista == null) {
                System.out.println("Erro ao exibir tabela");
            } else {
                tabelaPaciente.setItems(lista);
            }*/
            
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
        //ver qual é a cena correta.
    }
    
    private ObservableList<Paciente> listaPaciente(Paciente p) {
        return FXCollections.observableArrayList(p);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        /*colunaNomePaciente.setCellValueFactory(new PropertyValueFactory<>("nomeColumm"));
        colunaIdadePaciente.setCellValueFactory(new PropertyValueFactory<>("idadeColumm"));
        colunaCpfPaciente.setCellValueFactory(new PropertyValueFactory<>("cpfColumm"));*/
    }

}
