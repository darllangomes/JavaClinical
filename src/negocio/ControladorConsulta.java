package negocio;
import java.time.LocalDate;
import java.util.ArrayList;

import dados.RepositorioConsulta;

public class ControladorConsulta {
	private RepositorioConsulta repositorio;
	
	public ControladorConsulta() {
		this.repositorio = new RepositorioConsulta(128);
	}
	
	public void cadastrar(Consulta c) {
		if(c != null) {
			if(!this.repositorio.existe(c.getPaciente().getCpf())) {
				this.repositorio.cadastrarConsulta(c);
			}
		} else {
			// Tratar depois, caso o usuario seja null
		}
	}
	
	public void descadrastar(String id) {
		if(this.repositorio.existe(id)) {
			this.repositorio.remover(id);
		} else {
			// Tratar caso usuario não exista
		}
	}
	
	public Consulta procurar(String id) {
		return this.repositorio.procurar(id);
	}
	
	public ArrayList<Consulta> procurar(LocalDate d) {
		return this.repositorio.procurar(d);
	}
	
	// Avaliar a necessidade de mais operações
}
