/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;
import dados.RepositorioCirurgias;
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
/**
 *
 * @author Darllan Gomes
 */
public class ControladorCirurgias {
     private RepositorioCirurgias repositorio;
     
     
      public ControladorCirurgias(String file) {
        carregarDados(file);
    }

    public void cadastrar(Cirurgia c) {
        if (c != null) {
            repositorio.cadastrarCirurgia(c);
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

    public Cirurgia procurar(String id) {
        // TODO implementar
        //return this.repositorio.procurar(id);
        return null;
    }

    public ArrayList<Cirurgia> procurar(LocalDate d) {
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
                this.repositorio = new RepositorioCirurgias((ArrayList<Cirurgia>) ois.readObject());
                ois.close();
            } catch (IOException ex) {
                this.repositorio = new RepositorioCirurgias(128);
            } catch (ClassNotFoundException ex) {
                this.repositorio = new RepositorioCirurgias(128);
            }

        } catch (FileNotFoundException ex) {
            this.repositorio = new RepositorioCirurgias(128);
        }
    }

   
}
