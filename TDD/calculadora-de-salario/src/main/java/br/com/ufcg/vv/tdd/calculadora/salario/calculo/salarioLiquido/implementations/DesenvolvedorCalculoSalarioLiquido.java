package br.com.ufcg.vv.tdd.calculadora.salario.calculo.salarioLiquido.implementations;

import br.com.ufcg.vv.tdd.calculadora.salario.calculo.salarioLiquido.CalculoSalarioLiquido;
import br.com.ufcg.vv.tdd.calculadora.salario.model.funcionario.implementations.Desenvolvedor;

public class DesenvolvedorCalculoSalarioLiquido implements CalculoSalarioLiquido<Desenvolvedor> {
    private static final double DESCONTO_MAIOR_QUE_3000 = 0.2;
    private static final double DESCONTO_MENOR_QUE_3000 = 0.1;

    @Override
    public double calcular(Desenvolvedor funcionario) {
        double salarioBase = funcionario.getSalarioBase();
        double desconto = salarioBase >= 3000 ? DESCONTO_MAIOR_QUE_3000 : DESCONTO_MENOR_QUE_3000;

        return salarioBase * (1 - desconto);
    }
}
