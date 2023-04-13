package br.com.ufcg.vv.tdd.calculadora.salario.model.calculo.salarioLiquido.implementations;

import br.com.ufcg.vv.tdd.calculadora.salario.model.calculadora.salarioLiquido.implementations.TestadorCalculadoraSalarioLiquido;
import br.com.ufcg.vv.tdd.calculadora.salario.model.funcionario.implementations.Testador;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestadorCalculoSalarioLiquidoTest {

    private Testador testador;
    private TestadorCalculadoraSalarioLiquido calculadoraSalario;

    @BeforeEach
    public void setUp() {
        testador = new Testador("João da Silva", "joao.silva@empresa.com", 0);
        calculadoraSalario = new TestadorCalculadoraSalarioLiquido();
    }

    @Test
    @DisplayName("Teste para cargo TESTADOR e salário igual a 2.000")
    public void testCalculoSalarioLiquidoTestadorIgual2000() {
        testador.setSalarioBase(2000.0);

        double salarioLiquido = calculadoraSalario.calcular(testador);

        assertEquals(1500.0, salarioLiquido);
    }

    @Test
    @DisplayName("Teste para cargo TESTADOR e salário maior que 2.000")
    public void testCalculoSalarioLiquidoTestadorMaiorQue2000() {
        testador.setSalarioBase(2500.0);

        double salarioLiquido = calculadoraSalario.calcular(testador);

        assertEquals(1875.0, salarioLiquido);
    }

    @Test
    @DisplayName("Teste para cargo TESTADOR e salário menor que 2.000")
    public void testCalculoSalarioLiquidoTestadorMenorQue2000() {
        testador.setSalarioBase(1000.0);

        double salarioLiquido = calculadoraSalario.calcular(testador);

        assertEquals(850, salarioLiquido);
    }
}