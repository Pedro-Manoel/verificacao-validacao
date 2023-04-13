package br.com.ufcg.vv.tdd.calculadora.salario.model;

import br.com.ufcg.vv.tdd.calculadora.salario.model.funcionario.Funcionario;
import br.com.ufcg.vv.tdd.calculadora.salario.model.funcionario.implementations.Dba;
import br.com.ufcg.vv.tdd.calculadora.salario.model.funcionario.implementations.Desenvolvedor;
import br.com.ufcg.vv.tdd.calculadora.salario.model.funcionario.implementations.Gerente;
import br.com.ufcg.vv.tdd.calculadora.salario.model.funcionario.implementations.Testador;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculaSalarioTest {

    private Funcionario desenvolvedor;
    private Funcionario dba;
    private Funcionario testador;
    private Funcionario gerente;

    @BeforeEach
    public void setUp() {
        desenvolvedor = new Desenvolvedor("João da Silva", "joao.silva@empresa.com", 0);
        dba = new Dba("João da Silva", "joao.silva@empresa.com", 0);
        testador = new Testador("João da Silva", "joao.silva@empresa.com", 0);
        gerente = new Gerente("João da Silva", "joao.silva@empresa.com", 0);
    }

    @Test
    @DisplayName("Teste para cargo DESENVOLVEDOR e salário igual a 3.000")
    public void testCalculaSalarioDesenvolvedorIgual3000() {
        desenvolvedor.setSalarioBase(3000.0);
        CalculaSalario calculaSalario = new CalculaSalario();
        double salarioLiquido = calculaSalario.calcula(desenvolvedor);
        assertEquals(2400.0, salarioLiquido);
    }

    @Test
    @DisplayName("Teste para cargo DESENVOLVEDOR e salário maior que 3.000")
    public void testCalculaSalarioDesenvolvedorMaiorQue3000() {
        desenvolvedor.setSalarioBase(4000.0);
        CalculaSalario calculaSalario = new CalculaSalario();
        double salarioLiquido = calculaSalario.calcula(desenvolvedor);
        assertEquals(3200.0, salarioLiquido);
    }

    @Test
    @DisplayName("Teste para cargo DESENVOLVEDOR e salário menor que 3.000")
    public void testCalculaSalarioDesenvolvedorMenorQue3000() {
        desenvolvedor.setSalarioBase(2000.0);
        CalculaSalario calculaSalario = new CalculaSalario();
        double salarioLiquido = calculaSalario.calcula(desenvolvedor);
        assertEquals(1800.0, salarioLiquido);
    }

    @Test
    @DisplayName("Teste para cargo DBA e salário igual a 2.000")
    public void testCalculaSalarioDbaIgual2000() {
        dba.setSalarioBase(2000.0);
        CalculaSalario calculaSalario = new CalculaSalario();
        double salarioLiquido = calculaSalario.calcula(dba);
        assertEquals(1500.0, salarioLiquido);
    }

    @Test
    @DisplayName("Teste para cargo DBA e salário maior que 2.000")
    public void testCalculaSalarioDbaMaiorQue2000() {
        dba.setSalarioBase(2500.0);
        CalculaSalario calculaSalario = new CalculaSalario();
        double salarioLiquido = calculaSalario.calcula(dba);
        assertEquals(1875, salarioLiquido);
    }

    @Test
    @DisplayName("Teste para cargo DBA e salário menor que 2.000")
    public void testCalculaSalarioDbaMenorQue2000() {
        dba.setSalarioBase(1000.0);
        CalculaSalario calculaSalario = new CalculaSalario();
        double salarioLiquido = calculaSalario.calcula(dba);
        assertEquals(850.0, salarioLiquido);
    }

    @Test
    @DisplayName("Teste para cargo TESTADOR e salário igual a 2.000")
    public void testCalculaSalarioTestadorIgual2000() {
        testador.setSalarioBase(2000.0);
        CalculaSalario calculaSalario = new CalculaSalario();
        double salarioLiquido = calculaSalario.calcula(testador);
        assertEquals(1500.0, salarioLiquido);
    }

    @Test
    @DisplayName("Teste para cargo TESTADOR e salário maior que 2.000")
    public void testCalculaSalarioTestadorMaiorQue2000() {
        testador.setSalarioBase(2500.0);
        CalculaSalario calculaSalario = new CalculaSalario();
        double salarioLiquido = calculaSalario.calcula(testador);
        assertEquals(1875.0, salarioLiquido);
    }

    @Test
    @DisplayName("Teste para cargo TESTADOR e salário menor que 2.000")
    public void testCalculaSalarioTestadorMenorQue2000() {
        testador.setSalarioBase(1000.0);
        CalculaSalario calculaSalario = new CalculaSalario();
        double salarioLiquido = calculaSalario.calcula(testador);
        assertEquals(850, salarioLiquido);
    }

    @Test
    @DisplayName("Teste para cargo GERENTE e salário igual a 5.000")
    public void testCalculaSalarioGerenteComSalarioIgual5000() {
        gerente.setSalarioBase(5000.0);
        CalculaSalario calculaSalario = new CalculaSalario();
        double salarioLiquido = calculaSalario.calcula(gerente);
        assertEquals(3500.0, salarioLiquido);
    }

    @Test
    @DisplayName("Teste para cargo GERENTE e salário maior que 5.000")
    public void testCalculaSalarioGerenteComSalarioMaiorQue5000() {
        gerente.setSalarioBase(6000.0);
        CalculaSalario calculaSalario = new CalculaSalario();
        double salarioLiquido = calculaSalario.calcula(gerente);
        assertEquals(4200.0, salarioLiquido);
    }

    @Test
    @DisplayName("Teste para cargo GERENTE e salário menor que 5.000")
    public void testCalculaSalarioGerenteComSalarioMenorQue5000() {
        gerente.setSalarioBase(4000.0);
        CalculaSalario calculaSalario = new CalculaSalario();
        double salarioLiquido = calculaSalario.calcula(gerente);
        assertEquals(3200.0, salarioLiquido);
    }
}