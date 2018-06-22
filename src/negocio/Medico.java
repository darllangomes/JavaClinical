package negocio;

import java.util.Scanner;

public class Medico extends Usuario {
	
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
	
	public void consultar(Consulta c, Prontuario p) {
		System.out.println("Qual é a sua queixa? ");
		Scanner sc = new Scanner(System.in);
		p.setQueixaPaciente(sc.nextLine());
	}
	
	public String toString() {
		return "MÃ©dico:\nNome: " + this.getNome() + "\nEspecialidade: " + especialidade;
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
