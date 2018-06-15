package negocio;

import java.util.Scanner;

public class GetInformation {

	public GetInformation() {
		
	}
	public void work() {
		System.out.println("Digite o nome do Paciente: ");
		Scanner n= new Scanner(System.in);
		Usuario paciente= new Usuario();
		paciente.setNome(n.nextLine());
		
		System.out.println("Digite o cpf do paciente: ");
		paciente.setCpf(n.nextLine());
		
		System.out.println("crie uma senha: ");
		String senha= n.nextLine();
		paciente.setSenhaHash(senha.hashCode());
		
		ControladorUsuario b= new ControladorUsuario();
		b.cadastrar(paciente);
		
	}
}
