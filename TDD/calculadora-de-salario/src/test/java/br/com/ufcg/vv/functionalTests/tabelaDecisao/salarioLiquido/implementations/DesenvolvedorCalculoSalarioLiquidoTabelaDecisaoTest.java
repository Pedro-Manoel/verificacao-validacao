package br.com.ufcg.vv.functionalTests.tabelaDecisao.salarioLiquido.implementations;

import br.com.ufcg.vv.tdd.calculadora.salario.calculadora.salarioLiquido.implementations.DesenvolvedorCalculadoraSalarioLiquido;
import br.com.ufcg.vv.tdd.calculadora.salario.model.funcionario.implementations.Desenvolvedor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DesenvolvedorCalculoSalarioLiquidoTabelaDecisaoTest {

    private Desenvolvedor desenvolvedor;
    private DesenvolvedorCalculadoraSalarioLiquido calculadoraSalario;

    @BeforeEach
    public void setUp() {
        desenvolvedor = new Desenvolvedor("João da Silva", "joao.silva@empresa.com", 0);
        calculadoraSalario = new DesenvolvedorCalculadoraSalarioLiquido();
    }

    @Test
    public void testDesenvolvedorSalarioBaseMenorQue3000() {
        desenvolvedor.setSalarioBase(1000.0);
        double salarioLiquido = calculadoraSalario.calcular(desenvolvedor);
        assertEquals(900.0, salarioLiquido, 0.001);
    }

    @Test
    public void testDesenvolvedorSalarioBaseMaiorOuIgual3000() {
        desenvolvedor.setSalarioBase(4000.0);
        double salarioLiquido = calculadoraSalario.calcular(desenvolvedor);
        assertEquals(3200.0, salarioLiquido, 0.001);
    }
}