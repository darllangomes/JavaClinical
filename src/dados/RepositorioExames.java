package dados;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.io.Serializable;
import negocio.Consulta;
import negocio.Exame;

public class RepositorioExames implements Serializable {
	private Exame exames[];
	private int ultimo;
	
	public RepositorioExames(int tamanho) {
		this.exames = new Exame[tamanho];
		this.ultimo = 0;
	}
	
	public void cadastrarExame(Exame e) {
		this.exames[ultimo] = e;
		this.ultimo += 1;
		if(this.ultimo == this.exames.length) {
			this.duplicarLimite();
		}

	}
	public Exame procurar(String id) {
        int i = this.procurarIndice(id);
        Exame e = null;
        if (i != this.ultimo) {
            e = this.exames[i];
        }
        return e;
    }
	
	public ArrayList<Exame> procurar(LocalDate d) {
        ArrayList<Exame>  listaExames = new ArrayList();
        if(this.ultimo > 0) {
        	for(int i=0; i<this.exames.length;i++) {
            	if(exames[i].getConsulta().getData().equals(d)) {
            		listaExames.add(exames[i]);
            	}
            }
        }
        return listaExames;
    }
	
	private int procurarIndice(String id) {
        int i = 0;
        boolean encontrado = false;
        while ((!encontrado) && (i < this.ultimo)) {
            if (id.equals(this.exames[i].getConsulta().getPaciente().getId())) {
                encontrado = true;
            } else {
                i = i + 1;
            }
        }
        return i;
    }
	
	
	private int procurarIndice(LocalDate d) {
        int i = 0;
        boolean encontrado = false;
        while ((!encontrado) && (i < this.ultimo)) {
            if (d.equals(this.exames[i].getConsulta().getData())) {
                encontrado = true;
            } else {
                i = i + 1;
            }
        }
        return i;
    }
	
	public boolean existe(String id) {
        boolean existe = false;
        int indice = this.procurarIndice(id);
        if (indice != this.ultimo) {
            existe = true;
        }
        return existe;
    }
	
	public void remover(String cpf) {
        int i = this.procurarIndice(cpf);
        if (i != this.ultimo) {
            this.exames[i] = this.exames[this.ultimo - 1];
            this.exames[this.ultimo - 1] = null;
            this.ultimo = this.ultimo - 1;
        } else {
            // Consulta inexistente, arrumar uma forma de exibir mensagem
        	// de erro.
        }
    }
	
	private void duplicarLimite() {
		if (this.exames != null && this.exames.length > 0) {
            Exame[] aux = new Exame[this.exames.length * 2];
            for (int i = 0; i < this.exames.length; i++) {
                aux[i] = this.exames[i];
            }
            this.exames = aux;
        }
		
	}
	
	public Exame[] getDados() {		
		return this.exames;
	}
	
        public void salvarArquivos() throws FileNotFoundException, IOException{
            
            File arquivo= new File("Exames.txt");
            FileOutputStream fos = new FileOutputStream(arquivo);
            ObjectOutputStream ous = new ObjectOutputStream(fos);
            ous.writeObject(this.exames);
            ous.close();
            
                    
        }
        
        public void carregarArquivos() throws FileNotFoundException, IOException, ClassNotFoundException{
            File arquivo = new File("Exames.txt");
            FileInputStream fis = new FileInputStream(arquivo);
            ObjectInputStream ois = new ObjectInputStream(fis);
            this.exames = (Exame[]) ois.readObject();
            ois.close();
        }
}
