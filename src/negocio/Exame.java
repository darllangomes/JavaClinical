package negocio;
import java.time.LocalDate;

public class Exame  {
	private String nomePaciente;
	private String nomeMedico;
	private String resultado;
	private Consulta consulta;
	private  LocalDate data;
	
	Exame(Consulta consulta, LocalDate data){
		this.nomeMedico= consulta.getMedico().getNome();
		this.nomePaciente=consulta.getPaciente().getNome();
		this.data= consulta.getData();
	}
	

	public Consulta getConsulta() {
		return consulta;
	}

	public void setConsulta(Consulta consulta) {
		this.consulta = consulta;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	@Override
	public String toString() {
		return "Paciente: " + this.getConsulta().getPaciente() + "\nData: " + this.getConsulta().getData() + "\nResultado do exame:\n" + resultado;
	}
	
}
