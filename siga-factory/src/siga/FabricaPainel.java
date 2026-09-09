package siga;

public class FabricaPainel {
    public Painel criar(String tipo) {
        if (tipo.equals("ALUNO")) {
            return new PainelAluno();
        } else if (tipo.equals("PROFESSOR")) {
            return new PainelProfessor();
        } else if (tipo.equals("COORDENADOR")) {
            return new PainelCoordenador();
        } else {
            throw new IllegalArgumentException("Perfil desconhecido: " + tipo);
        }
    }
}
