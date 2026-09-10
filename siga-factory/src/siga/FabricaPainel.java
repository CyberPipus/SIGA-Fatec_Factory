// Aqui temos um artefato de nosso progresso, mas não é mais necessário. A fábrica de painéis foi substituída pelo 
// padrão Factory Method, que é mais flexível e extensível. Portanto, este código foi comentado para indicar que 
// não será mais utilizado, mas ainda está presente para referência histórica.
//
//package siga;
//
//public class FabricaPainel {
//    public Painel criar(String tipo) {
//        if (tipo.equals("ALUNO")) {
//            return new PainelAluno();
//        } else if (tipo.equals("PROFESSOR")) {
//            return new PainelProfessor();
//        } else if (tipo.equals("COORDENADOR")) {
//            return new PainelCoordenador();
//        } else {
//            throw new IllegalArgumentException("Perfil desconhecido: " + tipo);
//        }
//    }
//}
