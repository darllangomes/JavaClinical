package dados;

import excecao.ConsultaInexistenteException;
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



public class RepositorioConsulta {
	
	   ArrayList<Consulta> consultas;
	
	public RepositorioConsulta(int tamanho) {
        this.consultas = new ArrayList<Consulta>(tamanho);
    }

    public RepositorioConsulta(ArrayList<Consulta> consultas) {
        this.consultas = consultas;
    }
	
	/*public void cadastrarUsuario(String nome, String cpf, String ) {
        Usuario u = new Usuario(nome, cpf, );
        this.cadastrar(c);
    }*/
	
	public void cadastrarConsulta(Consulta c) {
            
            try {
                procurar(c);
            } catch(ConsultaInexistenteException ex) {
                consultas.add(c);
            }
            
        
    }
	
	/*
	 * Ver como tratar a busca por consulta
	 * Devolver um consulta ou um vetor de consultas do paciente
	 */
	public Consulta procurar(Consulta c) throws ConsultaInexistenteException {
            Consulta get = null;
            for (int i = 0; i < consultas.size(); i++) {
                get = consultas.get(i);
            }
            if(get == null) {
                throw new ConsultaInexistenteException();
            }
        return c;
    }
	
	public ArrayList<Consulta> procurar(LocalDate d) {
        ArrayList<Consulta>  listaConsultas = new ArrayList<Consulta>();
        
            for (Consulta consulta : consultas) {
                consulta.getData().equals(d);
                listaConsultas.add(consulta);
            }
        /*if(this.ultimo > 0) {
        	for(int i=0; i<this.consultas.length;i++) {
            	if(consultas[i].getData().equals(d)) {
            		listaConsultas.add(consultas[i]);
            	}
            }
        }*/
        return listaConsultas;
    }

	/*private int procurarIndice(String id) {
        int i = 0;
        boolean encontrado = false;
        while ((!encontrado) && (i < this.ultimo)) {
            if (id.equals(this.consultas[i].getPaciente().getId())) {
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
            if (d.equals(this.consultas[i].getData())) {
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
    }*/
	
	public void remover(Consulta c) {
            
            consultas.remove(c);
        /*int i = this.procurarIndice(cpf);
        if (i != this.ultimo) {
            this.consultas[i] = this.consultas[this.ultimo - 1];
            this.consultas[this.ultimo - 1] = null;
            this.ultimo = this.ultimo - 1;
        } else {
            // Consulta inexistente, arrumar uma forma de exibir mensagem
        	// de erro.
        }*/
    }
	
	
	
	public ArrayList<Consulta> getDados() {		
		return this.consultas;
	}
        
        /*public void salvar() throws IOException{
            
          
            File arquivo= new File("Consultas.txt");
            FileOutputStream fos = new FileOutputStream(arquivo);
            ObjectOutputStream ous = new ObjectOutputStream(fos);
            ous.writeObject(this.consultas);
            ous.close();
            
            
                
            
        }
        public void carregarArquivo() throws FileNotFoundException, IOException, ClassNotFoundException{
            File arquivo = new File("Consultas.txt");
            FileInputStream fis = new FileInputStream(arquivo);
            ObjectInputStream ois = new ObjectInputStream(fis);
            this.consultas = (Consulta[]) ois.readObject();
            ois.close();
        }*/
            
        

	
}
