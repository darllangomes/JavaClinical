package negocio;

import java.util.Scanner;
import java.io.Serializable;

public class Medico extends Usuario implements Serializable {
	
	private String especialidade;
	
	
	public String getEspecialidade() {
		return especialidade;
	}
	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

	public String getIdMedico(){
		return super.getId();
	}

	public void setIdMedico(String id){
		super.setId(id);
	}
	
	
	public String toString() {
		return "Médico:\nNome: " + this.getNome() + "\nID: " + this.getId() + "\nEspecialidade: " + especialidade;
	}
	
	public void work(Paciente paciente, Prontuario prontuario ) {
		
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Medico other = (Medico) obj;
		if (especialidade == null) {
			if (other.especialidade != null)
				return false;
		} else if (!especialidade.equals(other.especialidade))
			return false;
		return true;
	}
	
	
}
