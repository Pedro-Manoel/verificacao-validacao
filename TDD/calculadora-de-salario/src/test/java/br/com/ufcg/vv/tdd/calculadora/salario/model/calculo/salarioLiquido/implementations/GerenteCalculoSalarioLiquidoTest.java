package br.com.ufcg.vv.tdd.calculadora.salario.model.calculo.salarioLiquido.implementations;

import br.com.ufcg.vv.tdd.calculadora.salario.model.calculadora.CalculadoraSalario;
import br.com.ufcg.vv.tdd.calculadora.salario.model.calculo.salarioLiquido.CalculoSalarioLiquido;
import br.com.ufcg.vv.tdd.calculadora.salario.model.funcionario.implementations.Gerente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GerenteCalculoSalarioLiquidoTest {

    private Gerente gerente;
    private CalculoSalarioLiquido<Gerente> calculoSalarioLiquido;
    private CalculadoraSalario<Gerente> calculadoraSalario;

    @BeforeEach
    public void setUp() {
        gerente = new Gerente("João da Silva", "joao.silva@empresa.com", 0);
        calculoSalarioLiquido = new GerenteCalculoSalarioLiquido();
        calculadoraSalario = new CalculadoraSalario<>();
    }

    @Test
    @DisplayName("Teste para cargo GERENTE e salário igual a 5.000")
    public void testCalculoSalarioLiquidoGerenteComSalarioIgual5000() {
        gerente.setSalarioBase(5000.0);

        double salarioLiquido = calculadoraSalario.calcular(gerente, calculoSalarioLiquido);

        assertEquals(3500.0, salarioLiquido);
    }

    @Test
    @DisplayName("Teste para cargo GERENTE e salário maior que 5.000")
    public void testCalculoSalarioLiquidoGerenteComSalarioMaiorQue5000() {
        gerente.setSalarioBase(6000.0);

        double salarioLiquido = calculadoraSalario.calcular(gerente, calculoSalarioLiquido);

        assertEquals(4200.0, salarioLiquido);
    }

    @Test
    @DisplayName("Teste para cargo GERENTE e salário menor que 5.000")
    public void testCalculoSalarioLiquidoGerenteComSalarioMenorQue5000() {
        gerente.setSalarioBase(4000.0);

        double salarioLiquido = calculadoraSalario.calcular(gerente, calculoSalarioLiquido);

        assertEquals(3200.0, salarioLiquido);
    }

}