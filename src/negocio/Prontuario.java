package negocio;

import java.io.Serializable;

public class Prontuario implements Serializable {
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
	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Prontuario other = (Prontuario) obj;
		if (queixaPaciente == null) {
			if (other.queixaPaciente != null)
				return false;
		} else if (!queixaPaciente.equals(other.queixaPaciente))
			return false;
		return true;
	}
}
