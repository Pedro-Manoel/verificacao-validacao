package br.com.ufcg.vv.tdd.calculadora.salario;

import br.com.ufcg.vv.tdd.calculadora.salario.calculadora.salarioLiquido.implementations.DesenvolvedorCalculadoraSalarioLiquido;
import br.com.ufcg.vv.tdd.calculadora.salario.model.funcionario.implementations.Desenvolvedor;

public class Main {
    public static void main(String[] args) {
        Desenvolvedor desenvolvedor = new Desenvolvedor("João", "joao@gmail.com", 3200.0);
        DesenvolvedorCalculadoraSalarioLiquido calculadoraSalario = new DesenvolvedorCalculadoraSalarioLiquido();

        double salarioLiquidoDev = calculadoraSalario.calcular(desenvolvedor);

        System.out.println(
                String.format("Nome: %s\nCargo: %s\nSalário Base: %.2f\nSalário Liquido: %.2f",
                desenvolvedor.getNome(),
                desenvolvedor.getCargo(),
                desenvolvedor.getSalarioBase(),
                salarioLiquidoDev)
        );
    }
}