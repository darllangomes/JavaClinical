/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.guifx;

import excecao.UsuarioNullException;
import java.net.URL;
import java.time.LocalDate;
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
import negocio.Exame;
import negocio.Id;
import negocio.Medico;
import negocio.Paciente;

/**
 * FXML Controller class
 *
 * @author HENRIQUE.FELIX
 */
public class TelaMarcarExameController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    
    @FXML
    private Button btVoltar;

    @FXML
    private Button btMarcar;

    @FXML
    private TextField fieldIdMed;

    @FXML
    private TextField fieldIdPaci;

    @FXML
    private TextField fieldDia;

    @FXML
    private TextField fieldMes;

    @FXML
    private TextField fieldAno;

    @FXML
    private Label textIdMed;

    @FXML
    private Label textIdPac;

    @FXML
    private Label textDataExa;

    @FXML
    private Label titulo;

    @FXML
    void botaoMarcar(ActionEvent event) {
        try {
            Medico m = MainFx.getServidor().procurarMedico(fieldIdMed.getText());
            Paciente p = MainFx.getServidor().procurarPaciente(fieldIdPaci.getText());
            LocalDate d = LocalDate.of(Integer.parseInt(fieldAno.getText()), Integer.parseInt(fieldMes.getText()), Integer.parseInt(fieldDia.getText()));
            
            Consulta c = new Consulta(d, m.getEspecialidade(), m, p, false, false, false);
            Exame e = new Exame (c, d);
            c.setId(Id.gerarId(5));
            MainFx.getServidor().marcarExame(e);
            System.out.println(c.toString()); //Depuração
            
        } catch (UsuarioNullException ex) {
            Logger.getLogger(TelaMarcarConsultaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void botaoVoltar(ActionEvent event) {
        MainFx.trocaCena(1);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
