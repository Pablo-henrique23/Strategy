# Strategy — Faturamento hospitalar

Exemplo simples do padrao **Strategy**, em Java, com tema hospitalar.

O contexto `FaturamentoHospitalar` delega o calculo de cobranca para uma implementacao de `EstrategiaCobranca`. A estrategia pode mudar durante a execucao por meio de `definirEstrategia`.

- `CobrancaParticular`: cobra 100% do valor base.
- `CobrancaConvenio`: cobra 20% de coparticipacao (percentual **ficticio**, usado apenas para demonstracao).
- `CobrancaSUS`: cobra R$ 0 do paciente (o exemplo nao modela o financiamento do SUS).

Estrutura:

```text
src/main/java/org/example/
    EstrategiaCobranca.java
    CobrancaParticular.java
    CobrancaConvenio.java
    CobrancaSUS.java
    FaturamentoHospitalar.java
src/test/java/org/example/
    FaturamentoHospitalarTest.java
diagrams/
    Strategy.puml
pom.xml
```

## Como testar

Requer **JDK 17+** e **Maven**:

```bash
mvn test
```

Nao ha `Main`: a demonstracao e feita pelos testes JUnit 5.

## Relacoes no UML

- `CobrancaParticular`, `CobrancaConvenio` e `CobrancaSUS` implementam `EstrategiaCobranca`.
- `FaturamentoHospitalar` depende da interface `EstrategiaCobranca`, nao das implementacoes concretas.
