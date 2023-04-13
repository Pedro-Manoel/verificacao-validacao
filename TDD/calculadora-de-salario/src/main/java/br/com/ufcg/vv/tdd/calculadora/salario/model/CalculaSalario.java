package br.com.ufcg.vv.tdd.calculadora.salario.model;

import br.com.ufcg.vv.tdd.calculadora.salario.model.funcionario.Funcionario;
import br.com.ufcg.vv.tdd.calculadora.salario.model.funcionario.implementations.Dba;
import br.com.ufcg.vv.tdd.calculadora.salario.model.funcionario.implementations.Desenvolvedor;
import br.com.ufcg.vv.tdd.calculadora.salario.model.funcionario.implementations.Gerente;
import br.com.ufcg.vv.tdd.calculadora.salario.model.funcionario.implementations.Testador;

public class CalculaSalario {

        public double calcula(Funcionario funcionario) {
            double salario = funcionario.getSalarioBase();

            if (funcionario instanceof Desenvolvedor) {
                if (salario >= 3000) {
                    salario = salario * 0.8;
                } else {
                    salario = salario * 0.9;
                }
            } else if (funcionario instanceof Dba || funcionario instanceof Testador) {
                if (salario >= 2000) {
                    salario = salario * 0.75;
                } else {
                    salario = salario * 0.85;
                }
            } else if (funcionario instanceof Gerente) {
                if (salario >= 5000) {
                    salario = salario * 0.7;
                } else {
                    salario = salario * 0.8;
                }
            }

            return salario;
        }
}
