package siga;

public class GerenciadorLogin {
    private final CriadorPainel criador;

    public GerenciadorLogin(CriadorPainel criador) {
        this.criador = criador;
    }
    public Painel montarPainel() {
        return criador.montarPainel();
    }
}
