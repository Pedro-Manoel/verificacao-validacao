package br.com.ufcg.vv.tdd.calculadora.salario.model.calculo.salarioLiquido.implementations;

import br.com.ufcg.vv.tdd.calculadora.salario.model.calculadora.CalculadoraSalario;
import br.com.ufcg.vv.tdd.calculadora.salario.model.calculo.salarioLiquido.CalculoSalarioLiquido;
import br.com.ufcg.vv.tdd.calculadora.salario.model.funcionario.implementations.Testador;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestadorCalculoSalarioLiquidoTest {

    private Testador testador;
    private CalculoSalarioLiquido<Testador> calculoSalarioLiquido;
    private CalculadoraSalario<Testador> calculadoraSalario;

    @BeforeEach
    public void setUp() {
        testador = new Testador("João da Silva", "joao.silva@empresa.com", 0);
        calculoSalarioLiquido = new TestadorCalculoSalarioLiquido();
        calculadoraSalario = new CalculadoraSalario<>();
    }

    @Test
    @DisplayName("Teste para cargo TESTADOR e salário igual a 2.000")
    public void testCalculoSalarioLiquidoTestadorIgual2000() {
        testador.setSalarioBase(2000.0);

        double salarioLiquido = calculadoraSalario.calcular(testador, calculoSalarioLiquido);

        assertEquals(1500.0, salarioLiquido);
    }

    @Test
    @DisplayName("Teste para cargo TESTADOR e salário maior que 2.000")
    public void testCalculoSalarioLiquidoTestadorMaiorQue2000() {
        testador.setSalarioBase(2500.0);

        double salarioLiquido = calculadoraSalario.calcular(testador, calculoSalarioLiquido);

        assertEquals(1875.0, salarioLiquido);
    }

    @Test
    @DisplayName("Teste para cargo TESTADOR e salário menor que 2.000")
    public void testCalculoSalarioLiquidoTestadorMenorQue2000() {
        testador.setSalarioBase(1000.0);

        double salarioLiquido = calculadoraSalario.calcular(testador, calculoSalarioLiquido);

        assertEquals(850, salarioLiquido);
    }

}