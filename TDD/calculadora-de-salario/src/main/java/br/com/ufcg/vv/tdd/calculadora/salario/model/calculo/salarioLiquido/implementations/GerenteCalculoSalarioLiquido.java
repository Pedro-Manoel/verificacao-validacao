package br.com.ufcg.vv.tdd.calculadora.salario.model.calculo.salarioLiquido.implementations;

import br.com.ufcg.vv.tdd.calculadora.salario.model.calculo.salarioLiquido.CalculoSalarioLiquido;
import br.com.ufcg.vv.tdd.calculadora.salario.model.funcionario.implementations.Gerente;

public class GerenteCalculoSalarioLiquido implements CalculoSalarioLiquido<Gerente> {
    private static final double DESCONTO_MAIOR_QUE_5000 = 0.3;
    private static final double DESCONTO_MENOR_QUE_5000 = 0.2;

    @Override
    public double calcular(Gerente funcionario) {
        double salarioBase = funcionario.getSalarioBase();
        double desconto = salarioBase >= 5000 ? DESCONTO_MAIOR_QUE_5000 : DESCONTO_MENOR_QUE_5000;

        return salarioBase * (1 - desconto);
    }
}
