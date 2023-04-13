package br.com.ufcg.vv.tdd.calculadora.salario.model.calculadora;

import br.com.ufcg.vv.tdd.calculadora.salario.model.calculo.CalculoSalario;
import br.com.ufcg.vv.tdd.calculadora.salario.model.funcionario.Funcionario;

public class CalculadoraSalario<T extends Funcionario> {

        public double calcular(T funcionario, CalculoSalario<T> calculoSalario) {
                return calculoSalario.calcular(funcionario);
        }
}
