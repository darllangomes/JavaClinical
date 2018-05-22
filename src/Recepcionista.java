import java.time.LocalDate;

public class Recepcionista {
	private String id;
	private String nome;
	private String senha;
	private Paciente paciente;
	private Consulta consulta;
	private Cirurgia cirurgia;
		
	
	
	public Recepcionista(String id, String nome, String senha) {
		this.id = id;
		this.nome = nome;
		this.senha = senha;
	}
	


	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public String getSenha() {
		return senha;
	}



	public void setSenha(String senha) {
		this.senha = senha;
	}



	public Paciente getPaciente() {
		return paciente;
	}



	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}



	public Consulta getConsulta() {
		return consulta;
	}



	public void setConsulta(Consulta consulta) {
		this.consulta = consulta;
	}



	public void marcarConsulta(Paciente paciente){
		if(paciente.getConsulta()==null) {
			LocalDate d = LocalDate.of(2018, 6, 25);
			Consulta c = new Consulta(d, "especialidade", null, paciente, false, false, true);
			paciente.setConsulta(c);
			System.out.println("Consulta marcada com sucesso!");
		}
	}
	
	public void desmarcarConsulta(Paciente paciente){
		if(paciente.getConsulta().isMarcada()==true) {
			paciente.getConsulta().setMarcada(false);
			System.out.println("Consulta desmarcada com sucesso");
		}
	}
	
	
	public void marcarCirurgia(Paciente paciente){
		if(paciente.getCirurgia()==null) {
			Cirurgia c = new Cirurgia();
			c.setMarcada(true);
			paciente.setCirurgia(c);
			System.out.println("Cirurgia Marcada com sucesso!");
		}
	}



	public void desmarcarCirurgia(Paciente paciente) {
		if(paciente.getCirurgia().isMarcada()==true) {
			paciente.getCirurgia().setMarcada(false);
			System.out.println("Cirurgia desmarcada com sucesso");
		}
		
	}
	
	
	
	
}
