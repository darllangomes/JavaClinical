/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.guifx;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import negocio.Servidor;
import negocio.ControladorUsuario;
import dados.RepositorioUsuario;
import excecao.UsuarioNullException;
import javaclinical.Main;
import negocio.Login;
import negocio.IServidor;
import negocio.Usuario;

/**
 *
 * @author HENRIQUE.FELIX
 */
public class FXMLTelaInicialController implements Initializable {
    
    @FXML
    private Button btSair;

    @FXML
    private Label label2;

    @FXML
    private Button btLogin;

    @FXML
    private TextField TextId;

    @FXML
    private PasswordField SenhaField;
    
    // TODO @author Danilo Araujo Comentar para usar Main principal
    TelaDoInicial gui = new TelaDoInicial();
    
    
    private Parent root;
    
    
    private void LoginUsuario(ActionEvent event) {
        Usuario u = null;
        String id = TextId.getText();
        System.out.println(id);
        if(id == null){
            
        }
        
        String senha = SenhaField.getText();
        System.out.println(senha);
        
        /*
         * Tentativa de pegar os dados do servidor
         * @author Danilo Araújo
         */
        /*Login l = new Login(id,senha.hashCode());
        switch (l.getId().charAt(0)) {
            case '1':
         {
             try {
                 u = Servidor.getInstance().efetuarLoginRecepcionista(l);
             } catch (UsuarioNullException ex) {
                 System.out.println(ex.getMessage());
             }
         }
                break;
            case '2':
         {
             try {
                 u = Servidor.getInstance().efetuarLoginMedico(l);
             } catch (UsuarioNullException ex) {
                 System.out.println(ex.getMessage());
             }
         }
                break;
            default:
         {
             try {
                 u = Servidor.getInstance().efetuarLoginPaciente(l);
             } catch (UsuarioNullException ex) {
                 System.out.println(ex.getMessage());
             }
         }
                break;
        }*/
       
    }
    
    private void BotaoLogin(ActionEvent event) {
        
        LoginUsuario(event);
        //TelaDoInicial.trocaCena(1);
        System.out.println("Usuario entrando na tela de login...!");
        // TODO @author Danilo Araujo Comentar para usar Main principal
        gui.trocaCena(1);
        
        // TODO @author Danilo Araujo Descomentar para usar Main principal
        //Main.trocaCena(1);
        /*try {
            this.root = FXMLLoader.load(getClass().getResource("../gui/guifx/FXMLTelaDoLogin.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(FXMLTelaInicialController.class.getName()).log(Level.SEVERE, null, ex);
        }*/
//                TelaDoInicial.getStage().setScene(new Scene(root));
    }
    
    private void BotaoSair(ActionEvent event) {
        System.out.println("Usuario fechou o programa...!");
        System.exit(0);
        
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void botaoCadastroUsu(ActionEvent event) {
    }
    
}
