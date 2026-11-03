package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FaturamentoHospitalarTest {

    @Test
    void deveCobrarValorIntegralNoParticular() {
        FaturamentoHospitalar faturamento = new FaturamentoHospitalar(new CobrancaParticular());
        assertEquals(200.0, faturamento.calcularValor(200.0), 0.001);
    }

    @Test
    void deveCobrarCoparticipacaoNoConvenio() {
        FaturamentoHospitalar faturamento = new FaturamentoHospitalar(new CobrancaConvenio());
        assertEquals(40.0, faturamento.calcularValor(200.0), 0.001);
    }

    @Test
    void deveCobrarZeroDoPacienteNoSUS() {
        FaturamentoHospitalar faturamento = new FaturamentoHospitalar(new CobrancaSUS());
        assertEquals(0.0, faturamento.calcularValor(200.0), 0.001);
    }

    @Test
    void devePermitirTrocarAEstrategiaDuranteAExecucao() {
        FaturamentoHospitalar faturamento = new FaturamentoHospitalar(new CobrancaParticular());
        assertEquals(200.0, faturamento.calcularValor(200.0), 0.001);

        faturamento.definirEstrategia(new CobrancaConvenio());
        assertEquals(40.0, faturamento.calcularValor(200.0), 0.001);

        faturamento.definirEstrategia(new CobrancaSUS());
        assertEquals(0.0, faturamento.calcularValor(200.0), 0.001);
    }

    @Test
    void deveRejeitarValorNegativo() {
        FaturamentoHospitalar faturamento = new FaturamentoHospitalar(new CobrancaParticular());
        assertThrows(IllegalArgumentException.class, () -> faturamento.calcularValor(-1.0));
    }

    @Test
    void deveRejeitarEstrategiaNula() {
        assertThrows(NullPointerException.class, () -> new FaturamentoHospitalar(null));
    }
}
