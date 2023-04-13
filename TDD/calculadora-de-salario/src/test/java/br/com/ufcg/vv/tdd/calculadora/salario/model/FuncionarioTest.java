package br.com.ufcg.vv.tdd.calculadora.salario.model;

import br.com.ufcg.vv.tdd.calculadora.salario.model.funcionario.Funcionario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FuncionarioTest {

    static class FuncionarioImplTest extends Funcionario {
        public FuncionarioImplTest(String nome, String email, double salarioBase, String cargo) {
            super(nome, email, salarioBase, cargo);
        }
    }

    private String nome;
    private String email;
    private double salarioBase;
    private String cargo;
    private Funcionario funcionario;

    @BeforeEach
    void setUp() {
        nome = "João da Silva";
        email = "joao.silva@empresa.com";
        salarioBase = 2000.00;
        cargo = "DESENVOLVEDOR";
        funcionario = new FuncionarioImplTest(nome, email, salarioBase, cargo);
    }

    @Test
    @DisplayName("Teste para verificar se o nome é igual ao valor inicial")
    void testGetNome() {
        assertEquals(nome, funcionario.getNome());
    }

    @Test
    @DisplayName("Teste para verificar se o email é igual ao valor inicial")
    void testGetEmail() {
        assertEquals(email, funcionario.getEmail());
    }

    @Test
    @DisplayName("Teste para verificar se o salário-base é igual ao valor inicial")
    void testGetSalarioBase() {
        assertEquals(salarioBase, funcionario.getSalarioBase());
    }

    @Test
    @DisplayName("Teste para verificar se o cargo é igual ao valor inicial")
    void testGetCargo() {
        assertEquals(cargo, funcionario.getCargo());
    }

    @Test
    @DisplayName("Teste para verificar se o nome foi alterado corretamente")
    void testSetNome() {
        String novoNome = "Maria da Silva";

        funcionario.setNome(novoNome);
        assertEquals(novoNome, funcionario.getNome());
    }

    @Test
    @DisplayName("Teste para verificar se o email foi alterado corretamente")
    void testSetEmail() {
        String novoEmail = "maria.silva@empresa.com";

        funcionario.setEmail(novoEmail);
        assertEquals(novoEmail, funcionario.getEmail());
    }

    @Test
    @DisplayName("Teste para verificar se o salário-base foi alterado corretamente")
    void testSetSalarioBase() {
        double novoSalarioBase = 2500.00;

        funcionario.setSalarioBase(novoSalarioBase);
        assertEquals(novoSalarioBase, funcionario.getSalarioBase());
    }

    @Test
    @DisplayName("Teste para verificar se o cargo foi alterado corretamente")
    void testSetCargo() {
        String novoCargo = "DBA";

        funcionario.setCargo(novoCargo);
        assertEquals(novoCargo, funcionario.getCargo());
    }
}