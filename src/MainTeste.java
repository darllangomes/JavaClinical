import java.util.Scanner;
import negocio.Paciente;
import negocio.ControladorUsuario;
import negocio.Usuario;
import negocio.Recepcionista;
import dados.RepositorioConsulta;
import dados.RepositorioUsuario;
public class MainTeste {

	public static void main(String[] args) {
		Recepcionista r= new Recepcionista();
		Paciente p= new Paciente();
		System.out.println("Seja bem vindo ao sistema Java Clinical. ");
		System.out.println("Para proseguir selecione o seu tipo de usu�rio: ");
		System.out.println("1- Recepcionista \n 2- Paciente \n 3- M�dico\n");
		Scanner c = new Scanner(System.in);
		opcao= c.nextInt();
				
				switch(opcao) {
				case 1:
					r.trabalho();	
					break;
			
				case 2:
			
		}

	}
*/
}