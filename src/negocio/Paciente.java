package negocio;

public class Paciente extends Usuario  {

	private int idade;
	//private Consulta consulta;
	private Cirurgia cirurgia;
	private Prontuario prontuario;
	
	
	
	public Paciente(String nome, String cpf, int senha) {
		this.nome = nome;
		this.cpf = cpf;
		this.senhaHash = senha;
	}
	public Paciente() {
		
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	
	public int getSenha() {
		return senhaHash;
	}
	public void setSenha(int senha) {
		this.senhaHash = senha;
	}
	public Prontuario getProntuario() {
		return prontuario;
	}
	public void setProntuario(Prontuario prontuario) {
		this.prontuario = prontuario;
	}

	/*public Consulta getConsulta() {
		return consulta;
	}*/

	/*public void setConsulta(Consulta consulta) {
		this.consulta = consulta;
	}/*/

	public Cirurgia getCirurgia() {
		return cirurgia;
	}

	public void setCirurgia(Cirurgia cirurgia) {
		this.cirurgia = cirurgia;
	}
	
	public String toString() {
		return "Paciente:\nNome: " + nome + "\nIdade: " + idade + "\nCPF: " + cpf;
	}

	

	@Override
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

	
	
	
}
