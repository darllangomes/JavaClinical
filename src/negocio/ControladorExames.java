package negocio;

import dados.SalvarArquivos;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import dados.RepositorioExames;
import dados.RepositorioUsuario;
import excecao.ExameInexistenteException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import negocio.Exame;
;

public class ControladorExames {

    private RepositorioExames repositorio;

    public ControladorExames(String file) {
        carregarDados(file);
    }

    public void cadastrar(Exame e) {
        if (e != null) {
            repositorio.cadastrarExame(e);
        } else {
            // Tratar depois, caso o usuario seja null
        }
    }

    public void descadrastar(Exame e) {

        repositorio.remover(e);
        /*if (this.repositorio.existe(id)) {
            this.repositorio.remover(id);
        } else {
            // Tratar caso usuario não exista
        }*/
    }
    
    public Exame procurar(Exame e) throws ExameInexistenteException {
        return this.repositorio.procurar(e);
    }

    public Exame procurar(String id) throws ExameInexistenteException {
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
        File arquivo = new File(file);
        FileOutputStream fos = new FileOutputStream(arquivo);
        ObjectOutputStream ous = new ObjectOutputStream(fos);
        ous.writeObject(this.repositorio.getDados());
        ous.close();
    }

    public void carregarDados(String file) {
        //repositorio.carregarArquivos();
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
                this.repositorio = new RepositorioExames((ArrayList<Exame>) ois.readObject());
                ois.close();
            } catch (IOException ex) {
                this.repositorio = new RepositorioExames(128);
            } catch (ClassNotFoundException ex) {
                this.repositorio = new RepositorioExames(128);
            }
        } catch (FileNotFoundException ex) {
            this.repositorio = new RepositorioExames(128);
        }

    }

}
