package negocio;

public class Exame extends Consulta {
	private String resultado;

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	@Override
	public String toString() {
		return "Paciente: " + getPaciente() + "\nData: " + data + "\nResultado do exame:\n" + resultado;
	}
}
