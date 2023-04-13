package br.com.ufcg.vv.tdd.calculadora.salario.model.calculo.salarioLiquido;

import br.com.ufcg.vv.tdd.calculadora.salario.model.calculo.CalculoSalario;
import br.com.ufcg.vv.tdd.calculadora.salario.model.funcionario.Funcionario;

public interface CalculoSalarioLiquido<T extends Funcionario> extends CalculoSalario<T> {}
