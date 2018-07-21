package javaclinical;
import excecao.UsuarioExisteException;
import excecao.UsuarioNullException;
import  java.time.LocalDate;

import gui.TelaTextual;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.FileNotFoundException;
import  java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import negocio.Medico;
import negocio.Paciente;
import negocio.Recepcionista;
import negocio.Usuario;

public class Main extends Application {

    private static Stage stage;

    public static void main(String[] args) {
        Usuario u = null;

        TelaTextual tt = new TelaTextual(); // TODO Remover o bloco de comentários para testar em TelaTextual
        // Cria a tela
        while (tt.executando()) {
            // TODO Isto vai ficar dentro de um método depois
            switch (tt.getOpcao()) {
                case -1: // Menu inicial
                    tt.exibirMenuInicial(); // Exibindo o menu da recep��o s� para teste
                    tt.lerOpcao();
                    switch (tt.getOpcao()) {
                        case 1:
                            do {
                                try {
                                    u = tt.efetuarLogin();
                                } catch (UsuarioNullException e) {
                                    System.out.println(e.getMessage());
                                }
                                if (u instanceof Recepcionista) {
                                    do {
                                        tt.exibeMenuRecepcionista();
                                        tt.lerOpcao();
                                        switch (tt.getOpcao()) {
                                            case 1: {
                                                try {
                                                    tt.cadastrar();
                                                } catch (UsuarioExisteException e) {
                                                    System.out.println(e.getMessage());
                                                } catch (UsuarioNullException e) {
                                                    System.out.println(e.getMessage());
                                                }
                                            }
                                            break;
                                            case 2:
                                                Paciente p;
                                                try {
                                                    p = tt.procurarPaciente();
                                                } catch (UsuarioNullException e) {
                                                    System.out.println(e.getMessage());
                                                }
                                                System.out.println(p);
                                                break;
                                            case 3:
                                                Medico m;
                                                try {
                                                    m = tt.procurarMedico();
                                                } catch (UsuarioNullException e) {
                                                    System.out.println(e.getMessage());
                                                }
                                                System.out.println(m);
                                                break;
                                            case 4:
                                                tt.removerUsuario();
                                                break;
                                            case 5: {
                                                try {
                                                    tt.marcarConsulta();
                                                } catch (UsuarioNullException e) {
                                                    System.out.println(e.getMessage());
                                                }
                                            }
                                            break;
                                            case 6:
                                                tt.marcarExame();
                                                break;
                                        }
                                    } while (tt.getOpcao() != 0);
                                } else if (u instanceof Medico) {
                                    do {
                                        tt.exibeMenuMedico();
                                        tt.lerOpcao();
                                        switch (tt.getOpcao()) {
                                            case 1:
                                                tt.procurarConsulta();
                                                break;
                                            case 2:
                                                break;
                                            case 3:
                                                break;
                                        }
                                    } while (tt.getOpcao() != 0);
                                } else if (u instanceof Paciente) {
                                    do {
                                        tt.exibeMenuPaciente();
                                        tt.lerOpcao();
                                        switch (tt.getOpcao()) {
                                            case 1:
                                                tt.exibirConsulta(u.getId());
                                                break;
                                            case 2:
                                                //tt.exibirExame(u.getId());
                                                break;

                                            case 3:
                                                tt.exibirCirurgia(u.getId());
                                                break;

                                            case 4:
                                                tt.cancelarConsulta(u.getId());
                                                break;

                                            default:
                                                break;
                                        }
                                    } while (tt.getOpcao() != 0);
                                } else {
                                    tt.exibirMenuLoginOpcao();
                                    tt.lerOpcao();
                                    if (tt.getOpcao() == 0) {
                                        tt.setContinuarLogin(false);
                                    } else {
                                        tt.setContinuarLogin(true);
                                    }
                                }
                            } while (u != null && tt.isContinuarLogin());
                            tt.setOpcao(-1); // Setar o valor opção com o valor do menu anterior
                            break;

                        default:
                            break;
                    }
                    break;

                default:
                    tt.sair();
                    break;
            }
        }
        System.out.println("Terminando");
        //launch(args); // TODO Remover o comentario desta linha para testar o JavaFX
    }

    @Override
    public void start(Stage stage) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

        Parent root = FXMLLoader.load(getClass().getResource("../gui/guifx/FXMLTelaInicial.fxml"));
        if (root == null) {
            System.out.println("Erro ao carregar");
        } else {
            System.out.println("Carregado com sucesso");
        }
        Scene scene = new Scene(root);
        if (stage != null) {
            stage.setScene(scene);
            stage.setTitle("JavaClinical");
            stage.show();
            setStage(stage);
        } else {
            System.out.println("Erro!");
        }
    }

    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        Main.stage = stage;
    }

}
