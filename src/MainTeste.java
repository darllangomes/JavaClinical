
public class MainTeste {

	public static void main(String[] args) {
		Recepcionista a= new Recepcionista("caralhow", "ANA", "aew");
		Medico m= new Medico();
		Paciente p = new Paciente("Henrique", "99939394", "1234");
		
		
		a.marcarConsulta(p);
		a.desmarcarConsulta(p);
		
		a.marcarCirurgia(p);
		a.desmarcarCirurgia(p);
}
}
