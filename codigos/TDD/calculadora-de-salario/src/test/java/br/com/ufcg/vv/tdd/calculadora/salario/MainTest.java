package br.com.ufcg.vv.tdd.calculadora.salario;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MainTest {

    @Test
    @DisplayName("Teste para verificar se main está funcionando normalmente")
    void testMain() {
        Main.main(new String[0]);
    }
}