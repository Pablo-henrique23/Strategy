package org.example;

import java.util.Objects;

public class FaturamentoHospitalar {
    private EstrategiaCobranca estrategia;

    public FaturamentoHospitalar(EstrategiaCobranca estrategia) {
        definirEstrategia(estrategia);
    }

    public void definirEstrategia(EstrategiaCobranca estrategia) {
        this.estrategia = Objects.requireNonNull(estrategia, "A estrategia nao pode ser nula");
    }

    public double calcularValor(double valorBase) {
        if (!Double.isFinite(valorBase) || valorBase < 0) {
            throw new IllegalArgumentException("O valor base deve ser um numero nao negativo");
        }
        return estrategia.calcularValor(valorBase);
    }
}
