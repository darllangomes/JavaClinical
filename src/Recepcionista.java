import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Recepcionista {
	private String id;
	private String nome;
	private String senha;
		
	
	
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



	//public Paciente getPaciente() {
	//	return paciente;
	//}



	//public void setPaciente(Paciente paciente) {
	//	this.paciente = paciente;
	//}



	//public Consulta getConsulta() {
	//	return consulta;
	//}



	//public void setConsulta(Consulta consulta) {
	//	this.consulta = consulta;
	//}



	public void marcarConsulta(Paciente paciente, Medico medico, ArrayList<Consulta> repositorioConsulta){
		//Scanner nome= new Scanner(System.in);
		//Scanner bufferEspecialidade = new Scanner(system.in);
		Scanner sc = new Scanner(System.in);
		int dia,mes,ano;
		String especialidade=new String();
			
		System.out.println("digite a especialidade do médico: ");			
		especialidade = sc.nextLine();
		System.out.println("digite o dia da consulta (dia mês ano): ");
		dia = sc.nextInt();
		mes = sc.nextInt();
		ano =sc.nextInt();
			
		LocalDate d = LocalDate.of(ano, mes, dia);
		Consulta c = new Consulta(d, especialidade, medico, paciente, false, false, true);
		repositorioConsulta.add(c);
		//paciente.setConsulta(c);
		System.out.println("Consulta marcada com sucesso!");
		System.out.println("Nome: "+ paciente.getNome());
		System.out.println("Especialidade: " + c.getEspecialidade());
		System.out.println("Data " + d);
		sc.close();
	}
	
	public void desmarcarConsulta(Paciente paciente){
		//if(paciente.getConsulta() != null) {
		//	paciente.setConsulta(null);
		//	System.out.println("Consulta desmarcada com sucesso");
		//}
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
	
	public String toString() {
		return "Recepcionista:\nId: " + id + "\nNome: " + nome;
	}
	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Recepcionista other = (Recepcionista) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		return true;
	}
	
	
}
