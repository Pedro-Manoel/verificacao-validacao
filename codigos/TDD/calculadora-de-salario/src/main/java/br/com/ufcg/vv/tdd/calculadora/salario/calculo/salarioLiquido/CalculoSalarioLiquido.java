package br.com.ufcg.vv.tdd.calculadora.salario.calculo.salarioLiquido;

import br.com.ufcg.vv.tdd.calculadora.salario.calculo.CalculoSalario;
import br.com.ufcg.vv.tdd.calculadora.salario.model.funcionario.Funcionario;

public interface CalculoSalarioLiquido<T extends Funcionario> extends CalculoSalario<T> {}
