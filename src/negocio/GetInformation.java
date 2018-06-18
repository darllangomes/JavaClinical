package negocio;

import java.util.Scanner;
import dados.RepositorioUsuario;;

// A classe basicamente tem os métodos que pegam as informações para jogar nos controladores de consultas e pacientes.
//poderia ser simplesmente um método dentro da classe Recepcionista, mas achei melhor assim.
// Se acharem uma solução melhor, prfvr, avisem.
// Ass. Darllan Gomes

public class GetInformation {

	public GetInformation() {
		
	}
	public void workPacientes() {
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
	public void workConsultas(Paciente p) {
		Consulta c = new Consulta();
		Scanner r = new Scanner(System.in);
		Paciente paciente= new Paciente();
		Medico m = new Medico();
		ControladorUsuario medico= new ControladorUsuario();
		System.out.println("Digite a especialidade do médico: ");
		c.setEspecialidade(r.nextLine());
		System.out.println("escreva  o nome do médico: ");
		String a = new String();
		a= r.nextLine();
		
		//entãos, temos um problema aqui, precisamos verificar se o médico existe na hora de marcar a consulta, o método de procura só procura cpf
		//não consegui fazer override, só se eu criasse uma subclasse e fizesse o override do método procurar.
		//medico.procurar
		
				
	}
}
