package negocio;

import java.io.IOException;
import java.time.LocalDate;
import dados.SalvarArquivos;
import java.util.ArrayList;

import dados.RepositorioConsulta;
import dados.RepositorioUsuario;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ControladorConsulta {

    private RepositorioConsulta repositorio;
    private SalvarArquivos salva;

    public ControladorConsulta() {
        this.repositorio = new RepositorioConsulta(128);
    }

    public void cadastrar(Consulta c) {
        if (c != null) {
            repositorio.cadastrarConsulta(c);
        }
        /*if(c != null) {
			if(!this.repositorio.existe(c.getPaciente().getId())) {
				this.repositorio.cadastrarConsulta(c);
			}
		} else {
			// Tratar depois, caso o usuario seja null
		}*/
    }

    public void descadrastar(String id) {
        // TODO implementar
        /*if(this.repositorio.existe(id)) {
			this.repositorio.remover(id);
		} else {
			// Tratar caso usuario não exista
		}*/
    }

    public Consulta procurar(String id) {
        // TODO implementar
        //return this.repositorio.procurar(id);
        return null;
    }

    public ArrayList<Consulta> procurar(LocalDate d) {
        return this.repositorio.procurar(d);
    }

    public void salvarDados(String file) throws IOException {
        // TODO Auto-generated method stub
        //repositorio.salvar();
        /*
             * @author Danilo Araújo salvamento de dados,
             * utiliza o objeto repositório direto;
         */
        File arquivo = new File(file);
        FileOutputStream fos = new FileOutputStream(arquivo);
        ObjectOutputStream ous = new ObjectOutputStream(fos);
        ous.writeObject(this.repositorio);
        ous.close();
    }

    public void carregarDados(String file) throws IOException, FileNotFoundException, ClassNotFoundException {
        //repositorio.carregarArquivo();
        /*
             * @author Danilo Araújo leitura de dados,
             * utiliza o objeto repositório direto;
         */
        File arquivo = new File(file);
        FileInputStream fis = new FileInputStream(arquivo);
        ObjectInputStream ois = new ObjectInputStream(fis);
        this.repositorio = (RepositorioConsulta) ois.readObject();
        ois.close();
    }

    // Avaliar a necessidade de mais operações
}
