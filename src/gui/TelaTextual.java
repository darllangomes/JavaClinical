package gui;

import java.util.Scanner;

import negocio.GetInformation;
import negocio.IServidor;
import negocio.Servidor;
import negocio.Usuario;

public class TelaTextual {
	private IServidor s;
	private boolean executando;
	private int opcao;
	private Scanner sc;
	
	public TelaTextual() {
		executando = true;
		s = new Servidor();
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
		System.out.println("1 - Funcionario\n2 - Paciente\n3 - Médico\n0 - Voltar");
	}
	
	public void loginFuncionario() {
		s.efetuarLogin();
	}

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

	public Usuario procurar() {
		return s.procurarUsuario();
		
	}

	public String lerId() {
		
		return null;
	}

	public void removerUsuario() {
		s.descadastrarUsuario();
	}
}
