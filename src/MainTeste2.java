import gui.TelaTextual;

public class MainTeste2 {

	public static void main(String[] args) {
		TelaTextual tt = new TelaTextual();	// Cria a tela
		while(tt.executando()) {
			switch (tt.getOpcao()) {
			case -1: // Menu inicial
				tt.exibirInicial();
				tt.lerOpcao();
				switch (tt.getOpcao()) {
				case 1:
					tt.cadastrar();
					tt.setOpcao(-1); // Setar o valor opção com o valor do menu anterior
					break;
				case 2:
					System.out.println(tt.procurar());
					tt.setOpcao(-1);
					break;
				case 3:
					System.out.println("Removendo usuario"); // Mensagem exibida aqui, pode ser feita em metodo especifico
					tt.removerUsuario();
					tt.setOpcao(-1);
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
