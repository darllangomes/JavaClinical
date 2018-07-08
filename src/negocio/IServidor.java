package negocio;

import java.time.LocalDate;
import java.util.ArrayList;

public interface IServidor {
	
	//Usuario efetuarLogin();
	void cadastrarUsuario(Usuario u);
	void cadastrarConsulta();
	void cadastrarCirurgia();
	void descadastrarUsuario(String id);
	void descadastrarConsulta(String id);
	void descadastrarCirurgia();
	void marcarExame(Exame e);
	
	Recepcionista efetuarLoginRecepcionista(Login l);
	Medico efetuarLoginMedico(Login l);
	Paciente efetuarLoginPaciente(Login l);
	
	Medico procurarMedico(String id);
	Paciente procurarPaciente(String id);
	Recepcionista procurarRecepcionista(String id);
	Consulta procurarConsulta(String id);
	Exame procurarExame(String id);
	Cirurgia procurarCirurgia(String id);
	ArrayList<Consulta> procurarConsulta(LocalDate d);
}
