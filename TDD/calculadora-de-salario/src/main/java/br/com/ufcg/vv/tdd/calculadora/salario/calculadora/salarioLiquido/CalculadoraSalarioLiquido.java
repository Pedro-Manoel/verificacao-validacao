package br.com.ufcg.vv.tdd.calculadora.salario.calculadora.salarioLiquido;

import br.com.ufcg.vv.tdd.calculadora.salario.calculadora.CalculadoraSalario;
import br.com.ufcg.vv.tdd.calculadora.salario.calculo.salarioLiquido.CalculoSalarioLiquido;
import br.com.ufcg.vv.tdd.calculadora.salario.model.funcionario.Funcionario;

public abstract class CalculadoraSalarioLiquido<T extends Funcionario> extends CalculadoraSalario<T> {

    public double calcular(T funcionario, CalculoSalarioLiquido<T> calculoSalarioLiquido) {
        return super.calcular(funcionario, calculoSalarioLiquido);
    }
}
