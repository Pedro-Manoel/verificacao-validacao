package br.com.ufcg.vv.functionalTests.tabelaDecisao.salarioLiquido.implementations;

import br.com.ufcg.vv.tdd.calculadora.salario.calculadora.salarioLiquido.implementations.TestadorCalculadoraSalarioLiquido;
import br.com.ufcg.vv.tdd.calculadora.salario.model.funcionario.implementations.Testador;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestadorCalculoSalarioLiquidoTabelaDecisaoTest {

    private Testador testador;
    private TestadorCalculadoraSalarioLiquido calculadoraSalario;

    @BeforeEach
    public void setUp() {
        testador = new Testador("João da Silva", "joao.silva@empresa.com", 0);
        calculadoraSalario = new TestadorCalculadoraSalarioLiquido();
    }

    @Test
    public void testTestadorSalarioBaseMenorQue2000() {
        testador.setSalarioBase(1000.0);
        double salarioLiquido = calculadoraSalario.calcular(testador);
        assertEquals(850.0, salarioLiquido, 0.001);
    }

    @Test
    public void testTestadorSalarioBaseMaiorOuIgual2000() {
        testador.setSalarioBase(4000.0);
        double salarioLiquido = calculadoraSalario.calcular(testador);
        assertEquals(3000.0, salarioLiquido, 0.001);
    }
}