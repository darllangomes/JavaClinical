import java.time.LocalDate;

public class Consulta {
	LocalDate data;
	//private String especialidade;	// **************************************
	private Medico medico; 		    // Pode ser um atributo do tipo Medico
	private Paciente paciente;	    //   "   "   "   "       "  "   Paciente
	private boolean solicitacaoExame;
	private boolean solicitacaoCirurgia;
	boolean marcada;
	
	
   
	public Consulta(LocalDate data, String especialidade, Medico medico, Paciente paciente, boolean solicitacaoExame,
			boolean solicitacaoCirurgia, boolean marcada) {
		this.data = data;
		this.especialidade = especialidade;
		this.medico = medico;
		this.paciente = paciente;
		this.solicitacaoExame = solicitacaoExame;
		this.solicitacaoCirurgia = solicitacaoCirurgia;
		this.marcada = marcada;
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
		this.especialidade = especialidade;
	}
	public Medico getNomeMedico() {
		return medico;
	}
	public void setMedico(Medico nomeMedico) {
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
	public boolean isMarcada() {
		return marcada;
	}
	public void setMarcada(boolean marcada) {
		this.marcada=marcada;
	}
	
	public void marcarConsulta() {
		if(isMarcada()==false) {
			setMarcada(true);
		}
	}
	public void status() {
		System.out.println();
		System.out.println("status da consulta: "+ this.marcada);
	}
	
}
