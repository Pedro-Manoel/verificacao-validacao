package br.com.ufcg.vv.tdd.calculadora.salario.model.calculo.salarioLiquido.implementations;

import br.com.ufcg.vv.tdd.calculadora.salario.model.calculadora.salarioLiquido.implementations.DesenvolvedorCalculadoraSalarioLiquido;
import br.com.ufcg.vv.tdd.calculadora.salario.model.funcionario.implementations.Desenvolvedor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DesenvolvedorCalculoSalarioLiquidoTest {

    private Desenvolvedor desenvolvedor;
    private DesenvolvedorCalculadoraSalarioLiquido calculadoraSalario;

    @BeforeEach
    public void setUp() {
        desenvolvedor = new Desenvolvedor("João da Silva", "joao.silva@empresa.com", 0);
        calculadoraSalario = new DesenvolvedorCalculadoraSalarioLiquido();
    }

    @Test
    @DisplayName("Teste para cargo DESENVOLVEDOR e salário igual a 3.000")
    public void testCalculoSalarioLiquidoDesenvolvedorIgual3000() {
        desenvolvedor.setSalarioBase(3000.0);

        double salarioLiquido = calculadoraSalario.calcular(desenvolvedor);

        assertEquals(2400.0, salarioLiquido);
    }

    @Test
    @DisplayName("Teste para cargo DESENVOLVEDOR e salário maior que 3.000")
    public void testCalculoSalarioLiquidoDesenvolvedorMaiorQue3000() {
        desenvolvedor.setSalarioBase(4000.0);

        double salarioLiquido = calculadoraSalario.calcular(desenvolvedor);

        assertEquals(3200.0, salarioLiquido);
    }

    @Test
    @DisplayName("Teste para cargo DESENVOLVEDOR e salário menor que 3.000")
    public void testCalculoSalarioLiquidoDesenvolvedorMenorQue3000() {
        desenvolvedor.setSalarioBase(2000.0);

        double salarioLiquido = calculadoraSalario.calcular(desenvolvedor);

        assertEquals(1800.0, salarioLiquido);
    }
}