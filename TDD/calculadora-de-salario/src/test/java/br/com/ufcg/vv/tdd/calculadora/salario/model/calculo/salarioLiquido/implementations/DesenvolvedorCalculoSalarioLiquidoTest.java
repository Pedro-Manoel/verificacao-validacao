package br.com.ufcg.vv.tdd.calculadora.salario.model.calculo.salarioLiquido.implementations;

import br.com.ufcg.vv.tdd.calculadora.salario.model.calculadora.CalculadoraSalario;
import br.com.ufcg.vv.tdd.calculadora.salario.model.calculo.salarioLiquido.CalculoSalarioLiquido;
import br.com.ufcg.vv.tdd.calculadora.salario.model.funcionario.implementations.Desenvolvedor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DesenvolvedorCalculoSalarioLiquidoTest {

    private Desenvolvedor desenvolvedor;
    private CalculoSalarioLiquido<Desenvolvedor> calculoSalarioLiquido;
    private CalculadoraSalario<Desenvolvedor> calculadoraSalario;

    @BeforeEach
    public void setUp() {
        desenvolvedor = new Desenvolvedor("João da Silva", "joao.silva@empresa.com", 0);
        calculoSalarioLiquido = new DesenvolvedorCalculoSalarioLiquido();
        calculadoraSalario = new CalculadoraSalario<>();
    }

    @Test
    @DisplayName("Teste para cargo DESENVOLVEDOR e salário igual a 3.000")
    public void testCalculoSalarioLiquidoDesenvolvedorIgual3000() {
        desenvolvedor.setSalarioBase(3000.0);

        double salarioLiquido = calculadoraSalario.calcular(desenvolvedor, calculoSalarioLiquido);

        assertEquals(2400.0, salarioLiquido);
    }

    @Test
    @DisplayName("Teste para cargo DESENVOLVEDOR e salário maior que 3.000")
    public void testCalculoSalarioLiquidoDesenvolvedorMaiorQue3000() {
        desenvolvedor.setSalarioBase(4000.0);

        double salarioLiquido = calculadoraSalario.calcular(desenvolvedor, calculoSalarioLiquido);

        assertEquals(3200.0, salarioLiquido);
    }

    @Test
    @DisplayName("Teste para cargo DESENVOLVEDOR e salário menor que 3.000")
    public void testCalculoSalarioLiquidoDesenvolvedorMenorQue3000() {
        desenvolvedor.setSalarioBase(2000.0);

        double salarioLiquido = calculadoraSalario.calcular(desenvolvedor, calculoSalarioLiquido);

        assertEquals(1800.0, salarioLiquido);
    }

}