package negocio;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.Serializable;

public class Recepcionista extends Usuario implements Serializable{
	
	
	
	public Recepcionista() {
		super();
	}

	@Override
	public String toString() {
		return "Recepcionista [nome=" + this.getNome() + ", cpf=" + this.getCpf() + "\nID: " + this.getId() + "]";
	}
}
