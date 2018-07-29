/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package dados;
import excecao.CirurgiaInexistenteException;
import excecao.ConsultaInexistenteException;
import excecao.UsuarioInexistenteException;
import excecao.UsuarioNullException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import negocio.Usuario;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import negocio.Exame;
import negocio.Cirurgia;
import negocio.Consulta;

/**
 *
 * @author Darllan Gomes
 */
public class RepositorioCirurgias {
    ArrayList<Cirurgia> cirurgias;

    public RepositorioCirurgias(int tamanho) {
        this.cirurgias = new ArrayList<Cirurgia>(tamanho);
    }

    public RepositorioCirurgias(ArrayList<Cirurgia> cirurgias) {
        this.cirurgias = cirurgias;
    }
     public void cadastrarCirurgia(Cirurgia c) {

        try {
            procurar(c);
        } catch (CirurgiaInexistenteException ex) {
            cirurgias.add(c);
        }

    }
     
      public Cirurgia procurar(Cirurgia c) throws CirurgiaInexistenteException {
        Cirurgia get = null;
        boolean continuar = true;
        for (int i = 0; i < cirurgias.size() && continuar == true; i++) {
            get = cirurgias.get(i);
            continuar = false;
        }
        if (get == null) {
            throw new CirurgiaInexistenteException();
        }
        return c;
    }
      
       public ArrayList<Cirurgia> procurar(LocalDate d) {
        ArrayList<Cirurgia> listaCirurgias = new ArrayList<Cirurgia>();

        for (Cirurgia cirurgia : cirurgias) {
            cirurgia.getData().equals(d);
            listaCirurgias.add(cirurgia);
        }
         return listaCirurgias;
    }
       
        public void remover(Consulta c) {
        cirurgias.remove(c);
    }
        
         public ArrayList<Cirurgia> getDados() {
        return this.cirurgias;
    }
    
}
