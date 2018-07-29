/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.guifx;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import negocio.Servidor;
import negocio.ControladorUsuario;
import dados.RepositorioUsuario;
import negocio.Login;
import negocio.IServidor;

/**
 *
 * @author HENRIQUE.FELIX
 */
public class TelaDoInicial extends Application {
    
    private static Stage stage;
    private static final ArrayList<Scene> cenas = new ArrayList<Scene>();
    
    
    @Override
    public void start(Stage stagePrimare) throws Exception {
        stage =  stagePrimare;
        criaCena("FXMLTelaInicial.fxml");//0
        //criaCena("FXMLTelaRecepcao.fxml");
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
    
    public void trocaCena(int i){
        stage.setScene(cenas.get(i));
    }
    
    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        TelaDoInicial.stage = stage;
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
