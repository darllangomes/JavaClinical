package gui;

import java.util.Scanner;

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
		System.out.println("1 - Login \n 0 - Sair");
		
	}
	
	public void exibirMenuLogin() {
		System.out.println("1 - Efetuar o login\n0 - Voltar");
	}
	
	
	public int lerOpcao() {
		/*
		 * Valores de opção como exemplo
		 * 1 - cadastrar usuario
		 * 2 - buscar usuario
		 * 3 - descadrastar usuario
		 */
		opcao = sc.nextInt();
		return opcao;
	
	}
	
	public void limparTela() {
		System.out.println("\n \n");
		System.out.println("\n \n");
		System.out.println("\n \n");
		
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
	public Consulta procurarConsulta(Localdate d){
		return s.procurarConsulta(d);
	}

	public void removerUsuario() {
		s.descadastrarUsuario();
	}

	public Usuario efetuarLogin() {
		return s.efetuarLogin();
	}

	public void exibeMenuRecepcionista() {
		System.out.println("1 - Cadrastar usuario\n2 - Buscar paciente\n3-Buscar medico \n4 - Remover usuario\n 0 - Sair");
		
	}

	public void exibeMenuMedico() {
		System.out.println("1 - buscar Consultas do dia\n2-Buscar paciente do dia.");
	}

	public void exibeMenuPaciente() {
		
	}

	public boolean isContinuarLogin() {
		return continuarLogin;
	}

	public void setContinuarLogin(boolean continuarLogin) {
		this.continuarLogin = continuarLogin;
	}
}
