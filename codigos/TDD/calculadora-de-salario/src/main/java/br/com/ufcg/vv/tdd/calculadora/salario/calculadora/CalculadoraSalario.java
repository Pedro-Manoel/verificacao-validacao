package br.com.ufcg.vv.tdd.calculadora.salario.calculadora;

import br.com.ufcg.vv.tdd.calculadora.salario.calculo.CalculoSalario;
import br.com.ufcg.vv.tdd.calculadora.salario.model.funcionario.Funcionario;

public abstract class CalculadoraSalario<T extends Funcionario> {

        public double calcular(T funcionario, CalculoSalario<T> calculoSalario) {
                return calculoSalario.calcular(funcionario);
        }
}
