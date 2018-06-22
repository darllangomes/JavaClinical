package negocio;

import java.util.Random;

public class Id {
	private static Random r = new Random();
    public  static  String gerarId(int opcao) {
        String id = new String();
        
        switch (opcao) {
            case 1: // Recepcionista
                id += opcao;
                id += random();
                break;
            case 2: // Medico
                id += opcao;
                id += random();
                break;
            case 3: // Paciente
                id += opcao;
                id += random();
                break;
            default:
                break;
        }
        System.out.println("Id do Usuário: " + id);
        return id;
    }
    
    static String random() {
        String s = new  String();
        for(int i = 0; i < 3; i++) {
            s += r.nextInt(9);
        }
        return s;
    }
}