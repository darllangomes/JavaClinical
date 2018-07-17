package negocio;
import java.io.IOException;
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
	private ControladorExames exames;
	private ControladorConsulta cirurgias;
	private GetInformation leitor;
	private static Servidor instance;
	
	private Servidor() {
		medicos = new ControladorUsuario();
		pacientes = new ControladorUsuario();
		recepcionistas = new ControladorUsuario();
		consultas = new ControladorConsulta();
		exames = new ControladorExames();
		cirurgias = new ControladorConsulta();
		//leitor = GetInformation.getInstance();
		
		/*
		 * Administrador padrão do sistema
		 * Famoso admin admin
		 * Com id 1111
		 */
		Recepcionista r = new Recepcionista();
		r.setNome("admin");
		r.setSenhaHash("admin".hashCode());
		r.setId("1111");
		r.setCpf("");
		recepcionistas.cadastrar(r);
	}
	
	public static Servidor getInstance() {
		if(instance == null) {
			instance = new Servidor();
		}
		return instance;
	}
	
	/*public Usuario efetuarLogin() {
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
	}*/
	
	public Recepcionista efetuarLoginRecepcionista(Login l) {
		
		Recepcionista r = (Recepcionista) recepcionistas.procurar(l.getId());
		if(r == null) {
			System.out.println("Identificação errada");
			return null;
		}
		if(l.getSenhaHash() != r.getSenhaHash()) {
			System.out.println("Senha errada");
			return null;
		}else {
			return r;
		}
	}
	
	public Paciente efetuarLoginPaciente(Login l) {
		
		Paciente p = (Paciente) pacientes.procurar(l.getId());
		if(p == null) {
			System.out.println("Identificação errada");
			return null;
		}
		if(l.getSenhaHash() != p.getSenhaHash()) {
			System.out.println("Senha errada");
			return null;
		}else {
			return p;
		}
	}
	
	public Medico efetuarLoginMedico(Login l) {
		
		Medico r = (Medico) medicos.procurar(l.getId());
		if(r == null) {
			System.out.println("Identificação errada");
			return null;
		}
		if(l.getSenhaHash() != r.getSenhaHash()) {
			System.out.println("Identificação errada");
			return null;
		}else {
			return r;
		}
	}

	@Override
	public void cadastrarUsuario(Usuario u) {
		//Usuario u = leitor.lerUsuarioCadastro();
		if(u instanceof Recepcionista) {
			recepcionistas.cadastrar(u);
		} else if(u instanceof Medico) {
			medicos.cadastrar(u);
		} else {
			pacientes.cadastrar(u);
		}
	}

	@Override
	public void cadastrarConsulta(Consulta c) {
	    //Consulta c= new Consulta();  
	    //c=leitor.lerConsulta(this);
	    consultas.cadastrar(c);
	}

	@Override
	public void cadastrarCirurgia() {
		// TODO Auto-generated method stub

	}

	@Override
	public void descadastrarUsuario(String id) {
		//pacientes.descadrastar(leitor.lerId());
		pacientes.descadrastar(id);
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
	public Paciente procurarPaciente(String id) {
		//return (Paciente) pacientes.procurar(leitor.lerId());
		return (Paciente) pacientes.procurar(id);
		}
	
	public Medico procurarMedico(String id) {
		return (Medico) medicos.procurar(id);
	}
	
	public Recepcionista procurarRecepcionista(String id) {
		return (Recepcionista) recepcionistas.procurar(id);
	}
	
	public ArrayList<Consulta> procurarConsulta(LocalDate d) {
		return consultas.procurar(d);
	}
	
	public Consulta procurarConsulta(String id) {
		return consultas.procurar(id);
	}
	
	/*
	public Exame procurarExame(String id) {
		Exame e= new Exame();
		e = (Exame)leitor.lerConsulta(instance);
		return (Exame) exames.procurar(e); // ver uma forma de sobrescrever o metodo de procura para poder passar um
										   //objeto Exame como argumento.
	}
	*/
	
	public Cirurgia procurarCirurgia(String id) {
		return (Cirurgia) cirurgias.procurar(id);
	}
	 public void marcarExame(Exame e) {
		//e= leitor.lerConsulta(instance);
		e=leitor.lerExame();
		exames.cadastrar(e);
		
	}
	 
	 public void salvarDados() throws IOException {
		 consultas.salvarDados();
	}
}
