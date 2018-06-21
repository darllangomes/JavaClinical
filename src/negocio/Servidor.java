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
	private static Servidor instance;
	
	private Servidor() {
		medicos = new ControladorUsuario();
		pacientes = new ControladorUsuario();
		recepcionistas = new ControladorUsuario();
		consultas = new ControladorConsulta();
		leitor = GetInformation.getInstance();
	}
	
	public static Servidor getInstance() {
		if(instance == null) {
			instance = new Servidor();
		}
		return instance;
	}
	public Recepcionista efetuarLoginRecepcionista() {
		
		Recepcionista r = (Recepcionista) recepcionistas.procurar(leitor.lerId());
		if(r == null) {
			System.out.println("Identificação errada");
			return null;
		}
		System.out.println("Senha:");
		if(leitor.lerSenha().hashCode() != r.getSenhaHash()) {
			return null;
		}else {
			return r;
		}
	}
	
	public Paciente efetuarLoginPaciente() {
		
		Paciente r = (Paciente) recepcionistas.procurar(leitor.lerId());
		if(r == null) {
			System.out.println("Identificação errada");
			return null;
		}
		System.out.println("Senha:");
		if(leitor.lerSenha().hashCode() != r.getSenhaHash()) {
			return null;
		}else {
			return r;
		}
	}

	@Override
	public void cadastrarUsuario() {
		Usuario u = leitor.lerUsuarioCadastro();
		pacientes.cadastrar(u);
	}

	@Override
	public void cadastrarConsulta() {
	    Consulta c= new Consulta();  
	    c=leitor.lerConsulta(this);
	    consultas.cadastrar(c);
	}

	@Override
	public void cadastrarCirurgia() {
		// TODO Auto-generated method stub

	}

	@Override
	public void descadastrarUsuario() {
		pacientes.descadrastar(leitor.lerId());
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
	 * A leitura Ã© feita diretamente no servidor?
	 * Ass: Danilo Araujo
	 * (non-Javadoc)
	 * @see negocio.IServidor#lerId()
	 */
	public Paciente procurarPaciente() {
		return (Paciente) pacientes.procurar(leitor.lerId());
	}
	
	public Medico procurarMedico() {
		return (Medico) medicos.procurar(leitor.lerId());
	}
	
}
