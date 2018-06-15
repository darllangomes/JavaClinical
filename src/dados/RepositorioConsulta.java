package dados;

import negocio.Consulta;

public class RepositorioConsulta {
	
	private Consulta[] consultas;
	private int ultimo;
	
	public RepositorioConsulta(int tamanho) {
		this.consultas = new Consulta[tamanho];
		this.ultimo = 0;
	}
	
	/*public void cadastrarUsuario(String nome, String cpf, String ) {
        Usuario u = new Usuario(nome, cpf, );
        this.cadastrar(c);
    }*/
	
	public void cadastrarConsulta(Consulta u) {
		this.consultas[ultimo] = u;
		this.ultimo += 1;
		if(this.ultimo == this.consultas.length) {
			this.duplicarLimite();
		}
	}
	
	/*
	 * Ver como tratar a busca por consulta
	 * Devolver um consulta ou um vetor de consultas do paciente
	 */
	public Consulta procurar(String cpf) {
        int i = this.procurarIndice(cpf);
        Consulta c = null;
        if (i != this.ultimo) {
            c = this.consultas[i];
        }
        return c;
    }

	private int procurarIndice(String cpf) {
        int i = 0;
        boolean encontrado = false;
        while ((!encontrado) && (i < this.ultimo)) {
            if (cpf.equals(this.consultas[i].getPaciente().getCpf())) {
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
            this.consultas[i] = this.consultas[this.ultimo - 1];
            this.consultas[this.ultimo - 1] = null;
            this.ultimo = this.ultimo - 1;
        } else {
            // Consulta inexistente, arrumar uma forma de exibir mensagem
        	// de erro.
        }
    }
	
	private void duplicarLimite() {
		if (this.consultas != null && this.consultas.length > 0) {
            Consulta[] aux = new Consulta[this.consultas.length * 2];
            for (int i = 0; i < this.consultas.length; i++) {
                aux[i] = this.consultas[i];
            }
            this.consultas = aux;
        }
		
	}
}
