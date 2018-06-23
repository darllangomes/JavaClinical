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
		System.out.println("Seja Bem Vindo ao JavaClinical\n");
		System.out.println("1 - Login \n0 - Sair");
		
	}
	
	public void exibirMenuLogin() {
		System.out.println("1 - Efetuar o login \n0 - Voltar");
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
	public ArrayList<Consulta> procurarConsulta(LocalDate d){
		return s.procurarConsulta(d);
	}

	public void removerUsuario() {
		s.descadastrarUsuario();
	}

	public Usuario efetuarLogin() {
		return s.efetuarLogin();
	}

	public void exibeMenuRecepcionista() {
		System.out.println("\n1 - Cadrastar Usuario\n2 - Buscar Paciente\n3 - Buscar Medico \n4 - Remover Usuario\n0 - Sair");
		
	}

	public void exibeMenuMedico() {
		System.out.println("1 - Buscar Consultas do Dia\n2 - Buscar Paciente do Dia.");
	}

	public void exibeMenuPaciente() {
		System.out.println("1 - Exibir Consulta\n2 - Exibir Resultado de Exame\n3 - Exibir Cirurgia\n4 - Desmarcar Consulta\n0 - Sair");
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
