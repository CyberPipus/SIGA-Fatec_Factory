# SIGA — Atividade Factory: painéis por perfil (código inicial)

**Técnicas de Programação II (TP2) · Aula 5** — CST em Desenvolvimento de Software Multiplataforma · Fatec de Porto Ferreira

Este é o **código inicial** da atividade prática da Aula 5. Ele contém, de forma **proposital**, o problema da criação direta de objetos com `if/else` e `new`, que você deverá encapsular aplicando a **Simple Factory** e o padrão **Factory Method**. O programa compila e executa — o problema não é o funcionamento, e sim a resistência do código à mudança.

## Estrutura do projeto

```
siga-factory/
├── README.md
└── src/
    └── siga/
        ├── Painel.java            (interface — o "Produto"; já pronta)
        ├── PainelAluno.java       (produto concreto; já pronto)
        ├── PainelProfessor.java   (produto concreto; já pronto)
        ├── PainelCoordenador.java (produto concreto; já pronto)
        ├── GerenciadorLogin.java  (contém o if/else + new a refatorar)
        └── Main.java              (demonstra o problema em execução)
```

## Como compilar e executar

Pré-requisito: JDK 17 ou superior (`java -version` para verificar).

```bash
# 1. Compilar (a saída vai para a pasta "bin")
javac -d bin src/siga/*.java

# 2. Executar
java -cp bin siga.Main
```

## O problema proposital

| Arquivo | O que está errado |
|---|---|
| `GerenciadorLogin.java` | `montarPainel` usa `if/else` com `new` das classes concretas. Cada novo perfil exige modificar o método, violando o **OCP** e acoplando a classe a todos os painéis concretos. |

## Sua tarefa

Siga as etapas da ficha de atividade prática:

1. **Identificar** o acoplamento causado pelo `if/else` com `new` em `GerenciadorLogin`.
R: No arquivo "GerenciadorLogin" temos o acoplamento de três classes concretas ("PainelAluno","PainelCoordenador" e "PainelProfessor") pelas instanciações diretas ("new") dentro de uma condicional, já violando o princípio Aberto/Fechado. Ou seja, se adicionarmos uma nova classe, por exemplo "PainelSecretaria", teríamos de abrir "GerenciadorLogin" para adicionar mais uma instanciação direta na condicional, comprovando que esta classe não está fechada, e realizar uma alteração em "Main", porém esta estaria prevista pela lógica de negócio então não é indevida. Além do mais o arquivo somente precisa do tipo "Painel" para poder chamar "montar()" e as classes concretas aparecem ali apenas por causa do "new", sendo que o uso já é abstrato, a criação delas que não é. Por fim temos "String tipoUsuario" representando por texto livre o conceito de domínio no perfil, o que faz uma digitação errônea de "PROFESOR" compilar sem erro e somente falhando em execução ao cair no "else".
2. **Simple Factory:** criar uma classe `FabricaPainel` com um método `criar(String tipo)` que centralize a criação e devolva um `Painel`. O `GerenciadorLogin` passa a pedir o painel à fábrica, sem usar `new` das classes concretas.
R: Criamos a classe "FabricaPainel" via "Simple Factory" para "GerenciadorLogin" não ser mais responsável por criar os painéis ao removermos o "new" das classes concretas de seu código e forçá-lo a trabalhar somente com "Painel", reduzindo a menção de 4 tipos para somente 2. Todavia, ainda não satisfazemos o OCP: a fábrica continua sendo modificada a cada perfil novo, porque a escolha ainda é feita por comparação, ou seja, se quisermos inserir uma classe nova como "PainelSecretaria", somos obrigados a reabrir "FabricaPainel" para contemplar a nova classe.
3. **Factory Method:** refatorar para um criador abstrato (por exemplo, `CriadorPainel`) com um método `criarPainel()`, e uma subclasse por perfil (`CriadorPainelAluno`, `CriadorPainelProfessor`, `CriadorPainelCoordenador`) que sobrescreve esse método. A escolha do painel passa a ser resolvida por polimorfismo.
R: Agora temos a classe abstrata "CriadorPainel" com dois métodos: um abstrato para criar painéis e um concreto para chamar o método abstrato e armazenar o resultado em uma variável (neste caso "painel" do tipo "Painel") e depois chama o método para montar nosso painel,  assim como 3 subclasses ("CriadorPainelALuno", "CriadorPainelProfessor" e "CriadorPainelCoordenador") destinadas a sobrescrever o método abstrato da superclasse para retornarem um tipo de painel específico. Com isso, deixamos a decisão a cargo do arquivo "Main" no momento da construção. Em "new CriadorPainelAluno()" decidimos qual criador precisamos, digamos "criadorAluno", enquanto "new GerenciadorLogin()"  vincula o criador decidido anteriormente à sessão de login correspondente: a do aluno, libertando o código de comparar algo toda vez que for executado ao registrar a decisão no tipo de objeto correspondente ao que chamamos. Também resolvemos definitivamente a questão de violação ao OCP da Etapa 2, na qual precisávamos reabrir "FabricaPainel", nesta etapa. Uma vez que se quisermos adicionar um novo perfil, digamos "Secretaria", não há a necessidade de se abrir nenhuma classe pré-existente para modificação, somente adicionar linhas de código no "Main" para exibir o novo painel, lembrando que isto é previsto e não errôneo, e garantir que os arquivos "PainelSecretaria" e "CriadorPainelSecretaria" estejam na pasta "siga-factory/src/siga". 
4. **Adicionar** um novo perfil (por exemplo, `SECRETARIA`, com um `PainelSecretaria`) **sem modificar** o código existente — criando apenas as novas classes. Isso comprova o respeito ao OCP.
5. **Desenhar** o diagrama de classes da solução final (interface do produto, produtos concretos, criador e criadores concretos).

## Critério de sucesso

Ao final, deve ser possível **adicionar um novo perfil de usuário** criando apenas novas classes, **sem alterar** `GerenciadorLogin` nem os criadores existentes. Esse é o teste prático de que o Factory Method foi aplicado corretamente.

## Padrão de entrega

Conforme a ficha de atividade prática: identificadores em português, código formatado, entrega no repositório Git com README e commits descritivos. O uso de IA para gerar o código é proibido nesta atividade (ver seção 5.3 da ficha).
