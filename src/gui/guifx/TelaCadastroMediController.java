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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import negocio.Medico;
import excecao.UsuarioNullException;
import negocio.Id;
import negocio.ControladorUsuario;
import dados.RepositorioUsuario;
import negocio.Usuario;
import negocio.Servidor;

/**
 * FXML Controller class
 *
 * @author christian.lira
 */
public class TelaCadastroMediController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private TextField fieldCpf;

    @FXML
    private TextField fieldIdade;

    @FXML
    private TextField fieldNome;

    @FXML
    private Button btVoltar;
    
     @FXML
    private TextField fieldID;

    @FXML
    private Button btCadastro;

    @FXML
    private PasswordField fieldSenha;

    @FXML
    private TextField fieldEspecialidade;

    @FXML
    private Label label1;

    @FXML
    private Label label2;

    @FXML
    private Label label3;

    @FXML
    private Label label4;

    @FXML
    private Label label5;

    @FXML
    private Label label6;

    @FXML
    private Label label7;
    @FXML
    private Label labelId;

    
    @FXML
    private PasswordField fieldId;

    @FXML
    void cadastrar(ActionEvent event) throws UsuarioNullException, UsuarioExisteException {
      //Acessar o Servidor
       Medico m= new Medico();
        //String nome = filedNome.getText();
       //String cpf = filedCpf.getText();
       //String especialidade= fieldExpecialidade.getText();
       int senha =  fieldSenha.getText().hashCode();
       //int senhaInt=Integer.parseInt(fieldSenha.getText());
          // m = MainFx.getServidor().procurarMedico(m.getId());
            m.setEspecialidade(fieldEspecialidade.getText());
            m.setId(Id.gerarId(2));
            m.setNome(fieldNome.getText());
            m.setCpf(fieldCpf.getText());
            m.setSenhaHash(fieldSenha.getText().hashCode());
            labelId.setText(m.getId());
       
      try{
            //m.setSenhaHash(senhaInt);
            MainFx.getServidor().cadastrarUsuario(m);
            System.out.println(m.getId());
            
            //MainFx.trocaCena(1);
             
      }catch(UsuarioNullException ex){
         // m = MainFx.getServidor().cadastrarUsuario(m);
          Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro: O médico já existe");
            alert.setHeaderText("Tente Novamente.");
            alert.setContentText(ex.getMessage());
            alert.showAndWait();
      }
          
          
    }

    @FXML
    void voltar(ActionEvent event) {
           MainFx.trocaCena(1);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
