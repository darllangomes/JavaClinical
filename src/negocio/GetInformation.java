package negocio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import dados.RepositorioUsuario;import excecao.UsuarioNullException;
;

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
	
	
	private void clearBuffer() {
		if(n.hasNextLine()) {
			n.nextLine();
		}
	}
	
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
		System.out.println("Digite a idade: ");
		u.setIdade(n.nextInt());
		n.nextLine();
		if(tipo == 2) {
			System.out.println("Digite a especialidade do médico: ");
			((Medico) u).setEspecialidade(n.nextLine());
		}
		System.out.println("Digite o cpf do Usuario: ");
		u.setCpf(n.nextLine());
		
		System.out.println("Crie uma senha: ");
		String senha = n.nextLine();
		u.setSenhaHash(senha.hashCode());
		return u;
	}
	
	public LocalDate lerData() {
		int dia;
		int mes;
		int ano;
		dia=n.nextInt();
		mes=n.nextInt();
		ano=n.nextInt();
		LocalDate d = LocalDate.of(ano, mes, dia);
		this.clearBuffer();
		return d;
	}
	
	public String lerId() {
		String id = n.nextLine();
		return id;
	}
	
	
	public Consulta lerConsulta(IServidor s) throws UsuarioNullException {
		Consulta c = new Consulta();
		Medico m;
		Paciente p;
		LocalDate d;
		System.out.println("Digite a id do médico: ");
		//this.clearBuffer();
		// Buscar medico no repositorio
		m = (Medico) s.procurarMedico(lerId());
		if(m==null) {
			System.out.println("Médico não encontrado.");
		}else {
			System.out.println("Digite a especialidade do médico: ");
			m.setEspecialidade(n.nextLine());
			c.setMedico(m);
			System.out.println("Digite a id do paciente: ");
			p=(Paciente)s.procurarPaciente(lerId());
				if(p==null) {
					System.out.println("Paciente não encontrado.");
				}else {
					c.setPaciente(p);
                                        c.setId(p.getId());
					c.setProntuario(new Prontuario());
				}
				
		}
                System.out.println("Insira a data da Consulta:");
		d = this.lerData();
		c.setData(d);
		
		return c;
	}
	
	
	
	public LocalDate procurarConsulta() {
		LocalDate d= this.lerData();
		return d;
	}

	public String lerSenha() {
		return n.nextLine();
	}
	
	public Exame lerExame() {
		Exame e = new Exame();
		System.out.println("Digite o seu ID: ");
		//ver depois como fazer tudo pelo ID
		System.out.println("Digite o nome do paciente: ");
		e.setNomePaciente(n.nextLine());
		System.out.println("Digite o nome do Médico solicitante: ");
		e.setNomeMedico(n.nextLine());
		System.out.println("Digite o tipo do Exame: ");
		e.setTipoExame(n.nextLine());
		System.out.println("Digite a data da Consulta: \n");
		e.setData(lerData());
		return e;
	}
}
