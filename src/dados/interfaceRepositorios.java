package dados;

import java.time.LocalDate;
import java.util.ArrayList;

import negocio.Consulta;

public interface interfaceRepositorios {
	
	 Consulta procurar(String id);
	 ArrayList<Consulta> procurar(LocalDate d);
    int procurarIndice();
    public void remover(String cpf);
     void duplicarLimite();
     public boolean existe(String id);
	 

}
