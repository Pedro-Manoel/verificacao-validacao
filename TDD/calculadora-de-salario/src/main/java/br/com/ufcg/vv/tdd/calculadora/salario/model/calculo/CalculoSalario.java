package br.com.ufcg.vv.tdd.calculadora.salario.model.calculo;

import br.com.ufcg.vv.tdd.calculadora.salario.model.funcionario.Funcionario;

public interface CalculoSalario<T extends Funcionario> {
    double calcular(T funcionario);
}
