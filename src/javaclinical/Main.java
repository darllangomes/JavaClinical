package javaclinical;
import java.time.LocalDate;

import gui.TelaTextual;
import static gui.guifx.src.teladoinicial.TelaDoInicial.setStage;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import negocio.Medico;
import negocio.Paciente;
import negocio.Recepcionista;
import negocio.Usuario;

public class Main extends Application{
        
        private static Stage stage;
        
	public static void main(String[] args) {
		Usuario u;
		
		   
		TelaTextual tt = new TelaTextual();
		// Cria a tela
		while(tt.executando()) {
			// TODO Isto vai ficar dentro de um método depois
			switch (tt.getOpcao()) {
			case -1: // Menu inicial
				tt.exibirMenuInicial(); // Exibindo o menu da recep��o s� para teste
				tt.lerOpcao();
				switch (tt.getOpcao()) {
				case 1:
					do {
						u = tt.efetuarLogin();
						if(u != null) {
							if(u instanceof Recepcionista) {
								do {
									tt.exibeMenuRecepcionista();
									tt.lerOpcao();
									switch(tt.getOpcao()) {
										
									case 1:
										tt.cadastrar();
										break;
									case 2:
										Paciente p = tt.procurarPaciente();
										System.out.println(p);
										break;
									case 3:
										Medico m = tt.procurarMedico();
										System.out.println(m);
										break;
									case 4:
										tt.removerUsuario();
										break;
									case 5:
										tt.marcarConsulta();
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
								    switch(tt.getOpcao()) {
                                                                        case 1:
                                                                            tt.procurarConsulta();
									    break;
                                                                        case 2:
									    break;
                                                                        case 3:
                                                                            break;
                                                                    }
                                                            } while(tt.getOpcao() != 0);
							}
							else if (u instanceof Paciente) {
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
								}while(tt.getOpcao() != 0);
						    } else {
							    tt.exibirMenuLoginOpcao();
							    tt.lerOpcao();
							    if(tt.getOpcao() == 0) {
								    tt.setContinuarLogin(false);
							    } else {
								tt.setContinuarLogin(true);
							    }
                            }
						}
					}while(u != null && tt.isContinuarLogin());
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
    public void start(Stage primaryStage) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
        Parent root = FXMLLoader.load(getClass().getResource("gui/guifx/src/teladoinicial/FXMLTelaInicial.fxml"));
        FXMLLoader.load(getClass().getResource(STYLESHEET_MODENA));
        if(root == null) {
            System.out.println("Erro ao carregar");
        } else {
            System.out.println("Carregado com sucesso");
        }
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.setTitle("JavaClinical");
        stage.show();
        setStage(stage);
    }
    
    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        Main.stage = stage;
    }

}
