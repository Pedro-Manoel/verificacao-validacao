package br.com.ufcg.vv.functionalTests.avl.salarioLiquido.implementations;

import br.com.ufcg.vv.tdd.calculadora.salario.calculadora.salarioLiquido.implementations.DesenvolvedorCalculadoraSalarioLiquido;
import br.com.ufcg.vv.tdd.calculadora.salario.model.funcionario.implementations.Desenvolvedor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DesenvolvedorCalculoSalarioLiquidoAvlTest {

    private Desenvolvedor desenvolvedor;
    private DesenvolvedorCalculadoraSalarioLiquido calculadoraSalario;

    @BeforeEach
    public void setUp() {
        desenvolvedor = new Desenvolvedor("João da Silva", "joao.silva@empresa.com", 0);
        calculadoraSalario = new DesenvolvedorCalculadoraSalarioLiquido();
    }

    @Test
    public void test1() {
        desenvolvedor.setSalarioBase(-1.00);
        double salarioLiquido = calculadoraSalario.calcular(desenvolvedor);
        assertEquals(-0.90, salarioLiquido, 0.001);
    }

    @Test
    public void test2() {
        desenvolvedor.setSalarioBase(0.00);
        double salarioLiquido = calculadoraSalario.calcular(desenvolvedor);
        assertEquals(0.00, salarioLiquido, 0.001);
    }

    @Test
    public void test3() {
        desenvolvedor.setSalarioBase(1.00);
        double salarioLiquido = calculadoraSalario.calcular(desenvolvedor);
        assertEquals(0.90, salarioLiquido, 0.001);
    }

    @Test
    public void test4() {
        desenvolvedor.setSalarioBase(1500.00);
        double salarioLiquido = calculadoraSalario.calcular(desenvolvedor);
        assertEquals(1350.00, salarioLiquido, 0.001);
    }

    @Test
    public void test5() {
        desenvolvedor.setSalarioBase(2999.00);
        double salarioLiquido = calculadoraSalario.calcular(desenvolvedor);
        assertEquals(2699.10, salarioLiquido, 0.001);
    }

    @Test
    public void test6() {
        desenvolvedor.setSalarioBase(3000.00);
        double salarioLiquido = calculadoraSalario.calcular(desenvolvedor);
        assertEquals(2400.00, salarioLiquido, 0.001);
    }

    @Test
    public void test7() {
        desenvolvedor.setSalarioBase(3001.00);
        double salarioLiquido = calculadoraSalario.calcular(desenvolvedor);
        assertEquals(2400.80, salarioLiquido, 0.001);
    }
}