import java.time.LocalDate;

public class Consulta {
	LocalDate data;	
	private Medico medico;
	private Paciente paciente;
	private boolean solicitacaoExame;
	private boolean solicitacaoCirurgia;
	
	public Consulta(LocalDate data, Medico medico, Paciente paciente) {
		this.data = data;
		this.medico = medico;
		this.paciente = paciente;
		this.solicitacaoExame = false;
		this.solicitacaoCirurgia = false;
	}
   
	public Consulta(LocalDate data, String especialidade, Medico medico, Paciente paciente, boolean solicitacaoExame,
			boolean solicitacaoCirurgia, boolean marcada) {
		this.data = data;
		this.medico = medico;
		this.paciente = paciente;
		this.solicitacaoExame = solicitacaoExame;
		this.solicitacaoCirurgia = solicitacaoCirurgia;
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
	public boolean isSolicitacaoExame() {
		return solicitacaoExame;
	}
	public void setSolicitacaoExame(boolean solicitacaoExame) {
		this.solicitacaoExame = solicitacaoExame;
	}
	public boolean isSolicitacaoCirurgia() {
		return solicitacaoCirurgia;
	}
	public void setSolicitacaoCirurgia(boolean solicitacaoCirurgia) {
		this.solicitacaoCirurgia = solicitacaoCirurgia;
	}

	public String toString() {
		return "Consulta:\n" + data + "\n" + medico + "\n" + paciente + "\nSolicitação de Exame: "
				+ solicitacaoExame + "\nSolicitaço de Cirurgia: " + solicitacaoCirurgia;
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
		if (solicitacaoCirurgia != other.solicitacaoCirurgia)
			return false;
		if (solicitacaoExame != other.solicitacaoExame)
			return false;
		return true;
	}
}
