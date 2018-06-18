package negocio;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Recepcionista extends Usuario{
	
	
	
	public Recepcionista() {
		super();
	}

	@Override
	public String toString() {
		return "Recepcionista [nome=" + nome + ", cpf=" + cpf + "]";
	}

	public void trabalho() {
		System.out.println("1- cadastrar Paciente \n 2- marcar consulta \n 3- marcar cirurgia \n 4- acessar prontuário");
		Scanner op= new Scanner(System.in);
		int option= op.nextInt();
		
			switch(option) {
			case 1:
				GetInformation g= new GetInformation();
				g.workPacientes();
				break;
			case 2:
			//	g.workConsultas(p);
				
			
		}
		
		
		
	}
	

/*
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
			System.out.println("Consulta desmarcada com sucesso");
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
	*/
	
	
	
	
	
	
	
}
