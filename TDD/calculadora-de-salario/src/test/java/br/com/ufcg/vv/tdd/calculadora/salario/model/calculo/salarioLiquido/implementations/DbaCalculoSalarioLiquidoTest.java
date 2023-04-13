package br.com.ufcg.vv.tdd.calculadora.salario.model.calculo.salarioLiquido.implementations;

import br.com.ufcg.vv.tdd.calculadora.salario.model.calculadora.CalculadoraSalario;
import br.com.ufcg.vv.tdd.calculadora.salario.model.calculo.salarioLiquido.CalculoSalarioLiquido;
import br.com.ufcg.vv.tdd.calculadora.salario.model.funcionario.implementations.Dba;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DbaCalculoSalarioLiquidoTest {

    private Dba dba;
    private CalculoSalarioLiquido<Dba> calculoSalarioLiquido;
    private CalculadoraSalario<Dba> calculadoraSalario;

    @BeforeEach
    public void setUp() {
        dba = new Dba("João da Silva", "joao.silva@empresa.com", 0);
        calculoSalarioLiquido = new DbaCalculoSalarioLiquido();
        calculadoraSalario = new CalculadoraSalario<>();
    }

    @Test
    @DisplayName("Teste para cargo DBA e salário igual a 2.000")
    public void testCalculoSalarioLiquidoDbaIgual2000() {
        dba.setSalarioBase(2000.0);

        double salarioLiquido = calculadoraSalario.calcular(dba, calculoSalarioLiquido);

        assertEquals(1500.0, salarioLiquido);
    }

    @Test
    @DisplayName("Teste para cargo DBA e salário maior que 2.000")
    public void testCalculaSalarioDbaMaiorQue2000() {
        dba.setSalarioBase(2500.0);

        double salarioLiquido = calculadoraSalario.calcular(dba, calculoSalarioLiquido);


        assertEquals(1875, salarioLiquido);
    }

    @Test
    @DisplayName("Teste para cargo DBA e salário menor que 2.000")
    public void testCalculaSalarioDbaMenorQue2000() {
        dba.setSalarioBase(1000.0);

        double salarioLiquido = calculadoraSalario.calcular(dba, calculoSalarioLiquido);

        assertEquals(850.0, salarioLiquido);
    }
}