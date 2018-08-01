package dados;

import excecao.ExameInexistenteException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import negocio.Consulta;
import negocio.Exame;

public class RepositorioExames {
    
    ArrayList<Exame> exames;
    
    public RepositorioExames(int tamanho) {
        exames = new ArrayList<Exame>(tamanho);
    }
    
    public RepositorioExames(ArrayList<Exame> exames) {
        this.exames = exames;
    }
    
    public void cadastrarExame(Exame e) {
        
        try {
            procurar(e);
        } catch (ExameInexistenteException ex) {
            exames.add(e);
        }
    }
    
    //criar uma outra assinatura que Retorne um array de exames caso seja necessário listar os exames de um paciente.
    //Ass: Darllan Gomes.
    
    public Exame procurar(String id) throws ExameInexistenteException {
        int i = 0;
        Exame get = null;
        boolean continuar = true;
        for (i = 0; i < exames.size() && continuar == true; i++) {
            
            if (exames.get(i).getIdExame().equals(id)) {
                get = exames.get(i);
                continuar = false;
            }
        }
        
        if (exames.get(i) == null) {
            throw new ExameInexistenteException();
        }
        return get;
    }
    
    
    public Exame procurar(Exame e) throws ExameInexistenteException {
        int i = 0;
        Exame get = null;
        boolean continuar = true;
        for (i = 0; i < exames.size() && continuar == true; i++) {
            
            if (exames.get(i).getConsulta().getPaciente().getNome().equals(e.getNomePaciente())) {
                get = exames.get(i);
                continuar = false;
            }
        }
        
        if (exames.get(i) == null) {
            throw new ExameInexistenteException();
        }
        return get;
    }
    
    
    
    
    public ArrayList<Exame> procurar(LocalDate d) {
        ArrayList<Exame> listaExames = new ArrayList<Exame>();
        
        for (int i = 0; i < this.exames.size(); i++) {
            if (exames.get(i).getConsulta().getData().equals(d)) {
                listaExames.add(exames.get(i));
            }
        }
        
        return listaExames;
    }
    
     
    
    /*public boolean existe(String id) {
        boolean existe = false;
        int indice = this.procurarIndice(id);
        if (indice != this.ultimo) {
            existe = true;
        }
        return existe;
    }*/
    
    public void remover(Exame e) {
        exames.remove(e);
    }
    
    public ArrayList<Exame> getDados() {
        return this.exames;
    }
    
    /*public void salvarArquivos() throws FileNotFoundException, IOException {
        
        File arquivo = new File("Exames.txt");
        FileOutputStream fos = new FileOutputStream(arquivo);
        ObjectOutputStream ous = new ObjectOutputStream(fos);
        ous.writeObject(this.exames);
        ous.close();
        
    }
    
    public void carregarArquivos() throws FileNotFoundException, IOException, ClassNotFoundException {
        File arquivo = new File("Exames.txt");
        FileInputStream fis = new FileInputStream(arquivo);
        ObjectInputStream ois = new ObjectInputStream(fis);
        this.exames = (Exame[]) ois.readObject();
        ois.close();
    }*/
}
