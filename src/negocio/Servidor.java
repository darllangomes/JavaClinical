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
	Recepcionista efetuarLoginRecepcionita() {
		
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
	
	Paciente efetuarLoginPaciente() {
		
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
	    		 c=leitor.lerConsulta();
	    		 consultas.cadastrar(c);
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
	 * A leitura Ã© feita diretamente no servidor?
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
