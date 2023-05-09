package br.com.ufcg.vv.functionalTests.particaoEquivalencia.salarioLiquido.implementations;

import br.com.ufcg.vv.tdd.calculadora.salario.calculadora.salarioLiquido.implementations.TestadorCalculadoraSalarioLiquido;
import br.com.ufcg.vv.tdd.calculadora.salario.model.funcionario.implementations.Testador;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestadorCalculoSalarioLiquidoParticaoEquivalenciaTest {

    private Testador testador;
    private TestadorCalculadoraSalarioLiquido calculadoraSalario;

    @BeforeEach
    public void setUp() {
        testador = new Testador("João da Silva", "joao.silva@empresa.com", 0);
        calculadoraSalario = new TestadorCalculadoraSalarioLiquido();
    }

    @Test
    public void test9() {
        testador.setSalarioBase(800.0);
        double salarioLiquido = calculadoraSalario.calcular(testador);
        assertEquals(680.0, salarioLiquido, 0.001);
    }

    @Test
    public void test10() {
        testador.setSalarioBase(2300.0);
        double salarioLiquido = calculadoraSalario.calcular(testador);
        assertEquals(1725.0, salarioLiquido, 0.001);
    }

    @Test
    public void test11() {
        testador.setSalarioBase(4200.0);
        double salarioLiquido = calculadoraSalario.calcular(testador);
        assertEquals(3150.0, salarioLiquido, 0.001);
    }

    @Test
    public void test12() {
        testador.setSalarioBase(6000.0);
        double salarioLiquido = calculadoraSalario.calcular(testador);
        assertEquals(4500.0, salarioLiquido, 0.001);
    }
}