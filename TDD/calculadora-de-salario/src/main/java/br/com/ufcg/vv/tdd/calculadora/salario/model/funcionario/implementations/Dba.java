package br.com.ufcg.vv.tdd.calculadora.salario.model.funcionario.implementations;

import br.com.ufcg.vv.tdd.calculadora.salario.model.funcionario.Funcionario;

public class Dba extends Funcionario {

    public Dba(String nome, String email, double salarioBase) {
        super(nome, email, salarioBase, "DBA");
    }
}
