package dados;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import negocio.Consulta;

public class SalvarArquivos {
	
	public void salvar(Consulta[] consultas) throws IOException {
		FileWriter arq = new FileWriter("tabuada.txt");
		PrintWriter gravarArq = new PrintWriter(arq);
		if(consultas == null) {
			System.out.println("Dados de consulta vazio");
			arq.close();
			return;
		}
		gravarArq.print(consultas);
		arq.close();
	}
}
