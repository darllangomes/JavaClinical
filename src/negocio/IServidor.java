package negocio;
public interface IServidor {
	
	void efetuarLogin();
	void cadastrarUsuario();
	void cadastrarConsulta();
	void cadastrarCirurgia();
	void descadastrarUsuario();
	void descadastrarConsulta();
	void descadastrarCirurgia();
	Usuario procurarMedico();
	String lerId();
	Usuario procurarUsuario();
}
