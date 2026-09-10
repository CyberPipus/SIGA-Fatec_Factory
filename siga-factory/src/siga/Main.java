package siga;

public class Main {

    public static void main(String[] args) {
        System.out.println("=== SIGA - Atividade Factory Method ===\n");

        CriadorPainel criadorAluno = new CriadorPainelAluno();
        GerenciadorLogin loginAluno = new GerenciadorLogin(criadorAluno);   
        loginAluno.montarPainel();
        System.out.println();
        
        CriadorPainel criadorProfessor = new CriadorPainelProfessor();
        GerenciadorLogin loginProfessor = new GerenciadorLogin(criadorProfessor);
        loginProfessor.montarPainel();
        System.out.println();

        CriadorPainel criadorCoordenador = new CriadorPainelCoordenador();
        GerenciadorLogin loginCoordenador = new GerenciadorLogin(criadorCoordenador);
        loginCoordenador.montarPainel();
        System.out.println();

        CriadorPainel criadorSecretaria = new CriadorPainelSecretaria();
        GerenciadorLogin loginSecretaria = new GerenciadorLogin(criadorSecretaria);
        loginSecretaria.montarPainel();
    }
}
