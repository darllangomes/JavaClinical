package negocio;

import dados.RepositorioUsuario;
import excecao.UsuarioExisteException;
import excecao.UsuarioNullException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControladorUsuario {

    private RepositorioUsuario repositorio;

    public ControladorUsuario(String file) {
        carregarDados(file);
    }

    public void cadastrar(Usuario u) throws UsuarioExisteException, UsuarioNullException {
        if (u != null) {
            repositorio.cadastrarUsuario(u);
            /*if (!this.repositorio.existe(u.getCpf())) {
                this.repositorio.cadastrarUsuario(u);
            } else {
                UsuarioExisteException e = new UsuarioExisteException();
                throw e;
            }*/
        } else {
            UsuarioNullException e = new UsuarioNullException();
            throw e;
        }
    }

    public void descadrastar(String id) throws UsuarioNullException {
        /*if (this.repositorio.existe(cpf)) {
            this.repositorio.remover(cpf);
        } else {
            // Tratar caso usuario não exista
        }*/
        repositorio.remover(id);
    }

    public Usuario procurar(String id) throws UsuarioNullException {
        return this.repositorio.procurar(id);
    }

    public void salvarDados(String file) throws IOException {
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
                this.repositorio = new RepositorioUsuario((ArrayList<Usuario>) ois.readObject());
                ois.close();
            } catch (IOException ex) {
                this.repositorio = new RepositorioUsuario(128);
            } catch (ClassNotFoundException ex) {
                this.repositorio = new RepositorioUsuario(128);
            }
        } catch (FileNotFoundException ex) {
            this.repositorio = new RepositorioUsuario(128);
        }
    }

    public ArrayList<Usuario> getDados() {
        return this.repositorio.getDados();
    }
    // Avaliar a necessidade de mais operações
}
