package negocio;
/*
 * Classe servidor contem os controladores
 */
import java.time.LocalDate;
import java.util.ArrayList;


public class Servidor implements IServidor {
	private ControladorUsuario medicos;
	private ControladorUsuario pacientes;
	private ControladorUsuario recepcionistas;
	private ControladorConsulta consultas;
	private ControladorConsulta exames;
	private ControladorConsulta cirurgias;
	private GetInformation leitor;
	private static Servidor instance;
	
	private Servidor() {
		medicos = new ControladorUsuario();
		pacientes = new ControladorUsuario();
		recepcionistas = new ControladorUsuario();
		consultas = new ControladorConsulta();
		exames = new ControladorConsulta();
		cirurgias = new ControladorConsulta();
		leitor = GetInformation.getInstance();
		
		/*
		 * Administrador padrão do sistema
		 * Famoso admin admin
		 * Com id 1111
		 */
		Recepcionista r = new Recepcionista();
		r.setNome("admin");
		r.setSenhaHash("admin".hashCode());
		r.setId("1111");
		r.setCpf(null);
		recepcionistas.cadastrar(r);
	}
	
	public static Servidor getInstance() {
		if(instance == null) {
			instance = new Servidor();
		}
		return instance;
	}
	
	public Usuario efetuarLogin() {
		Usuario u;
		String id = leitor.lerId();
				
		if(id.charAt(0) == '1') {
			u = efetuarLoginRecepcionista(id);
		} else if(id.charAt(0) == '2') {
			u = efetuarLoginMedico(id);
		} else {
			u = efetuarLoginPaciente(id);
		}
		return u;
	}
	public Recepcionista efetuarLoginRecepcionista(String id) {
		
		Recepcionista r = (Recepcionista) recepcionistas.procurar(id);
		if(r == null) {
			System.out.println("Identificação errada");
			return null;
		}
		System.out.println("Senha:");
		if(leitor.lerSenha().hashCode() != r.getSenhaHash()) {
			System.out.println("Senha errada");
			return null;
		}else {
			return r;
		}
	}
	
	public Paciente efetuarLoginPaciente(String id) {
		
		Paciente p = (Paciente) pacientes.procurar(id);
		if(p == null) {
			System.out.println("Identificação errada");
			return null;
		}
		System.out.println("Senha:");
		if(leitor.lerSenha().hashCode() != p.getSenhaHash()) {
			System.out.println("Senha errada");
			return null;
		}else {
			return p;
		}
	}
	
	public Medico efetuarLoginMedico(String id) {
		
		Medico r = (Medico) medicos.procurar(id);
		if(r == null) {
			System.out.println("Identificação errada");
			return null;
		}
		System.out.println("Senha:");
		if(leitor.lerSenha().hashCode() != r.getSenhaHash()) {
			System.out.println("Identificação errada");
			return null;
		}else {
			return r;
		}
	}

	@Override
	public void cadastrarUsuario() {
		Usuario u = leitor.lerUsuarioCadastro();
		if(u instanceof Recepcionista) {
			recepcionistas.cadastrar(u);
		} else if(u instanceof Medico) {
			medicos.cadastrar(u);
		} else {
			pacientes.cadastrar(u);
		}
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
	public void descadastrarConsulta(String id) {
		consultas.descadrastar(id);
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
	
	public Recepcionista procurarRecepcionista() {
		return (Recepcionista) recepcionistas.procurar(leitor.lerId());
	}
	
	public ArrayList<Consulta> procurarConsulta() {
		return consultas.procurar(leitor.lerData());
	}
	
	public Consulta procurarConsulta(String id) {
		return consultas.procurar(id);
	}
	
	public Exame procurarExame(String id) {
		return (Exame) exames.procurar(id);
	}
	
	public Cirurgia procurarCirurgia(String id) {
		return (Cirurgia) cirurgias.procurar(id);
	}
	 public void marcarExame(Exame e) {
		e= (Exame)leitor.lerConsulta(instance);
		exames.cadastrar(e);
	}
}
