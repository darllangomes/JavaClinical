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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import negocio.ControladorUsuario;
import negocio.Id;
import negocio.Servidor;
import negocio.IServidor;
import negocio.Medico;
import negocio.Recepcionista;
/**
 * FXML Controller class
 *
 * @author HENRIQUE.FELIX
 */
public class TelaCadastroRecpController implements Initializable {

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
    private TextField fieldId;

    @FXML
    private Label label51;


    @FXML
    void cadastrar(ActionEvent event) {
      //Acessar o servidor
      Recepcionista r = new Recepcionista();
      
      r.setNome(fieldNome.getText());
      r.setCpf(fieldCpf.getText());
      r.setIdade(Integer.parseInt(fieldIdade.getText()));
      r.setSenhaHash(fieldSenha.getText().hashCode());
      r.setId(Id.gerarId(1));
      fieldId.setText(r.getId());
        System.out.println(r);
        try {
            MainFx.getServidor().cadastrarUsuario(r);
        } catch (UsuarioExisteException ex) {
            Logger.getLogger(TelaCadastroRecpController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UsuarioNullException ex) {
            Logger.getLogger(TelaCadastroRecpController.class.getName()).log(Level.SEVERE, null, ex);
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
