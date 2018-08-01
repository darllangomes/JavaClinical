package negocio;

import excecao.ExameInexistenteException;
import excecao.LoginErradoException;
import excecao.UsuarioExisteException;
import excecao.UsuarioNullException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public interface IServidor {
	
	//Usuario efetuarLogin();
	void cadastrarUsuario(Usuario u) throws UsuarioExisteException, UsuarioNullException;
	void cadastrarConsulta(Consulta c);
	void cadastrarCirurgia();
	void descadastrarUsuario(String id) throws UsuarioNullException;
	void descadastrarConsulta(String id);
	void descadastrarCirurgia();
        void carregarDados()throws IOException, FileNotFoundException, ClassNotFoundException;
	
	Recepcionista efetuarLoginRecepcionista(Login l) throws UsuarioNullException ;
	Medico efetuarLoginMedico(Login l) throws UsuarioNullException ;
	Paciente efetuarLoginPaciente(Login l) throws UsuarioNullException ;
	
	Medico procurarMedico(String id) throws UsuarioNullException ;
	Paciente procurarPaciente(String id) throws UsuarioNullException ;
	Recepcionista procurarRecepcionista(String id) throws UsuarioNullException ;
        ArrayList<Consulta> procurarConsulta(String id);
        Consulta procurarConsulta(String id, LocalDate d);
	Cirurgia procurarCirurgia(String id);
	void salvarDados() throws IOException;
	void marcarExame(Exame e);
	}
