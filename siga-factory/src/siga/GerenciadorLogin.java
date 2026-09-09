package siga;

/**
 * Código INICIAL da atividade — contém o problema PROPOSITAL a refatorar.
 *
 * Tarefa:
 *   - Etapa 3: refatorar para o padrão Factory Method (um criador abstrato com
 *     uma subclasse por perfil, que sobrescreve o método de criação).
 *   - Etapa 4: adicionar um novo perfil (ex.: "SECRETARIA") sem modificar o
 *     código existente, comprovando o respeito ao OCP.
 */
public class GerenciadorLogin {

    public Painel montarPainel(String tipoUsuario) {

        FabricaPainel fabrica = new FabricaPainel();
        Painel painel = fabrica.criar(tipoUsuario);
        painel.montar();

        return painel;
    }
}
