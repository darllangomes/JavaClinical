package negocio;
import java.io.Serializable;
import java.util.Objects;

public class Paciente extends Usuario implements Serializable  {

	
	//private Consulta consulta;
	private Cirurgia cirurgia;
	private Prontuario prontuario;
	
	public Paciente() {
		
	}
	
	public String toString() {
		return "Paciente:\nNome: " + this.getNome() + "\nIdade: " + this.getIdade() +"\nIdade: " + this.getId()+ "\nCPF: " + this.getCpf();
	}

	
	/*@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Paciente other = (Paciente) obj;
		if (cirurgia == null) {
			if (other.cirurgia != null)
				return false;
		} else if (!cirurgia.equals(other.cirurgia))
			return false;
		if (idade != other.idade)
			return false;
		if (prontuario == null) {
			if (other.prontuario != null)
				return false;
		} else if (!prontuario.equals(other.prontuario))
			return false;
		return true;
	}

	*/
	
	
}
