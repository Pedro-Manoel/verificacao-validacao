package br.com.ufcg.vv.tdd.calculadora.salario.model.calculadora.salarioLiquido;

import br.com.ufcg.vv.tdd.calculadora.salario.model.calculadora.CalculadoraSalario;
import br.com.ufcg.vv.tdd.calculadora.salario.model.calculo.salarioLiquido.CalculoSalarioLiquido;
import br.com.ufcg.vv.tdd.calculadora.salario.model.funcionario.Funcionario;

public abstract class CalculadoraSalarioLiquido<T extends Funcionario> extends CalculadoraSalario<T> {

    public double calcular(T funcionario, CalculoSalarioLiquido<T> calculoSalarioLiquido) {
        return calculoSalarioLiquido.calcular(funcionario);
    }
}
