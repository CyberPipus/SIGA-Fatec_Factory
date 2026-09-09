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
2. **Simple Factory:** criar uma classe `FabricaPainel` com um método `criar(String tipo)` que centralize a criação e devolva um `Painel`. O `GerenciadorLogin` passa a pedir o painel à fábrica, sem usar `new` das classes concretas.
3. **Factory Method:** refatorar para um criador abstrato (por exemplo, `CriadorPainel`) com um método `criarPainel()`, e uma subclasse por perfil (`CriadorPainelAluno`, `CriadorPainelProfessor`, `CriadorPainelCoordenador`) que sobrescreve esse método. A escolha do painel passa a ser resolvida por polimorfismo.
4. **Adicionar** um novo perfil (por exemplo, `SECRETARIA`, com um `PainelSecretaria`) **sem modificar** o código existente — criando apenas as novas classes. Isso comprova o respeito ao OCP.
5. **Desenhar** o diagrama de classes da solução final (interface do produto, produtos concretos, criador e criadores concretos).

## Critério de sucesso

Ao final, deve ser possível **adicionar um novo perfil de usuário** criando apenas novas classes, **sem alterar** `GerenciadorLogin` nem os criadores existentes. Esse é o teste prático de que o Factory Method foi aplicado corretamente.

## Padrão de entrega

Conforme a ficha de atividade prática: identificadores em português, código formatado, entrega no repositório Git com README e commits descritivos. O uso de IA para gerar o código é proibido nesta atividade (ver seção 5.3 da ficha).
