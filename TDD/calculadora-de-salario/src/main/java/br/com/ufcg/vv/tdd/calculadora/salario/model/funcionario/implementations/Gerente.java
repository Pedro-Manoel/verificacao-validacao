package br.com.ufcg.vv.tdd.calculadora.salario.model.funcionario.implementations;

import br.com.ufcg.vv.tdd.calculadora.salario.model.funcionario.Funcionario;

public class Gerente extends Funcionario {

    public Gerente(String nome, String email, double salarioBase) {
        super(nome, email, salarioBase, "GERENTE");
    }
}
