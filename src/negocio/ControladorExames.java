package negocio;

import dados.SalvarArquivos;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import dados.RepositorioExames;import dados.RepositorioUsuario;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
;

public class ControladorExames {
	private RepositorioExames repositorio;

        
public ControladorExames() {
     repositorio= new RepositorioExames(128);               
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
	
	

	public void salvarDados(String file) throws IOException {
		// TODO Auto-generated method stub
		//repositorio.salvarArquivos();
                /*
             * @author Danilo Araújo salvamento de dados,
             * utiliza o objeto repositório direto;
             */
            File arquivo= new File(file);
            FileOutputStream fos = new FileOutputStream(arquivo);
            ObjectOutputStream ous = new ObjectOutputStream(fos);
            ous.writeObject(this.repositorio);
            ous.close();
	}
        public void carregarDados(String file) throws IOException, FileNotFoundException, ClassNotFoundException{
            //repositorio.carregarArquivos();
            /*
             * @author Danilo Araújo leitura de dados,
             * utiliza o objeto repositório direto;
             */
            File arquivo = new File(file);
            FileInputStream fis = new FileInputStream(arquivo);
            ObjectInputStream ois = new ObjectInputStream(fis);
            this.repositorio = (RepositorioExames) ois.readObject();
            ois.close();
        }
	

}
