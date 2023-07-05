package br.com.ufcg.vv.functionalTests.avl.salarioLiquido.implementations;

import br.com.ufcg.vv.tdd.calculadora.salario.calculadora.salarioLiquido.implementations.GerenteCalculadoraSalarioLiquido;
import br.com.ufcg.vv.tdd.calculadora.salario.model.funcionario.implementations.Gerente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GerenteCalculoSalarioLiquidoAvlTest {

    private Gerente gerente;
    private GerenteCalculadoraSalarioLiquido calculadoraSalario;

    @BeforeEach
    public void setUp() {
        gerente = new Gerente("João da Silva", "joao.silva@empresa.com", 0);
        calculadoraSalario = new GerenteCalculadoraSalarioLiquido();
    }

    @Test
    public void test22() {
        gerente.setSalarioBase(-1.00);
        double salarioLiquido = calculadoraSalario.calcular(gerente);
        assertEquals(-0.80, salarioLiquido, 0.001);
    }

    @Test
    public void test23() {
        gerente.setSalarioBase(0.00);
        double salarioLiquido = calculadoraSalario.calcular(gerente);
        assertEquals(0.00, salarioLiquido, 0.001);
    }

    @Test
    public void test24() {
        gerente.setSalarioBase(1.00);
        double salarioLiquido = calculadoraSalario.calcular(gerente);
        assertEquals(0.80, salarioLiquido, 0.001);
    }

    @Test
    public void test25() {
        gerente.setSalarioBase(2500.00);
        double salarioLiquido = calculadoraSalario.calcular(gerente);
        assertEquals(2000.00, salarioLiquido, 0.001);
    }

    @Test
    public void test26() {
        gerente.setSalarioBase(4999.00);
        double salarioLiquido = calculadoraSalario.calcular(gerente);
        assertEquals(3999.20, salarioLiquido, 0.001);
    }

    @Test
    public void test27() {
        gerente.setSalarioBase(5000.00);
        double salarioLiquido = calculadoraSalario.calcular(gerente);
        assertEquals(3500.00, salarioLiquido, 0.001);
    }

    @Test
    public void test28() {
        gerente.setSalarioBase(5001.00);
        double salarioLiquido = calculadoraSalario.calcular(gerente);
        assertEquals(3500.70, salarioLiquido, 0.001);
    }
}