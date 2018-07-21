package negocio;

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
	void descadastrarUsuario(String id);
	void descadastrarConsulta(String id);
	void descadastrarCirurgia();
        void carregarDados()throws IOException, FileNotFoundException, ClassNotFoundException;
	
	Recepcionista efetuarLoginRecepcionista(Login l) throws UsuarioNullException ;
	Medico efetuarLoginMedico(Login l) throws UsuarioNullException ;
	Paciente efetuarLoginPaciente(Login l) throws UsuarioNullException ;
	
	Medico procurarMedico(String id) throws UsuarioNullException ;
	Paciente procurarPaciente(String id) throws UsuarioNullException ;
	Recepcionista procurarRecepcionista(String id) throws UsuarioNullException ;
	Consulta procurarConsulta(String id);
	
	Cirurgia procurarCirurgia(String id);
	ArrayList<Consulta> procurarConsulta(LocalDate d);
	void salvarDados() throws IOException;
	void marcarExame(Exame e);
	}
