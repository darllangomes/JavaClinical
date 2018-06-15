package dados;

import negocio.Usuario;

public class RepositorioUsuario {
	private Usuario[] usuarios;
	private int ultimo;
	
	public RepositorioUsuario(int tamanho) {
		this.usuarios = new Usuario[tamanho];
		this.ultimo = 0;
	}
	
	
	
	public void cadastrarUsuario(Usuario u) {
		this.usuarios[ultimo] = u;
		this.ultimo += 1;
		if(this.ultimo == this.usuarios.length) {
			this.duplicarLimite();
		}
	}
	
	public Usuario procurar(String cpf) {
        int i = this.procurarIndice(cpf);
        Usuario u = null;
        if (i != this.ultimo) {
            u = this.usuarios[i];
        }
        return u;
    }

	private int procurarIndice(String cpf) {
        int i = 0;
        boolean encontrado = false;
        while ((!encontrado) && (i < this.ultimo)) {
            if (cpf.equals(this.usuarios[i].getCpf())) {
                encontrado = true;
            } else {
                i = i + 1;
            }
        }
        return i;
    }
	
	public boolean existe(String cpf) {
        boolean existe = false;
        int indice = this.procurarIndice(cpf);
        if (indice != this.ultimo) {
            existe = true;
        }
        return existe;
    }
	
	public void remover(String cpf) {
        int i = this.procurarIndice(cpf);
        if (i != this.ultimo) {
            this.usuarios[i] = this.usuarios[this.ultimo - 1];
            this.usuarios[this.ultimo - 1] = null;
            this.ultimo = this.ultimo - 1;
        } else {
            // Usuario inexistente, arrumar uma forma de exibir mensagem
        	// de erro.
        }
    }
	
	private void duplicarLimite() {
		if (this.usuarios != null && this.usuarios.length > 0) {
            Usuario[] aux = new Usuario[this.usuarios.length * 2];
            for (int i = 0; i < this.usuarios.length; i++) {
                aux[i] = this.usuarios[i];
            }
            this.usuarios = aux;
        }
		
	}
}
