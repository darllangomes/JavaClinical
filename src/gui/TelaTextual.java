package gui;

import java.util.Scanner;

import negocio.Cirurgia;
import negocio.Consulta;
import negocio.Exame;
import negocio.GetInformation;
import negocio.IServidor;
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
	
	public TelaTextual() {
		executando = true;
		continuarLogin = false;
		s = Servidor.getInstance();
		opcao = -1;
		sc = new Scanner(System.in);
	}
	
	public boolean executando() {
		return this.executando;
	}
	
	public void exibirMenuInicial() {
		System.out.println("1 - Login\n0 - Sair");
	}
	
	public void exibirMenuLogin() {
		System.out.println("1 - Efetuar o login\n0 - Voltar");
	}
	
	/*public void loginRecepicionista() {
		s.efetuarLoginRecepcionista();
	}*/

	public void exibirRecepcao() {
		System.out.println("1 - Cadrastar usuario\n2 - Buscar usuario\n3 - Remover usuario\n0 - Sair");
	}
	
	public void lerOpcao() {
		/*
		 * Valores de opção como exemplo
		 * 1 - cadastrar usuario
		 * 2 - buscar usuario
		 * 3 - descadrastar usuario
		 */
		opcao = sc.nextInt();
	}
	
	public int getOpcao() {
		return this.opcao;
	}

	public void cadastrar() {
		s.cadastrarUsuario();
	}

	public void setOpcao(int opcao) {
		this.opcao = opcao;
	}

	public void sair() {
		this.executando = false;		
	}

	public Paciente procurarPaciente() {
		return s.procurarPaciente();
		
	}
	
	public Medico procurarMedico() {
		return s.procurarMedico();
	}

	public void removerUsuario() {
		s.descadastrarUsuario();
	}

	public Usuario efetuarLogin() {
		return s.efetuarLogin();
	}

	public void exibeMenuRecepcionista() {
		
	}

	public void exibeMenuMedico() {
		
	}

	public void exibeMenuPaciente() {
		System.out.println("1 - Exibir consulta\n2 - Exibir Resultado de exame\n3 - Exibir cirurgia\n4 - Desmarcar consulta\n0 - sair");
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
	
	public void exibirExame(String id) {
		Exame e = s.procurarExame(id);
		System.out.println(e);
	}

	public void exibirCirurgia(String id) {
		Cirurgia c = s.procurarCirurgia(id);
		System.out.println(c);
	}

	public void cancelarConsulta(String id) {
		s.descadastrarConsulta(id);
	}
}
