package negocio;

import dados.RepositorioUsuario;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ControladorUsuario {
	private RepositorioUsuario repositorio;
	
	public ControladorUsuario() {
		this.repositorio = new RepositorioUsuario(128);
	}
	
	public void cadastrar(Usuario u) {
		if(u != null) {
			if(!this.repositorio.existe(u.getCpf())) {
				this.repositorio.cadastrarUsuario(u);
			}
		} else {
			// Tratar depois, caso o usuario seja null
		}
	}
	
	public void descadrastar(String cpf) {
		if(this.repositorio.existe(cpf)) {
			this.repositorio.remover(cpf);
		} else {
			// Tratar caso usuario não exista
		}
	}
	
	public Usuario procurar(String id) {
		return this.repositorio.procurar(id);
	}
	
	public boolean existe(String id) {
		return repositorio.existe(id);
	}
	
        public void salvarDados () throws IOException{
            repositorio.salvarArquivos();
        }
        
        public void carregarDados() throws IOException, FileNotFoundException, ClassNotFoundException{
            repositorio.carregarArquivos();
        }
            
	// Avaliar a necessidade de mais operações
}
