
public class Prontuario {
	private String queixaPaciente;

	public String getQueixaPaciente() {
		return queixaPaciente;
	}

	public void setQueixaPaciente(String queixaPaciente) {
		this.queixaPaciente = queixaPaciente;
	}
	
	public String toString() {
		return "Prontuário:\nQueixa: " + queixaPaciente;
	}
}
