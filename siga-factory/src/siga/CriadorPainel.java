package siga;

public abstract class CriadorPainel {
    public abstract Painel criarPainel();

    public Painel montarPainel() {
        Painel painel = criarPainel();
        painel.montar();
        return painel;
    }
}
