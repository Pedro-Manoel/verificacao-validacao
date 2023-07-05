package br.com.ufcg.vv.functionalTests.tabelaDecisao.salarioLiquido.implementations;

import br.com.ufcg.vv.tdd.calculadora.salario.calculadora.salarioLiquido.implementations.GerenteCalculadoraSalarioLiquido;
import br.com.ufcg.vv.tdd.calculadora.salario.model.funcionario.implementations.Gerente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GerenteCalculoSalarioLiquidoTabelaDecisaoTest {

    private Gerente gerente;
    private GerenteCalculadoraSalarioLiquido calculadoraSalario;

    @BeforeEach
    public void setUp() {
        gerente = new Gerente("João da Silva", "joao.silva@empresa.com", 0);
        calculadoraSalario = new GerenteCalculadoraSalarioLiquido();
    }

    @Test
    public void testGerenteSalarioBaseMenorQue5000() {
        gerente.setSalarioBase(1000.0);
        double salarioLiquido = calculadoraSalario.calcular(gerente);
        assertEquals(800.0, salarioLiquido, 0.001);
    }

    @Test
    public void testGerenteSalarioBaseMaiorOuIgual5000() {
        gerente.setSalarioBase(5300.0);
        double salarioLiquido = calculadoraSalario.calcular(gerente);
        assertEquals(3710.0, salarioLiquido, 0.001);
    }
}