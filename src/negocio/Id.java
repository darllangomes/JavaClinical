public class Id {
    public  static  String gerarId(int opcao) {
        private String id;
        static Random r = new Random();
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

        private String random() {
            String s;
            for(int i = 0; i < 3; i++) {
                s += r.nextInt(9);
            }
            return s;
        }
    }
}