package br.com.ufcg.vv.tdd.calculadora.salario.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FuncionarioTest {

    private Funcionario funcionario;

    @BeforeEach
    void setUp() {
        Funcionario funcionario = new Funcionario("João da Silva", "joao.silva@empresa.com", 2000.00, "DESENVOLVEDOR");
    }

    @Test
    @DisplayName("Teste para verificar se o nome é igual ao valor inicial")
    void testGetNome() {
        assertEquals("João da Silva", funcionario.getNome());
    }

    @Test
    @DisplayName("Teste para verificar se o email é igual ao valor inicial")
    void testGetEmail() {
        assertEquals("joao.silva@empresa.com", funcionario.getEmail());
    }

    @Test
    @DisplayName("Teste para verificar se o salário-base é igual ao valor inicial")
    void testGetSalarioBase() {
        assertEquals(2000.00, funcionario.getSalarioBase());
    }

    @Test
    @DisplayName("Teste para verificar se o cargo é igual ao valor inicial")
    void testGetCargo() {
        assertEquals("DESENVOLVEDOR", funcionario.getCargo());
    }

    @Test
    @DisplayName("Teste para verificar se o nome foi alterado corretamente")
    void testSetNome() {
        funcionario.setNome("Maria da Silva");
        assertEquals("Maria da Silva", funcionario.getNome());
    }

    @Test
    @DisplayName("Teste para verificar se o email foi alterado corretamente")
    void testSetEmail() {
        funcionario.setEmail("maria.silva@empresa.com");
        assertEquals("maria.silva@empresa.com", funcionario.getEmail());
    }

    @Test
    @DisplayName("Teste para verificar se o salário-base foi alterado corretamente")
    void testSetSalarioBase() {
        funcionario.setSalarioBase(2500.00);
        assertEquals(2500.00, funcionario.getSalarioBase());
    }

    @Test
    @DisplayName("Teste para verificar se o cargo foi alterado corretamente")
    void testSetCargo() {
        funcionario.setCargo("DBA");
        assertEquals("DBA", funcionario.getCargo());
    }

}