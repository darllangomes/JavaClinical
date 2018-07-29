package gui;

import excecao.UsuarioExisteException;
import excecao.UsuarioNullException;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import java.util.Scanner;
import java.io.IOException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

import negocio.Cirurgia;
import negocio.Consulta;
import negocio.Exame;
import negocio.GetInformation;
import negocio.IServidor;
import negocio.Login;
import negocio.Medico;
import negocio.Paciente;
import negocio.Recepcionista;
import negocio.Servidor;
import negocio.Usuario;

public class TelaTextual {

    private Servidor s;
    private boolean executando;
    private boolean continuarLogin;
    private int opcao;
    private Scanner sc;
    private GetInformation leitor;

    public TelaTextual() {
        executando = true;
        continuarLogin = false;
        try {
            s = Servidor.getInstance();
        } catch (UsuarioExisteException e) {
            System.out.println(e.getMessage());
        } catch (UsuarioNullException e) {
            System.out.println(e.getMessage());
        }
        try {
            s.carregarDados();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
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
        System.out.println("Menu Recepção\n1 - Cadrastar usuario\n2 - Buscar paciente\n3 - Buscar medico \n4 - Remover usuario \n5 - Marcar consulta\n6 - Marcar exame \n7 - Exibir lista de Recepcionistas cadastrados\n8 - Exibir lista de Médicos cadastrados\n9 - Exibir lista de Pacientes cadastrados\n10 - Exibir as consultas do dia\n0 - Sair");

    }

    public void exibeMenuMedico() {
        System.out.println("Menu Médico\n1 - Buscar Consultas do dia\n0 - Sair");
    }

    public void exibeMenuPaciente() {
        System.out.println("Menu Paciente\n1 - Exibir consulta\n2 - Exibir Resultado de exame\n3 - Exibir cirurgia\n4 - Desmarcar consulta\n0 - Sair");
    }
    // *****************************************************************************************

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

    public void cadastrar() throws UsuarioExisteException, UsuarioNullException {
        Usuario u = leitor.lerUsuarioCadastro();
        s.cadastrarUsuario(u);
    }

    public void sair() {
        this.executando = false;
        try {
            s.salvarDados();
        } catch (IOException e) {
            System.out.println("erro ao salvar arquivo");
            System.out.println(e);
        }
    }

    public Paciente procurarPaciente() throws UsuarioNullException {
        return s.procurarPaciente(leitor.lerId());

    }

    public Medico procurarMedico() throws UsuarioNullException {
        return s.procurarMedico(leitor.lerId());
    }

    public ArrayList<Consulta> procurar(LocalDate d) {
        return s.procurarConsulta(d);
    }

    public void removerUsuario() {
        try {
            s.descadastrarUsuario(leitor.lerId());
        } catch (UsuarioNullException ex) {
            System.out.println("Usuário não existe no sistema");
        }
    }

    public Usuario efetuarLogin() throws UsuarioNullException {
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

    public void exibirConsulta(String id, LocalDate data) {
        Consulta c = s.procurarConsulta(id, data);
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

    public void marcarConsulta() throws UsuarioNullException {

        Consulta c = leitor.lerConsulta(s);
        s.cadastrarConsulta(c);
    }

    public void salvarTudo() throws IOException {
        s.salvarDados();
    }

    public void carregarArquivos() {
        try {
            s.carregarDados();
        } catch (IOException ex) {
            //Logger.getLogger(TelaTextual.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Arquivo não encontrado!");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TelaTextual.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public ArrayList<Consulta> exibirConsultasDia(LocalDate d) {
        return s.procurarConsultasDia(d);
    }

    public void executarOperacoes() {
        Usuario u = null;
        Consulta c = null;
        String id = null; // @author Danilo Araújo Variável que irá guardar a ID do paciente na conulta
                   // Solução temporária
        switch (this.getOpcao()) {
            case -1: // Menu inicial
                this.exibirMenuInicial(); // Exibindo o menu da recep��o s� para teste
                this.lerOpcao();
                switch (this.getOpcao()) {
                    case 1:
                        do {
                            try {
                                u = this.efetuarLogin();
                                if (u instanceof Recepcionista) {
                                    do {
                                        this.exibeMenuRecepcionista();
                                        this.lerOpcao();
                                        switch (this.getOpcao()) {
                                            case 1: {
                                                try {
                                                    this.cadastrar();
                                                } catch (UsuarioExisteException e) {
                                                    System.out.println(e.getMessage());
                                                } catch (UsuarioNullException e) {
                                                    System.out.println(e.getMessage());
                                                }
                                            }
                                            break;
                                            case 2:
                                                Paciente p;
                                                try {
                                                    p = this.procurarPaciente();
                                                    System.out.println(p);
                                                } catch (UsuarioNullException e) {
                                                    System.out.println(e.getMessage());
                                                }
                                                break;
                                            case 3:
                                                Medico m;
                                                try {
                                                    System.out.println("Insira a ID");
                                                    m = this.procurarMedico();
                                                    System.out.println(m);
                                                } catch (UsuarioNullException e) {
                                                    System.out.println(e.getMessage());
                                                }
                                                break;
                                            case 4:
                                                this.removerUsuario();
                                                break;
                                            case 5: 
                                                try {
                                                    this.marcarConsulta();
                                                } catch (UsuarioNullException e) {
                                                    System.out.println(e.getMessage());
                                                }
                                                break;
                                            case 6:
                                                this.marcarExame();
                                                break;
                                            case 7:
                                                System.out.println(s.getDadosRepositorioRecepcionistas());
                                                break;
                                            case 8:
                                                System.out.println(s.getDadosRepositorioMedicos());
                                                break;
                                            case 9:
                                                System.out.println(s.getDadosRepositorioPacientes());
                                                break;
                                            case 10:
                                                System.out.println(s.procurarConsultasDia(LocalDate.now()));
                                        }
                                    } while (this.getOpcao() != 0);
                                } else if (u instanceof Medico) {
                                    do {
                                        this.exibeMenuMedico();
                                        this.lerOpcao();
                                        switch (this.getOpcao()) {
                                            case 1:
                                                this.procurarConsulta();
                                                break;
                                            case 2:
                                                System.out.println("Insira a ID do paciente");
                                                id = leitor.lerId();
                                                this.gerarProntuario(id);
                                                break;
                                            case 3:
                                                break;
                                        }
                                    } while (this.getOpcao() != 0);
                                } else if (u instanceof Paciente) {
                                    do {
                                        this.exibeMenuPaciente();
                                        this.lerOpcao();
                                        switch (this.getOpcao()) {
                                            case 1:
                                                System.out.println("Insira a data da consulta");
                                                this.exibirConsulta(u.getId(),leitor.lerData());
                                                break;
                                            case 2:
                                                //this.exibirExame(u.getId());
                                                break;

                                            case 3:
                                                this.exibirCirurgia(u.getId());
                                                break;

                                            case 4:
                                                this.cancelarConsulta(u.getId());
                                                break;

                                            default:
                                                break;
                                        }
                                    } while (this.getOpcao() != 0);
                                } else {
                                    this.exibirMenuLoginOpcao();
                                    this.lerOpcao();
                                    if (this.getOpcao() == 0) {
                                        this.setContinuarLogin(false);
                                    } else {
                                        this.setContinuarLogin(true);
                                    }
                                }
                            } catch (UsuarioNullException e) {
                                System.out.println(e.getMessage());
                            }
                        } while (u != null && this.isContinuarLogin());
                        this.setOpcao(-1); // Setar o valor opção com o valor do menu anterior
                        break;

                    default:
                        break;
                }
                break;

            default:
                this.sair();
                
                break;
        }
    }

    public String gerarProntuario(String id) {
        return s.gerarProntuario(id);
    }

}
