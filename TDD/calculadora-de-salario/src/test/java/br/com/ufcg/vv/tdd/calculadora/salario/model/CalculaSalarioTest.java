package br.com.ufcg.vv.tdd.calculadora.salario.model;

import br.com.ufcg.vv.tdd.calculadora.salario.model.calculadora.CalculadoraSalario;
import br.com.ufcg.vv.tdd.calculadora.salario.model.calculo.salarioLiquido.implementations.DesenvolvedorCalculoSalarioLiquido;
import br.com.ufcg.vv.tdd.calculadora.salario.model.funcionario.implementations.Dba;
import br.com.ufcg.vv.tdd.calculadora.salario.model.funcionario.implementations.Desenvolvedor;
import br.com.ufcg.vv.tdd.calculadora.salario.model.funcionario.implementations.Gerente;
import br.com.ufcg.vv.tdd.calculadora.salario.model.funcionario.implementations.Testador;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculaSalarioTest {

    private Desenvolvedor desenvolvedor;
    private Dba dba;
    private Testador testador;
    private Gerente gerente;

    @BeforeEach
    public void setUp() {
        desenvolvedor = new Desenvolvedor("João da Silva", "joao.silva@empresa.com", 0);
        dba = new Dba("João da Silva", "joao.silva@empresa.com", 0);
        testador = new Testador("João da Silva", "joao.silva@empresa.com", 0);
        gerente = new Gerente("João da Silva", "joao.silva@empresa.com", 0);
    }


//
//
//


}