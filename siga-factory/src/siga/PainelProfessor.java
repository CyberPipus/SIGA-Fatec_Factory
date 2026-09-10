package siga;

public class PainelProfessor implements Painel {

    @Override
    public void montar() {
        System.out.println("=== Painel do Professor ===");
        System.out.println("- Minhas turmas");
        System.out.println("- Lançamento de notas");
        System.out.println("- Diário de classe");
    }
}
