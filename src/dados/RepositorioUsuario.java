package dados;

import excecao.UsuarioInexistenteException;
import excecao.UsuarioNullException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import negocio.Usuario;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import negocio.Exame;

public class RepositorioUsuario {

    ArrayList<Usuario> usuarios;

    public RepositorioUsuario(int tamanho) {
        this.usuarios = new ArrayList<Usuario>(tamanho);
    }

    public RepositorioUsuario(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    
    // quando for para o paciente marcar uma consulta e ele colocar o nome do médico, tem que buscar por nome.
    // o paciente não é obrigado a saber o cpf do médico.
    public void cadastrarUsuario(Usuario u) {
        try {
            procurar(u.getId());
        } catch (UsuarioNullException ex) {
            usuarios.add(u);
        }
    }

    public Usuario procurar(String id) throws UsuarioNullException {
        int i = 0;
        Usuario u = null;
        boolean continuar = true;

        for (int j = 0; j < usuarios.size() && continuar; j++) {
            if (usuarios.get(j).getId().equals(id)) {
                u = usuarios.get(j);
                continuar = false;
            }
        }

        if (u == null) {
            UsuarioNullException e = new UsuarioNullException();
            throw e;
        }
        return u;
    }

    public void remover(String id) throws UsuarioNullException {
        Usuario u = procurar(id);
        usuarios.remove(u);
    }

    /*public void salvarArquivos() throws FileNotFoundException, IOException{
            File arquivo= new File("Usuários.txt");
            FileOutputStream fos = new FileOutputStream(arquivo);
            ObjectOutputStream ous = new ObjectOutputStream(fos);
            ous.writeObject(this.usuarios);
            ous.close();
        }
        
        public void carregarArquivos() throws FileNotFoundException, IOException, ClassNotFoundException{
            File arquivo = new File("Usuários.txt");
            FileInputStream fis = new FileInputStream(arquivo);
            ObjectInputStream ois = new ObjectInputStream(fis);
            this.usuarios = (Usuario[]) ois.readObject();
            ois.close();
        }*/
    public ArrayList<Usuario> getDados() {
        return usuarios;
    }
}
