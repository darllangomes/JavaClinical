import java.util.ArrayList;

public class MainTeste {

	public static void main(String[] args) {
		Recepcionista a= new Recepcionista("caralhow", "ANA", "aew");
		Medico m= new Medico();
		m.setEspecialidade("Ortopedia");
		Paciente p = new Paciente("Henrique", "99939394", "1234");
		
		ArrayList<Consulta> repositorioConsulta = new ArrayList<Consulta>();
		a.marcarConsulta(p, m, repositorioConsulta);
		a.desmarcarConsulta(p);
		
		a.marcarCirurgia(p);
		a.desmarcarCirurgia(p);
		
	}
}
