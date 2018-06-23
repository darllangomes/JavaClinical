package gui;

import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;

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
		System.out.println("Menu Inicial\n1 - Login \n0 - Sair");
		
	}
	
	public void exibirMenuLoginOpcao() {
		System.out.println("Opções\n1 - Efetuar o login\n0 - Voltar ao menu inicial");
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
	public ArrayList<Consulta> procurar(LocalDate d){
		return s.procurarConsulta();
	}

	public void removerUsuario() {
		s.descadastrarUsuario();
	}

	public Usuario efetuarLogin() {
		System.out.println("Efetuar login:");
		return s.efetuarLogin();
	}

	public void exibeMenuRecepcionista() {
		System.out.println("Menu Recepção\n1 - Cadrastar usuario\n2 - Buscar paciente\n3-Buscar medico \n4 - Remover usuario\n0 - Sair");
		
	}

	public void exibeMenuMedico() {
		System.out.println("Menu Médico\n1 - buscar Consultas do dia\n2-Buscar paciente do dia.");
	}

	public void exibeMenuPaciente() {
		System.out.println("Menu Paciente\n1 - Exibir consulta\n2 - Exibir Resultado de exame\n3 - Exibir cirurgia\n4 - Desmarcar consulta\n0 - sair");
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

	public void procurarConsulta() {
		
		System.out.println(s.procurarConsulta());
		
	}
}
