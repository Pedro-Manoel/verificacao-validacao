package br.com.ufcg.vv.tdd.calculadora.salario.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FuncionarioTest {

    private Funcionario funcionario;

    @BeforeEach
    void setUp() {
        this.funcionario = new Funcionario("João da Silva", "joao.silva@empresa.com", 2000.00, "DESENVOLVEDOR");
    }

    @Test
    @DisplayName("Teste para verificar se o nome é igual ao valor inicial")
    void testGetNome() {
        assertEquals("João da Silva", this.funcionario.getNome());
    }

    @Test
    @DisplayName("Teste para verificar se o email é igual ao valor inicial")
    void testGetEmail() {
        assertEquals("joao.silva@empresa.com", this.funcionario.getEmail());
    }

    @Test
    @DisplayName("Teste para verificar se o salário-base é igual ao valor inicial")
    void testGetSalarioBase() {
        assertEquals(2000.00, this.funcionario.getSalarioBase());
    }

    @Test
    @DisplayName("Teste para verificar se o cargo é igual ao valor inicial")
    void testGetCargo() {
        assertEquals("DESENVOLVEDOR", this.funcionario.getCargo());
    }

    @Test
    @DisplayName("Teste para verificar se o nome foi alterado corretamente")
    void testSetNome() {
        this.funcionario.setNome("Maria da Silva");
        assertEquals("Maria da Silva", this.funcionario.getNome());
    }

    @Test
    @DisplayName("Teste para verificar se o email foi alterado corretamente")
    void testSetEmail() {
        this.funcionario.setEmail("maria.silva@empresa.com");
        assertEquals("maria.silva@empresa.com", this.funcionario.getEmail());
    }

    @Test
    @DisplayName("Teste para verificar se o salário-base foi alterado corretamente")
    void testSetSalarioBase() {
        this.funcionario.setSalarioBase(2500.00);
        assertEquals(2500.00, this.funcionario.getSalarioBase());
    }

    @Test
    @DisplayName("Teste para verificar se o cargo foi alterado corretamente")
    void testSetCargo() {
        this.funcionario.setCargo("DBA");
        assertEquals("DBA", this.funcionario.getCargo());
    }
}