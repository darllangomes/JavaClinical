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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import negocio.ControladorUsuario;
import negocio.Servidor;
import negocio.IServidor;
import negocio.GetInformation;
import negocio.Usuario;
import dados.RepositorioUsuario;
import excecao.UsuarioExisteException;
import excecao.UsuarioNullException;
import javafx.scene.control.Alert;
import negocio.Id;
import negocio.Medico;
import negocio.Paciente;

/**
 * FXML Controller class
 *
 * @author HENRIQUE.FELIX
 */
public class TelaCadastroUsuController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private TextField filedCpf;
    
      @FXML
    private Label fieldId;


    @FXML
    private TextField fieldIdade;
   


    @FXML
    private TextField fieldNome;

    @FXML
    private Button btVoltar;

    @FXML
    private Button btCadastro;

    @FXML
    private PasswordField fieldSenha;

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
    private Label labelId;

    @FXML
    void cadastrar(ActionEvent event) throws UsuarioExisteException {
         Paciente p= new Paciente();
        //String nome = filedNome.getText();
       //String cpf = filedCpf.getText();
       //String especialidade= fieldExpecialidade.getText();
       int senha =  fieldSenha.getText().hashCode();
        

       //int senhaInt=Integer.parseInt(fieldSenha.getText());
          // m = MainFx.getServidor().procurarMedico(m.getId());
            int idade= Integer.parseInt(fieldIdade.getText());
            p.setId(Id.gerarId(3));
            p.setNome(fieldNome.getText());
            p.setIdade(idade);
            p.setCpf(filedCpf.getText());
            p.setSenhaHash(fieldSenha.getText().hashCode());
            fieldId.setText(p.getId());
       
      try{
            //m.setSenhaHash(senhaInt);
            MainFx.getServidor().cadastrarUsuario(p);
            System.out.println(p.getId());
            
            //MainFx.trocaCena(1);
             
      }catch(UsuarioNullException ex){
         // m = MainFx.getServidor().cadastrarUsuario(m);
          Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro: O médico já existe");
            alert.setHeaderText("Tente Novamente.");
            alert.setContentText(ex.getMessage());
            alert.showAndWait();
      }
          
        
      //MainFx.trocaCena(1);
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
