package br.com.ufcg.vv.functionalTests.avl.salarioLiquido.implementations;

import br.com.ufcg.vv.tdd.calculadora.salario.calculadora.salarioLiquido.implementations.DbaCalculadoraSalarioLiquido;
import br.com.ufcg.vv.tdd.calculadora.salario.model.funcionario.implementations.Dba;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DbaCalculoSalarioLiquidoAvlTest {

    private Dba dba;
    private DbaCalculadoraSalarioLiquido calculadoraSalario;

    @BeforeEach
    public void setUp() {
        dba = new Dba("João da Silva", "joao.silva@empresa.com", 0);
        calculadoraSalario = new DbaCalculadoraSalarioLiquido();
    }

    @Test
    public void test8() {
        dba.setSalarioBase(-1.00);
        double salarioLiquido = calculadoraSalario.calcular(dba);
        assertEquals(-0.85, salarioLiquido, 0.001);
    }

    @Test
    public void test9() {
        dba.setSalarioBase(0.00);
        double salarioLiquido = calculadoraSalario.calcular(dba);
        assertEquals(0.00, salarioLiquido, 0.001);
    }

    @Test
    public void test10() {
        dba.setSalarioBase(1.00);
        double salarioLiquido = calculadoraSalario.calcular(dba);
        assertEquals(0.85, salarioLiquido, 0.001);
    }

    @Test
    public void test11() {
        dba.setSalarioBase(1000.00);
        double salarioLiquido = calculadoraSalario.calcular(dba);
        assertEquals(850.00, salarioLiquido, 0.001);
    }

    @Test
    public void test12() {
        dba.setSalarioBase(1999.00);
        double salarioLiquido = calculadoraSalario.calcular(dba);
        assertEquals(1699.15, salarioLiquido, 0.001);
    }

    @Test
    public void test13() {
        dba.setSalarioBase(2000.00);
        double salarioLiquido = calculadoraSalario.calcular(dba);
        assertEquals(1500.00, salarioLiquido, 0.001);
    }

    @Test
    public void test14() {
        dba.setSalarioBase(2001.00);
        double salarioLiquido = calculadoraSalario.calcular(dba);
        assertEquals(1500.75, salarioLiquido, 0.001);
    }
}