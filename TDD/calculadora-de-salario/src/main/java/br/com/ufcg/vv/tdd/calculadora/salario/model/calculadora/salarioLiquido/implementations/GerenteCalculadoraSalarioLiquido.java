package br.com.ufcg.vv.tdd.calculadora.salario.model.calculadora.salarioLiquido.implementations;

import br.com.ufcg.vv.tdd.calculadora.salario.model.calculadora.salarioLiquido.CalculadoraSalarioLiquido;
import br.com.ufcg.vv.tdd.calculadora.salario.model.calculo.salarioLiquido.CalculoSalarioLiquido;
import br.com.ufcg.vv.tdd.calculadora.salario.model.calculo.salarioLiquido.implementations.GerenteCalculoSalarioLiquido;
import br.com.ufcg.vv.tdd.calculadora.salario.model.funcionario.implementations.Gerente;

public class GerenteCalculadoraSalarioLiquido extends CalculadoraSalarioLiquido<Gerente> {
    private final CalculoSalarioLiquido<Gerente> calculoSalarioLiquido;

    public GerenteCalculadoraSalarioLiquido() {
        this.calculoSalarioLiquido = new GerenteCalculoSalarioLiquido();
    }

    public double calcular(Gerente funcionario) {
        return super.calcular(funcionario, this.calculoSalarioLiquido);
    }
}
