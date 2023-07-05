package br.com.ufcg.vv.tdd.calculadora.salario.calculadora.salarioLiquido.implementations;

import br.com.ufcg.vv.tdd.calculadora.salario.calculadora.salarioLiquido.CalculadoraSalarioLiquido;
import br.com.ufcg.vv.tdd.calculadora.salario.calculo.salarioLiquido.CalculoSalarioLiquido;
import br.com.ufcg.vv.tdd.calculadora.salario.calculo.salarioLiquido.implementations.DbaCalculoSalarioLiquido;
import br.com.ufcg.vv.tdd.calculadora.salario.model.funcionario.implementations.Dba;

public class DbaCalculadoraSalarioLiquido extends CalculadoraSalarioLiquido<Dba> {

    private final CalculoSalarioLiquido<Dba> calculoSalarioLiquido;

    public DbaCalculadoraSalarioLiquido() {
        this.calculoSalarioLiquido = new DbaCalculoSalarioLiquido();
    }

    public double calcular(Dba funcionario) {
        return super.calcular(funcionario, this.calculoSalarioLiquido);
    }
}
