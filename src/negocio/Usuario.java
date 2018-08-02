package negocio;
import java.io.Serializable;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
public class Usuario implements Serializable {
	private String nome;
	private String cpf;
	private int senhaHash;
	private String id;
	private int idade;
        
        // TODO @author Danilo Araujo, apagar se der merda
        private SimpleStringProperty nomeColumm;
        private SimpleIntegerProperty idadeColumm;
        private SimpleStringProperty cpfColumm;
        
	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public Usuario(){
		
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setNome() {
		this.nome = nome;
	}
	public void setSenhaHash(int senha) {
		this.senhaHash = senha;
	}
	public int getSenhaHash() {
		return this.senhaHash;
	}
	
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}
        
        public void setColumms() {
            if(nomeColumm == null) {
                nomeColumm = new SimpleStringProperty(nome);
            } else {
                nomeColumm.set(nome);
            }
            
            if(idadeColumm == null) {
                idadeColumm = new SimpleIntegerProperty(idade);
            } else {
                idadeColumm.set(idade);
            }
            
            if(cpfColumm == null) {
                cpfColumm = new SimpleStringProperty(cpf);
            } else {
                cpfColumm.set(cpf);
            }
            
        }

	@Override
	public String toString() {
		return "Usuario [nome=" + nome + ", cpf=" + cpf + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + idade;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + senhaHash;
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
		Usuario other = (Usuario) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (idade != other.idade)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (senhaHash != other.senhaHash)
			return false;
		return true;
	}

	
	
}
