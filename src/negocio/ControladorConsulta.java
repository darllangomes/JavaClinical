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
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControladorConsulta {

    private RepositorioConsulta repositorio;

    public ControladorConsulta(String file) {
        carregarDados(file);
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

    public ArrayList<Consulta> procurar(String id) {
        // TODO implementar
        //return this.repositorio.procurar(id);
        return this.repositorio.procurar(id);
    }
    
    public ArrayList<Consulta> procurar(LocalDate d) {
        // TODO implementar
        //return this.repositorio.procurar(id);
        return this.repositorio.procurar(d);
    }

    public Consulta procurar(String id,LocalDate d) {
        System.out.println("Id: " + id);
        System.out.println("Data: " + d);
        return this.repositorio.procurar(id,d);
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
        ous.writeObject(this.repositorio.getDados());
        ous.close();
    }

    public void carregarDados(String file) {
        //repositorio.carregarArquivo();
        /*
             * @author Danilo Araújo leitura de dados,
             * utiliza o objeto repositório direto;
         */
        File arquivo = new File(file);
        FileInputStream fis;
        ObjectInputStream ois;

        try {
            fis = new FileInputStream(arquivo);
            try {
                ois = new ObjectInputStream(fis);
                // Erro macabro
                //ArrayList<Consulta> c = (ArrayList<Consulta>) ois.readObject();
                this.repositorio = new RepositorioConsulta((ArrayList<Consulta>) ois.readObject());
                ois.close();
            } catch (IOException ex) {
                this.repositorio = new RepositorioConsulta(128);
            } catch (ClassNotFoundException ex) {
                this.repositorio = new RepositorioConsulta(128);
            }

        } catch (FileNotFoundException ex) {
            this.repositorio = new RepositorioConsulta(128);
        }
    }

    // Avaliar a necessidade de mais operações
    public String gerarProntuario(String id) {
        ArrayList<Consulta> c = this.procurar(id);
        String prontuario = "";
        for (Consulta consulta : c) {
            prontuario += consulta.toString();
            prontuario += "\n";
        }
        return prontuario;
    }
}
