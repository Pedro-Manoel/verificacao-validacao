package br.com.ufcg.vv.functionalTests.particaoEquivalencia.salarioLiquido.implementations;

import br.com.ufcg.vv.tdd.calculadora.salario.calculadora.salarioLiquido.implementations.DesenvolvedorCalculadoraSalarioLiquido;
import br.com.ufcg.vv.tdd.calculadora.salario.model.funcionario.implementations.Desenvolvedor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DesenvolvedorCalculoSalarioLiquidoParticaoEquivalenciaTest {

    private Desenvolvedor desenvolvedor;
    private DesenvolvedorCalculadoraSalarioLiquido calculadoraSalario;

    @BeforeEach
    public void setUp() {
        desenvolvedor = new Desenvolvedor("João da Silva", "joao.silva@empresa.com", 0);
        calculadoraSalario = new DesenvolvedorCalculadoraSalarioLiquido();
    }

    @Test
    public void test1() {
        desenvolvedor.setSalarioBase(800.0);
        double salarioLiquido = calculadoraSalario.calcular(desenvolvedor);
        assertEquals(720.0, salarioLiquido, 0.001);
    }

    @Test
    public void test2() {
        desenvolvedor.setSalarioBase(2300.0);
        double salarioLiquido = calculadoraSalario.calcular(desenvolvedor);
        assertEquals(2070.0, salarioLiquido, 0.001);
    }

    @Test
    public void test3() {
        desenvolvedor.setSalarioBase(4200.0);
        double salarioLiquido = calculadoraSalario.calcular(desenvolvedor);
        assertEquals(3360.0, salarioLiquido, 0.001);
    }

    @Test
    public void test4() {
        desenvolvedor.setSalarioBase(6000.0);
        double salarioLiquido = calculadoraSalario.calcular(desenvolvedor);
        assertEquals(4800.0, salarioLiquido, 0.001);
    }
}