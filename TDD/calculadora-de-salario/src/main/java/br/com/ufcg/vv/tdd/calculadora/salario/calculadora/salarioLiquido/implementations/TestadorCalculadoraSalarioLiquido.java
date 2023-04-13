package br.com.ufcg.vv.tdd.calculadora.salario.calculadora.salarioLiquido.implementations;

import br.com.ufcg.vv.tdd.calculadora.salario.calculadora.salarioLiquido.CalculadoraSalarioLiquido;
import br.com.ufcg.vv.tdd.calculadora.salario.calculo.salarioLiquido.CalculoSalarioLiquido;
import br.com.ufcg.vv.tdd.calculadora.salario.calculo.salarioLiquido.implementations.TestadorCalculoSalarioLiquido;
import br.com.ufcg.vv.tdd.calculadora.salario.model.funcionario.implementations.Testador;

public class TestadorCalculadoraSalarioLiquido extends CalculadoraSalarioLiquido<Testador> {
    private final CalculoSalarioLiquido<Testador> calculoSalarioLiquido;

    public TestadorCalculadoraSalarioLiquido() {
        this.calculoSalarioLiquido = new TestadorCalculoSalarioLiquido();
    }

    public double calcular(Testador funcionario) {
        return super.calcular(funcionario, this.calculoSalarioLiquido);
    }
}
