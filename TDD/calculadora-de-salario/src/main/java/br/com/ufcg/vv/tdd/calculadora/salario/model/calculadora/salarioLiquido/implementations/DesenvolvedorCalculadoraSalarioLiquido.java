package br.com.ufcg.vv.tdd.calculadora.salario.model.calculadora.salarioLiquido.implementations;

import br.com.ufcg.vv.tdd.calculadora.salario.model.calculadora.salarioLiquido.CalculadoraSalarioLiquido;
import br.com.ufcg.vv.tdd.calculadora.salario.model.calculo.salarioLiquido.CalculoSalarioLiquido;
import br.com.ufcg.vv.tdd.calculadora.salario.model.calculo.salarioLiquido.implementations.DesenvolvedorCalculoSalarioLiquido;
import br.com.ufcg.vv.tdd.calculadora.salario.model.funcionario.implementations.Desenvolvedor;

public class DesenvolvedorCalculadoraSalarioLiquido extends CalculadoraSalarioLiquido<Desenvolvedor> {
    private final CalculoSalarioLiquido<Desenvolvedor> calculoSalarioLiquido;

    public DesenvolvedorCalculadoraSalarioLiquido() {
        this.calculoSalarioLiquido = new DesenvolvedorCalculoSalarioLiquido();
    }

    public double calcular(Desenvolvedor funcionario) {
        return super.calcular(funcionario, this.calculoSalarioLiquido);
    }
}
