  import java.io.IOException;

import gui.TelaTextual;
import negocio.Medico;
import negocio.Paciente;
import negocio.Recepcionista;
import negocio.Usuario;

public class MainTeste2 {

	public static void main(String[] args) throws Exception {
		Usuario u;
		TelaTextual tt = new TelaTextual();	// Cria a tela
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
								System.out.println(u);
								tt.exibeMenuRecepcionista();
								//tt.lerOpcao();
							} else if (u instanceof Medico) {
								tt.exibeMenuMedico();
							} else if (u instanceof Paciente) {
								tt.exibeMenuPaciente();
							}
							
						} else {
							tt.exibeMenuRecepcionista();
							tt.lerOpcao();
							if(tt.getOpcao() == 0) {
								tt.setContinuarLogin(false);
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
