package br.com.ufcg.vv.tdd.calculadora.salario.model.calculo.salarioLiquido.implementations;

import br.com.ufcg.vv.tdd.calculadora.salario.model.calculo.salarioLiquido.CalculoSalarioLiquido;
import br.com.ufcg.vv.tdd.calculadora.salario.model.funcionario.implementations.Testador;

public class TestadorCalculoSalarioLiquido implements CalculoSalarioLiquido<Testador> {
    private static final double DESCONTO_MAIOR_QUE_2000 = 0.25;
    private static final double DESCONTO_MENOR_QUE_2000 = 0.15;

    @Override
    public double calcular(Testador funcionario) {
        double salarioBase = funcionario.getSalarioBase();
        double desconto = salarioBase >= 2000 ? DESCONTO_MAIOR_QUE_2000 : DESCONTO_MENOR_QUE_2000;

        return salarioBase * (1 - desconto);
    }
}
