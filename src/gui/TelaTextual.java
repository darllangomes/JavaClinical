package gui;

import java.util.ArrayList;

import java.util.Scanner;
import java.io.IOException;
import java.time.LocalDate;

import negocio.Cirurgia;
import negocio.Consulta;
import negocio.Exame;
import negocio.GetInformation;
import negocio.IServidor;
import negocio.Login;
import negocio.Medico;
import negocio.Paciente;
import negocio.Servidor;
import negocio.Usuario;

public class TelaTextual {
	private IServidor s;
	private boolean executando;
	private boolean continuarLogin;
	private int opcao;
	private Scanner sc;
	private GetInformation leitor;
	
	public TelaTextual() {
		executando = true;
		continuarLogin = false;
		s = Servidor.getInstance();
		leitor = GetInformation.getInstance();
		opcao = -1;
		sc = new Scanner(System.in);
	}
	
	public boolean executando() {
		return this.executando;
	}
    

    //*************** Menus ****************	
	public void exibirMenuInicial() {
		System.out.println("Menu Inicial\n1 - Login \n0 - Sair");
		
	}
	
	public void exibirMenuLoginOpcao() {
		System.out.println("Opções\n1 - Efetuar o login\n0 - Voltar ao menu inicial");
	}

	public void exibeMenuRecepcionista() {
		System.out.println("Menu Recepção\n1 - Cadrastar usuario\n2 - Buscar paciente\n3 - Buscar medico \n4 - Remover usuario \n5 - Marcar consulta\n6 - Marcar exame \n0 - Sair");
		
	}

	public void exibeMenuMedico() {
		System.out.println("Menu Médico\n1 - Buscar Consultas do dia\n0 - Sair");
	}

	public void exibeMenuPaciente() {
		System.out.println("Menu Paciente\n1 - Exibir consulta\n2 - Exibir Resultado de exame\n3 - Exibir cirurgia\n4 - Desmarcar consulta\n0 - Sair");
	}
	
	public int lerOpcao() {
		/*
		 * Valores de opção como exemplo
		 * 1 - cadastrar usuario
		 * 2 - buscar usuario
		 * 3 - descadrastar usuario
		 */
		opcao = sc.nextInt();
		sc.nextLine();
		return opcao;
	
	}
	
	public int getOpcao() {
		return this.opcao;
	}

	public void setOpcao(int opcao) {
		this.opcao = opcao;
	}

	public void limparTela() {
		System.out.println("\n \n");
		System.out.println("\n \n");
		System.out.println("\n \n");
		
	}

	public void cadastrar() {
		Usuario u = leitor.lerUsuarioCadastro();
		s.cadastrarUsuario(u); 
	}

	public void sair() {
		this.executando = false;
		try {
		s.salvarDados();
		}catch(IOException e){
			System.out.println("erro ao salvar arquivo");
			System.out.println(e);
		}
	}

	public Paciente procurarPaciente() {
		return s.procurarPaciente(leitor.lerId());
		
	}
	
	public Medico procurarMedico() {
		return s.procurarMedico(leitor.lerId());
	}
	public ArrayList<Consulta> procurar(LocalDate d){
		return s.procurarConsulta(d);
	}

	public void removerUsuario() {
		s.descadastrarUsuario(leitor.lerId());
	}

	public Usuario efetuarLogin() {
		System.out.println("Efetuar login\n\nDigite a sua id:\n");
		Usuario u;
		String id = leitor.lerId();
		
		
		System.out.println("Insira a senha: \n");
		int sh = leitor.lerSenha().hashCode();
		
		Login l = new Login(id, sh);
		
		/*
		 * Por questões de segurança
		 * Perde-se as referências da id e hash
		 */
		id = null;
		sh = 0;
		
		switch (l.getId().charAt(0)) {
		case '1':
			u = s.efetuarLoginRecepcionista(l);
			break;
		case '2':
			u = s.efetuarLoginMedico(l);
			break;
		default:
			u = s.efetuarLoginPaciente(l);
			break;
		}
		
		/*if(l.getId().charAt(0) == '1') {
			u = s.efetuarLoginRecepcionista(l);
		} else if(id.charAt(0) == '2') {
			u = s.efetuarLoginMedico(l);
		} else {
			u = s.efetuarLoginPaciente(l);
		}*/
        
		/*
		 * Por questões de segurança
		 * Perde-se a referência do objeto login
		 */
        l = null;
		return u;
	}

	public boolean isContinuarLogin() {
		return continuarLogin;
	}

	public void setContinuarLogin(boolean continuarLogin) {
		this.continuarLogin = continuarLogin;
	}

	public void exibirConsulta(String id) {
		Consulta c = s.procurarConsulta(id);
		System.out.println(c);
	}
	
	/*
	public void exibirExame(String id) {
		Exame e = s.procurarExame(id);
		System.out.println(e);
	}
    */
	public void exibirCirurgia(String id) {
		Cirurgia c = s.procurarCirurgia(id);
		System.out.println(c);
	}

	public void cancelarConsulta(String id) {
		s.descadastrarConsulta(id);
	}

	public void procurarConsulta() {
		
		System.out.println(s.procurarConsulta(leitor.lerData()));
		
	}
	public void marcarExame() {
	    s.marcarExame(leitor.lerExame());
	}

	public void marcarConsulta() {
		
		Consulta c = leitor.lerConsulta(s);
		s.cadastrarConsulta(c);
	}

}
