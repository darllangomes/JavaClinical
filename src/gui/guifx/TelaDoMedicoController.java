/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.guifx;

import java.time.LocalDate;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import negocio.Consulta;

/**
 *
 * @author DARLLAN.GOMES
 */
public class TelaDoMedicoController {

    @FXML
    private Button btVoltar1;

    @FXML
    private Button btListar;

    @FXML
    private Label label3;

    @FXML
    private TextArea listaDeConsultas;

    @FXML
    private Button btConsultar;

    @FXML
    void BotaoConsultar(ActionEvent event) {
        MainFx.trocaCena(14);
    }

    @FXML
    void BotaoListar(ActionEvent event) {
        ArrayList<Consulta> lista = MainFx.getServidor().procurarConsulta(LocalDate.now());
        listaDeConsultas.setText(lista.toString());
    }

    @FXML
    void BotaoVoltar1(ActionEvent event) {
        MainFx.trocaCena(1);
    }

}
