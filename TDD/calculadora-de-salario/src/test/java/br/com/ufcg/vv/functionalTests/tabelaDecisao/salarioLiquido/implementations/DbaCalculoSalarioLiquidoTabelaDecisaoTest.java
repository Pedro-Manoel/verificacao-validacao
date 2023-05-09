package br.com.ufcg.vv.functionalTests.tabelaDecisao.salarioLiquido.implementations;

import br.com.ufcg.vv.tdd.calculadora.salario.calculadora.salarioLiquido.implementations.DbaCalculadoraSalarioLiquido;
import br.com.ufcg.vv.tdd.calculadora.salario.model.funcionario.implementations.Dba;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DbaCalculoSalarioLiquidoTabelaDecisaoTest {

    private Dba dba;
    private DbaCalculadoraSalarioLiquido calculadoraSalario;

    @BeforeEach
    public void setUp() {
        dba = new Dba("João da Silva", "joao.silva@empresa.com", 0);
        calculadoraSalario = new DbaCalculadoraSalarioLiquido();
    }

    @Test
    public void testDbaSalarioBaseMenorQue2000() {
        dba.setSalarioBase(1000.0);
        double salarioLiquido = calculadoraSalario.calcular(dba);
        assertEquals(850.0, salarioLiquido, 0.001);
    }

    @Test
    public void testDbaSalarioBaseMaiorOuIgual2000() {
        dba.setSalarioBase(4000.0);
        double salarioLiquido = calculadoraSalario.calcular(dba);
        assertEquals(3000.0, salarioLiquido, 0.001);
    }
}