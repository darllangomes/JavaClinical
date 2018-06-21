package negocio;
public interface IServidor {
	
	//void efetuarLogin();
	void cadastrarUsuario();
	void cadastrarConsulta();
	void cadastrarCirurgia();
	void descadastrarUsuario();
	void descadastrarConsulta();
	void descadastrarCirurgia();
	Medico procurarMedico();
	Paciente procurarPaciente();
	Recepcionista efetuarLoginRecepcionista();
	Paciente efetuarLoginPaciente();
}
