import gui.TelaTextual;
import negocio.Medico;
import negocio.Paciente;
import negocio.Recepcionista;
import negocio.Usuario;

public class MainTeste2 {

	public static void main(String[] args) {
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
								
							} else if (u instanceof Medico) {
								tt.exibeMenuMedico();
							} else if (u instanceof Paciente) {
								tt.exibeMenuPaciente();
							}
						} else {
							
						}
					}while(u != null);
					tt.setOpcao(-1); // Setar o valor opção com o valor do menu anterior
					break;
				// Isto aqui faz parte do menu da recepção, será retirado depois	
				case 2:
					System.out.println(tt.procurarPaciente()); // retorna um paciente
					tt.setOpcao(-1);
					break;
				case 3:
					System.out.println("Removendo usuario"); // Mensagem exibida aqui, pode ser feita em metodo especifico
					tt.removerUsuario();
					tt.setOpcao(-1);
					break;
					case 4: // cadastrar consulta
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
