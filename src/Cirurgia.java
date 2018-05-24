
public class Cirurgia {
	private String id;
	private Paciente paciente;  // Atributo tipo Paciente;
	private Medico medico;  // Atributo tipo Medico
	private boolean marcada;
	
	
	
	
	public Cirurgia() {
	
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public Paciente getPaciente() {
		return paciente;
	}
	
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	public Medico getMedico() {
		return medico;
	}
	
	public void setMedico(Medico medico) {
		this.medico = medico;
	}
	
	public boolean isMarcada() {
		return marcada;
	}
	
	public void setMarcada(boolean marcada) {
		this.marcada = marcada;
	}
    
	
	
}
