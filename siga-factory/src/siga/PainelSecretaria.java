package siga;

public class PainelSecretaria implements Painel {

    @Override
    public void montar() {
        System.out.println("=== Painel da Secretaria ===");
        System.out.println("- Gestão de alunos");
        System.out.println("- Registro de faltas");
        System.out.println("- Relatórios administrativos");
    }
}