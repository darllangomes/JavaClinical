package negocio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import dados.RepositorioUsuario;;

// A classe basicamente tem os métodos que pegam as informações para jogar nos controladores de consultas e pacientes.
//poderia ser simplesmente um método dentro da classe Recepcionista, mas achei melhor assim.
// Se acharem uma solução melhor, prfvr, avisem.
// Ass. Darllan Gomes

/*
 * Classe GetInformation é singleton só há uma instância dessa classe;
 * Ass: Danilo Araújo 
 */

public class GetInformation {
	static Scanner n;
	private static GetInformation instance;
	
	/*
	 * Construtor privado
	 */
	private GetInformation() {
		n = new Scanner(System.in); // Scanner criado uma única vez
	}
	
	/*
	 * Para receber a única instância da classe e inicializar a leitura
	 * chamar esse método
	 * Ass: Danilo Araújo
	 */
	public static GetInformation getInstance() {
		if(instance == null) {
			instance = new GetInformation();
		}
		return instance;
	}
	/*public void workPacientes() {
		System.out.println("Digite o nome do Paciente: ");
		Scanner n= new Scanner(System.in);
		Usuario paciente= new Paciente();
		paciente.setNome(n.nextLine());
		
		System.out.println("Digite o cpf do paciente: ");
		paciente.setCpf(n.nextLine());
		
		System.out.println("crie uma senha: ");
		String senha= n.nextLine();
		paciente.setSenhaHash(senha.hashCode());
		
		ControladorUsuario b= new ControladorUsuario();
		b.cadastrar(paciente);
	}*/
	
	public Usuario lerUsuarioCadastro() {
		Usuario u;
		int tipo;
		System.out.println("Digite o numero do tipo de Usuario:\n1 - Recepcionista\n2 - Médico\n3 - Paciente");
		tipo = n.nextInt();
		if(tipo == 1) {
			u = new Recepcionista();
		} else if(tipo == 2) {
			u = new Medico();
		} else {
			u = new Paciente();
		}
		u.setId(Id.gerarId(tipo));
		n.nextLine();
		System.out.println("Digite o nome do Usuario: ");
		u.setNome(n.nextLine());
		
		System.out.println("Digite o cpf do Usuario: ");
		u.setCpf(n.nextLine());
		
		System.out.println("Crie uma senha: ");
		String senha = n.nextLine();
		u.setSenhaHash(senha.hashCode());
		return u;
	}
	
	public LocalDate lerData() {
		System.out.println("Insira um dia para verificar as consultas marcadas (dd/mm/aaaa):");
		int dia;
		int mes;
		int ano;
		dia=n.nextInt();
		mes=n.nextInt();
		ano=n.nextInt();
		LocalDate d = LocalDate.of(ano, mes, dia);
		return d;
	}
	
	public String lerId() {
		System.out.println("Insira a id do usuario");
		return n.nextLine();
	}
	
	
	public Consulta lerConsulta(Servidor s) {
		Consulta c = new Exame();
		Medico m;
		Paciente p;
		System.out.println("Digite a id do médico: ");
		// Buscar medico no repositorio
		m = (Medico) s.procurarMedico();
		if(m==null) {
			System.out.println("Médico não encontrado.");
		}else {
			c.setMedico(m);
			System.out.println("Digite o nome do paciente: ");
			p=(Paciente)s.procurarPaciente();
				if(p==null) {
					System.out.println("Paciente não encontrado.");
				}else {
					c.setPaciente(p);
					c.setProntuario(new Prontuario());
				}
				
		}
		return c;
	}
	
	
	
	
	public LocalDate procurarConsulta() {
		LocalDate d= this.lerData();
		return d;
	}

	public String lerSenha() {
		return n.nextLine();
	}
}
