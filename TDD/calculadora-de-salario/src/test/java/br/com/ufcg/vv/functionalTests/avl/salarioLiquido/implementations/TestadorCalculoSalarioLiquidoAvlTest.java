package br.com.ufcg.vv.functionalTests.avl.salarioLiquido.implementations;

import br.com.ufcg.vv.tdd.calculadora.salario.calculadora.salarioLiquido.implementations.TestadorCalculadoraSalarioLiquido;
import br.com.ufcg.vv.tdd.calculadora.salario.model.funcionario.implementations.Testador;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestadorCalculoSalarioLiquidoAvlTest {

    private Testador testador;
    private TestadorCalculadoraSalarioLiquido calculadoraSalario;

    @BeforeEach
    public void setUp() {
        testador = new Testador("João da Silva", "joao.silva@empresa.com", 0);
        calculadoraSalario = new TestadorCalculadoraSalarioLiquido();
    }

    @Test
    public void test15() {
        testador.setSalarioBase(-1.00);
        double salarioLiquido = calculadoraSalario.calcular(testador);
        assertEquals(-0.85, salarioLiquido, 0.001);
    }

    @Test
    public void test16() {
        testador.setSalarioBase(0.00);
        double salarioLiquido = calculadoraSalario.calcular(testador);
        assertEquals(0.00, salarioLiquido, 0.001);
    }

    @Test
    public void test17() {
        testador.setSalarioBase(1.00);
        double salarioLiquido = calculadoraSalario.calcular(testador);
        assertEquals(0.85, salarioLiquido, 0.001);
    }

    @Test
    public void test18() {
        testador.setSalarioBase(1000.00);
        double salarioLiquido = calculadoraSalario.calcular(testador);
        assertEquals(850.00, salarioLiquido, 0.001);
    }

    @Test
    public void test19() {
        testador.setSalarioBase(1999.00);
        double salarioLiquido = calculadoraSalario.calcular(testador);
        assertEquals(1699.15, salarioLiquido, 0.001);
    }

    @Test
    public void test20() {
        testador.setSalarioBase(2000.00);
        double salarioLiquido = calculadoraSalario.calcular(testador);
        assertEquals(1500.00, salarioLiquido, 0.001);
    }

    @Test
    public void test21() {
        testador.setSalarioBase(2001.00);
        double salarioLiquido = calculadoraSalario.calcular(testador);
        assertEquals(1500.75, salarioLiquido, 0.001);
    }
}