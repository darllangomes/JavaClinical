package negocio;

import dados.SalvarArquivos;
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
	
	

}
