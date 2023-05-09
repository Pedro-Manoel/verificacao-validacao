package br.com.ufcg.vv.functionalTests.particaoEquivalencia.salarioLiquido.implementations;

import br.com.ufcg.vv.tdd.calculadora.salario.calculadora.salarioLiquido.implementations.GerenteCalculadoraSalarioLiquido;
import br.com.ufcg.vv.tdd.calculadora.salario.model.funcionario.implementations.Gerente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GerenteCalculoSalarioLiquidoParticaoEquivalenciaTest {

    private Gerente gerente;
    private GerenteCalculadoraSalarioLiquido calculadoraSalario;

    @BeforeEach
    public void setUp() {
        gerente = new Gerente("João da Silva", "joao.silva@empresa.com", 0);
        calculadoraSalario = new GerenteCalculadoraSalarioLiquido();
    }

    @Test
    public void test13() {
        gerente.setSalarioBase(800.0);
        double salarioLiquido = calculadoraSalario.calcular(gerente);
        assertEquals(640.0, salarioLiquido, 0.001);
    }

    @Test
    public void test14() {
        gerente.setSalarioBase(2300.0);
        double salarioLiquido = calculadoraSalario.calcular(gerente);
        assertEquals(1840.0, salarioLiquido, 0.001);
    }

    @Test
    public void test15() {
        gerente.setSalarioBase(4200.0);
        double salarioLiquido = calculadoraSalario.calcular(gerente);
        assertEquals(3360.0, salarioLiquido, 0.001);
    }

    @Test
    public void test16() {
        gerente.setSalarioBase(6000.0);
        double salarioLiquido = calculadoraSalario.calcular(gerente);
        assertEquals(4200.0, salarioLiquido, 0.001);
    }
}