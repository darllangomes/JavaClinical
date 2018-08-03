package javaclinical;

import excecao.UsuarioExisteException;
import excecao.UsuarioNullException;
import java.time.LocalDate;

import gui.TelaTextual;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import negocio.Medico;
import negocio.Paciente;
import negocio.Recepcionista;
import negocio.Usuario;

/*
 * TODO @author Danilo Araújo Descomentar tudo o que tem haver(português correto?)
 * com JavaFX para poder testar a GUI
 */
public class Main /*extends Application*/ {

    /*private static Stage stage;
    private static ArrayList<Scene> cenas = new ArrayList<Scene>();*/

    public static void main(String[] args) {
        
        
        TelaTextual tt = new TelaTextual(); // TODO Remover o bloco de comentários para testar em TelaTextual
        // Cria a tela
        while (tt.executando()) {
            tt.executarOperacoes();            
        }
        System.out.println("Terminando");
        //launch(args); // TODO Remover o comentario desta linha para testar o JavaFX
    }

    /*@Override
    public void start(Stage primaryStage) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
        stage =  primaryStage;
        criaCena("/TelaDoZero.fxml");
        //criaCena("../gui/guifx/FXMLTelaInicial.fxml");
        //criaCena("../gui/guifx/FXMLTelaRecepcao.fxml");
        //criaCena("FXMLCadastraUsuarios.fxml");
        stage.setScene(cenas.get(0));
        stage.setTitle("JavaClinical");
        stage.show();
        setStage(stage);
    }

    public void criaCena(String doc) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource(doc));
        Scene scene = new Scene(root);
        cenas.add(scene);
    }
    
    public static void trocaCena(int i){
        stage.setScene(cenas.get(i));
    }
    
    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        Main.stage = stage;
    }*/

}
