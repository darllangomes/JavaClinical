package negocio;
import java.time.LocalDate;
import java.io.Serializable;

public class Consulta implements Serializable {
	
	LocalDate data;
	private Medico medico;
	private Paciente paciente;
	private Prontuario prontuario;
	
	 Consulta() {
             
	}
	
	public Consulta(LocalDate data, Medico medico, Paciente paciente) {
		this.data = data;
		this.medico = medico;
		this.paciente = paciente;
		
	}
   
	public Consulta(LocalDate data, String especialidade, Medico medico, Paciente paciente, boolean solicitacaoExame,
			boolean solicitacaoCirurgia, boolean marcada) {
		this.data = data;
		this.medico = medico;
		this.paciente = paciente;
		
	}
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	public String getEspecialidade() {
		return medico.getEspecialidade();
	}
	public void setEspecialidade(String especialidade) {
		medico.setEspecialidade(especialidade);
	}
	public Medico getNomeMedico() {
		return medico;
	}
	public void setMedico(Medico medico) {
		this.medico = medico;
	}
	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	
	
	public Prontuario getProntuario() {
		return prontuario;
	}

	public void setProntuario(Prontuario prontuario) {
		this.prontuario = prontuario;
	}

	public Medico getMedico() {
		return medico;
	}

	public String toString() {
		return "Consulta:\n" + data + "\n" + medico + "\n" + paciente;
	}
	
	


	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Consulta other = (Consulta) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (medico == null) {
			if (other.medico != null)
				return false;
		} else if (!medico.equals(other.medico))
			return false;
		if (paciente == null) {
			if (other.paciente != null)
				return false;
		} else if (!paciente.equals(other.paciente))
			return false;
		
		return true;
	}

    void setId(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
