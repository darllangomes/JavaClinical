package negocio;
/*
 * Classe servidor contem os controladores
 */
public class Servidor implements IServidor {
	private ControladorUsuario medicos;
	private ControladorUsuario pacientes;
	private ControladorUsuario recepcionistas;
	private ControladorConsulta consultas;
	private GetInformation leitor;
	
	public Servidor() {
		medicos = new ControladorUsuario();
		pacientes = new ControladorUsuario();
		recepcionistas = new ControladorUsuario();
		consultas = new ControladorConsulta();
		leitor = GetInformation.getInstance();
	}
	//@Override
	public void efetuarLogin() {
		/*Usuario u = leitor.lerUsuarioCadastro();
		Usuario login = pacientes.procurar(u.getCpf());
		if(login != null) {
			
		}*/

	}

	@Override
	public void cadastrarUsuario() {
		Usuario u = leitor.lerUsuarioCadastro();
		pacientes.cadastrar(u);
	}

	@Override
	public void cadastrarConsulta() {
		// TODO Auto-generated method stub

	}

	@Override
	public void cadastrarCirurgia() {
		// TODO Auto-generated method stub

	}

	@Override
	public void descadastrarUsuario() {
		pacientes.descadrastar(this.lerId());
	}

	@Override
	public void descadastrarConsulta() {
		// TODO Auto-generated method stub

	}

	@Override
	public void descadastrarCirurgia() {
		// TODO Auto-generated method stub

	}
	
	/*
	 * A leitura é feita diretamente no servidor?
	 * Ass: Danilo Araujo
	 * (non-Javadoc)
	 * @see negocio.IServidor#lerId()
	 */
	public String lerId() {
		return leitor.lerId();
	}
	
	public Usuario procurarUsuario() {
		return pacientes.procurar(this.lerId());
	}
}
