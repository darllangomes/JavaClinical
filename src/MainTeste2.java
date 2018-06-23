import java.time.LocalDate;

import gui.TelaTextual;
import negocio.Medico;
import negocio.Paciente;
import negocio.Recepcionista;
import negocio.Usuario;

public class MainTeste2 {

	public static void main(String[] args) {
		Usuario u;
		TelaTextual tt = new TelaTextual();
		// Cria a tela
		while(tt.executando()) {
			// Isto vai ficar dentro de um método depois
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
										tt.procurarPaciente();
										break;
									case 3:
										tt.procurarMedico();
										break;
									case 4:
									tt.removerUsuario();
										break;
									}
								} while (tt.getOpcao() != 0);
							} else if (u instanceof Medico) {
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
								}while(tt.getOpcao() != 0);
							} else if (u instanceof Paciente) {
								do {
									tt.exibeMenuPaciente();
									tt.lerOpcao();
									switch (tt.getOpcao()) {
									case 1:
										tt.exibirConsulta(u.getId());
										break;
									case 2:
										tt.exibirExame(u.getId());
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
	}

}
