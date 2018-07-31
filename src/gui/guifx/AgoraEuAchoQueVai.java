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
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author HENRIQUE.FELIX
 */
public class AgoraEuAchoQueVai extends Application{ 

    private static ArrayList<Scene> cenas = new ArrayList<Scene>();
    private static Stage stage;

  
    
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
        AgoraEuAchoQueVai.stage = stage;
    }
    
    

    @Override
    public void start(Stage stagePrimare) throws Exception{

        stage =  stagePrimare;
        criaCena("TelaDoZero.fxml");//0
        criaCena("FXMLTelaRecepcao.fxml");
        //criaCena("FXMLCadastraUsuarios.fxml");
        stage.setScene(cenas.get(0));
        stage.setTitle("JavaClinical");
        stage.show();
        setStage(stage);
    }  
    public static void main(String [] args){launch(args);}
    
}
