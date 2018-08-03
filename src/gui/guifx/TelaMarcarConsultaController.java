/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.guifx;

import excecao.UsuarioNullException;
import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javax.xml.soap.Text;
import negocio.Consulta;
import negocio.Id;
import negocio.Medico;
import negocio.Paciente;
import negocio.Prontuario;

/**
 * FXML Controller class
 *
 * @author HENRIQUE.FELIX
 */
public class TelaMarcarConsultaController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private Button btVoltar;

    @FXML
    private Button btMarcar;

    @FXML
    private Label titulo;

    @FXML
    private Label textIdMed;

    @FXML
    private TextField fieldIdMed;

    @FXML
    private Label textIdPac;

    @FXML
    private TextField fieldIdPaci;

    @FXML
    private Label textDataCon;

    @FXML
    private TextField fieldDia;

    @FXML
    private TextField fieldMes;

    @FXML
    private TextField fieldAno;

    @FXML
    void botaoMarcar(ActionEvent event) {
        try {
            Medico m = MainFx.getServidor().procurarMedico(fieldIdMed.getText());
            Paciente p = MainFx.getServidor().procurarPaciente(fieldIdPaci.getText());
            LocalDate d = LocalDate.of(Integer.parseInt(fieldAno.getText()), Integer.parseInt(fieldMes.getText()), Integer.parseInt(fieldDia.getText()));
            Consulta c = new Consulta(d, m.getEspecialidade(), m, p, false, false, false);
            c.setId(Id.gerarId(4));
            c.setProntuario(new Prontuario());
            MainFx.getServidor().cadastrarConsulta(c);
            System.out.println(c.toString()); //Depuração
            
        } catch (UsuarioNullException ex) {
            Logger.getLogger(TelaMarcarConsultaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void botaoVoltar(ActionEvent event) {
        MainFx.trocaCena(1);
        //ver qual é a cena certa
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
