package negocio;

import dados.SalvarArquivos;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import dados.RepositorioExames;;

public class ControladorExames {
	private RepositorioExames repositorio;
	private SalvarArquivos salva;
	
	public ControladorExames() {
		
	}
	
	public void cadastrar(Exame e) {
		if(e != null) {
			if(!this.repositorio.existe(e.getNomePaciente())) {
				this.repositorio.cadastrarExame(e);
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
	
	public Exame procurar(String id) {
		return this.repositorio.procurar(id);
	}
	
	
	public ArrayList<Exame> procurar(LocalDate d) {
		return this.repositorio.procurar(d);
	}
	
	

	public void salvarDados() throws IOException {
		// TODO Auto-generated method stub
		salva = new SalvarArquivos();
		salva.salvar(repositorio.getDados());
	}
	

}
