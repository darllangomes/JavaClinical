package negocio;
public interface IServidor {
	
	Usuario efetuarLogin();
	void cadastrarUsuario();
	void cadastrarConsulta();
	void cadastrarCirurgia();
	void descadastrarUsuario();
	void descadastrarConsulta();
	void descadastrarCirurgia();
	Medico procurarMedico();
	Paciente procurarPaciente();
	Recepcionista efetuarLoginRecepcionista(String id);
	Medico efetuarLoginMedico(String id);
	Paciente efetuarLoginPaciente(String id);
}
