package negocio;
import java.time.LocalDate;

public class Exame  {
	private String nomePaciente;
	private String nomeMedico;
	private String resultado;
	private String tipoExame;
	private Consulta consulta;
	private  LocalDate data;
        private String idPaciente;
        private String idExame;
	
	public Exame(Consulta consulta, LocalDate data){
		this.nomeMedico= consulta.getMedico().getNome();
		this.nomePaciente=consulta.getPaciente().getNome();
		this.data= consulta.getData();
	}
	public Exame () {
		
	}
	

	public String getNomePaciente() {
		return nomePaciente;
	}


	public void setNomePaciente(String nomePaciente) {
		this.nomePaciente = nomePaciente;
	}


	public String getNomeMedico() {
		return nomeMedico;
	}


	public void setNomeMedico(String nomeMedico) {
		this.nomeMedico = nomeMedico;
	}


	public LocalDate getData() {
		return data;
	}


	public void setData(LocalDate data) {
		this.data = data;
	}


	public Consulta getConsulta() {
		return consulta;
	}

	public void setConsulta(Consulta consulta) {
		this.consulta = consulta;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	@Override
	public String toString() {
		return "Paciente: " + this.getConsulta().getPaciente() + "\nData: " + this.getConsulta().getData() + "\nResultado do exame:\n" + resultado;
	}
	public String getTipoExame() {
		return tipoExame;
	}
	public void setTipoExame(String tipoExame) {
		this.tipoExame = tipoExame;
	}

    public String getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(String idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getIdExame() {
        return idExame;
    }

    public void setIdExame(String idExame) {
        this.idExame = idExame;
    }

        
        
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((consulta == null) ? 0 : consulta.hashCode());
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((nomeMedico == null) ? 0 : nomeMedico.hashCode());
		result = prime * result + ((nomePaciente == null) ? 0 : nomePaciente.hashCode());
		result = prime * result + ((resultado == null) ? 0 : resultado.hashCode());
		result = prime * result + ((tipoExame == null) ? 0 : tipoExame.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Exame other = (Exame) obj;
		if (consulta == null) {
			if (other.consulta != null)
				return false;
		} else if (!consulta.equals(other.consulta))
			return false;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (nomeMedico == null) {
			if (other.nomeMedico != null)
				return false;
		} else if (!nomeMedico.equals(other.nomeMedico))
			return false;
		if (nomePaciente == null) {
			if (other.nomePaciente != null)
				return false;
		} else if (!nomePaciente.equals(other.nomePaciente))
			return false;
		if (resultado == null) {
			if (other.resultado != null)
				return false;
		} else if (!resultado.equals(other.resultado))
			return false;
		if (tipoExame == null) {
			if (other.tipoExame != null)
				return false;
		} else if (!tipoExame.equals(other.tipoExame))
			return false;
		return true;
	}
	
}
