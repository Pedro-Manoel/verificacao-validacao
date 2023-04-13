package br.com.ufcg.vv.tdd.calculadora.salario.model.funcionario.implementations;

import br.com.ufcg.vv.tdd.calculadora.salario.model.funcionario.Funcionario;

public class Desenvolvedor extends Funcionario {

    public Desenvolvedor(String nome, String email, double salarioBase) {
        super(nome, email, salarioBase, "DESENVOLVEDOR");
    }
}
