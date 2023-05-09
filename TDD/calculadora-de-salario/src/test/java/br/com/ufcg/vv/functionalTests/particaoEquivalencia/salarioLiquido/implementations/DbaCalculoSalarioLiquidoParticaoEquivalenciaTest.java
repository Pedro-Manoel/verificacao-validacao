package br.com.ufcg.vv.functionalTests.particaoEquivalencia.salarioLiquido.implementations;

import br.com.ufcg.vv.tdd.calculadora.salario.calculadora.salarioLiquido.implementations.DbaCalculadoraSalarioLiquido;
import br.com.ufcg.vv.tdd.calculadora.salario.model.funcionario.implementations.Dba;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DbaCalculoSalarioLiquidoParticaoEquivalenciaTest {

    private Dba dba;
    private DbaCalculadoraSalarioLiquido calculadoraSalario;

    @BeforeEach
    public void setUp() {
        dba = new Dba("João da Silva", "joao.silva@empresa.com", 0);
        calculadoraSalario = new DbaCalculadoraSalarioLiquido();
    }

    @Test
    public void test5() {
        dba.setSalarioBase(800.0);
        double salarioLiquido = calculadoraSalario.calcular(dba);
        assertEquals(680.0, salarioLiquido, 0.001);
    }

    @Test
    public void test6() {
        dba.setSalarioBase(2300.0);
        double salarioLiquido = calculadoraSalario.calcular(dba);
        assertEquals(1725.0, salarioLiquido, 0.001);
    }

    @Test
    public void test7() {
        dba.setSalarioBase(4200.0);
        double salarioLiquido = calculadoraSalario.calcular(dba);
        assertEquals(3150.0, salarioLiquido, 0.001);
    }

    @Test
    public void test8() {
        dba.setSalarioBase(6000.0);
        double salarioLiquido = calculadoraSalario.calcular(dba);
        assertEquals(4500.0, salarioLiquido, 0.001);
    }
}