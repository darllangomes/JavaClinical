package negocio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public interface IServidor {
	
	//Usuario efetuarLogin();
	void cadastrarUsuario(Usuario u);
	void cadastrarConsulta(Consulta c);
	void cadastrarCirurgia();
	void descadastrarUsuario(String id);
	void descadastrarConsulta(String id);
	void descadastrarCirurgia();
        void carregarDados()throws IOException, FileNotFoundException, ClassNotFoundException;
	Recepcionista efetuarLoginRecepcionista(Login l);
	Medico efetuarLoginMedico(Login l);
	Paciente efetuarLoginPaciente(Login l);
	
	Medico procurarMedico(String id);
	Paciente procurarPaciente(String id);
	Recepcionista procurarRecepcionista(String id);
	Consulta procurarConsulta(String id);
	
	Cirurgia procurarCirurgia(String id);
	ArrayList<Consulta> procurarConsulta(LocalDate d);
	void salvarDados() throws IOException;
	void marcarExame(Exame e);
	}
