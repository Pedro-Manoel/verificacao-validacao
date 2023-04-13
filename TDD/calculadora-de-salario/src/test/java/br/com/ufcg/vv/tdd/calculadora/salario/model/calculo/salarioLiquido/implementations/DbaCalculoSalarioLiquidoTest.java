package br.com.ufcg.vv.tdd.calculadora.salario.model.calculo.salarioLiquido.implementations;

import br.com.ufcg.vv.tdd.calculadora.salario.model.calculadora.salarioLiquido.implementations.DbaCalculadoraSalarioLiquido;
import br.com.ufcg.vv.tdd.calculadora.salario.model.funcionario.implementations.Dba;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DbaCalculoSalarioLiquidoTest {

    private Dba dba;
    private DbaCalculadoraSalarioLiquido calculadoraSalario;

    @BeforeEach
    public void setUp() {
        dba = new Dba("João da Silva", "joao.silva@empresa.com", 0);
        calculadoraSalario = new DbaCalculadoraSalarioLiquido();
    }

    @Test
    @DisplayName("Teste para cargo DBA e salário igual a 2.000")
    public void testCalculoSalarioLiquidoDbaIgual2000() {
        dba.setSalarioBase(2000.0);

        double salarioLiquido = calculadoraSalario.calcular(dba);

        assertEquals(1500.0, salarioLiquido);
    }

    @Test
    @DisplayName("Teste para cargo DBA e salário maior que 2.000")
    public void testCalculaSalarioDbaMaiorQue2000() {
        dba.setSalarioBase(2500.0);

        double salarioLiquido = calculadoraSalario.calcular(dba);


        assertEquals(1875, salarioLiquido);
    }

    @Test
    @DisplayName("Teste para cargo DBA e salário menor que 2.000")
    public void testCalculaSalarioDbaMenorQue2000() {
        dba.setSalarioBase(1000.0);

        double salarioLiquido = calculadoraSalario.calcular(dba);

        assertEquals(850.0, salarioLiquido);
    }
}