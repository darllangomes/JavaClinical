package negocio;

import java.io.FileNotFoundException;
import excecao.UsuarioExisteException;
import excecao.UsuarioNullException;
import java.io.IOException;
/*
 * Classe servidor contem os controladores
 */
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Servidor implements IServidor {

    private ControladorUsuario medicos;
    private ControladorUsuario pacientes;
    private ControladorUsuario recepcionistas;
    private ControladorConsulta consultas;
    private ControladorExames exames;
    private ControladorCirurgias cirurgias;
    //private GetInformation leitor;
    private static Servidor instance;

    private Servidor() throws UsuarioExisteException, UsuarioNullException {
        medicos = new ControladorUsuario("medicos.txt");
        pacientes = new ControladorUsuario("pacientes.txt");
        recepcionistas = new ControladorUsuario("recepcionistas.txt");

        consultas = new ControladorConsulta("consultas.txt");
        exames = new ControladorExames("exames.txt");
        cirurgias = new ControladorCirurgias("cirugias.txt");
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

    public static Servidor getInstance() throws UsuarioExisteException, UsuarioNullException {
        if (instance == null) {
            instance = new Servidor();
        }
        return instance;
    }

    /*public Usuario efetuarLogin() {
		Usuario u;
		char tipo;
		String id = leitor.lerId();
		System.out.println(id);
		System.out.println(id.charAt(0));
		tipo = id.charAt(0);
		System.out.println(tipo);
		if(tipo == '1') {
			u = efetuarLoginRecepcionista(id);
		} else if(id.charAt(0) == '2') {
			u = efetuarLoginMedico(id);
		} else {
			u = efetuarLoginPaciente(id);
		}
		return u;
	}*/
    public Recepcionista efetuarLoginRecepcionista(Login l) throws UsuarioNullException {

        Recepcionista r = (Recepcionista) recepcionistas.procurar(l.getId());

        return r;
    }

    public Paciente efetuarLoginPaciente(Login l) throws UsuarioNullException {

        Paciente p = (Paciente) pacientes.procurar(l.getId());
        return p;
    }

    public Medico efetuarLoginMedico(Login l) throws UsuarioNullException {

        Medico m = (Medico) medicos.procurar(l.getId());
        return m;
    }

    /**
     *
     * @param u
     * @throws UsuarioExisteException
     * @throws UsuarioNullException
     */
    @Override
    public void cadastrarUsuario(Usuario u) throws UsuarioExisteException, UsuarioNullException {
        //Usuario u = leitor.lerUsuarioCadastro();
        if (u instanceof Recepcionista) {
            recepcionistas.cadastrar(u);
        } else if (u instanceof Medico) {
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
    public void descadastrarUsuario(String id) throws UsuarioNullException {
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
    public Paciente procurarPaciente(String id) throws UsuarioNullException {
        //return (Paciente) pacientes.procurar(leitor.lerId());
        return (Paciente) pacientes.procurar(id);
    }

    public Medico procurarMedico(String id) throws UsuarioNullException {
        return (Medico) medicos.procurar(id);
    }

    public Recepcionista procurarRecepcionista(String id) throws UsuarioNullException {
        return (Recepcionista) recepcionistas.procurar(id);
    }

    public Consulta procurarConsulta(String id,LocalDate d) {
        return consultas.procurar(id,d);
    }

    
    public ArrayList<Consulta> procurarConsulta(String id) {
        return consultas.procurar(id);
    }
    
    public ArrayList<Consulta> procurarConsulta(LocalDate d) {
        return consultas.procurar(d);
    }
    
    public ArrayList<Usuario> getDadosRepositorioRecepcionistas() {
        return recepcionistas.getDados();
    }
    
    public ArrayList<Usuario> getDadosRepositorioMedicos() {
        return medicos.getDados();
    }
    
    public ArrayList<Usuario> getDadosRepositorioPacientes() {
        return pacientes.getDados();
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
        //e=leitor.lerExame();
        exames.cadastrar(e);

    }
    
    public String gerarProntuario(String id) {
        return consultas.gerarProntuario(id);
    }

    @Override
    public void salvarDados() throws IOException {
        consultas.salvarDados("consultas.txt");
        exames.salvarDados("exames.txt");
        pacientes.salvarDados("pacientes.txt");
        medicos.salvarDados("medicos.txt");
        recepcionistas.salvarDados("recepcionistas.txt");
    }

    public void carregarDados() throws IOException, FileNotFoundException, ClassNotFoundException {
        /*consultas.carregarDados("consultas.txt");
        exames.carregarDados("exames.txt");
        pacientes.carregarDados("pacientes.txt");
        medicos.carregarDados("medicos.txt");
        recepcionistas.carregarDados("recepcionistas.txt");*/
    }

}
