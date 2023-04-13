package br.com.ufcg.vv.tdd.calculadora.salario.model;

public class CalculaSalario {

        public double calcula(Funcionario funcionario) {
            double salario = funcionario.getSalarioBase();

            if (funcionario.getCargo().equals("DESENVOLVEDOR")) {
                if (salario >= 3000) {
                    salario = salario * 0.8;
                } else {
                    salario = salario * 0.9;
                }
            } else if (funcionario.getCargo().equals("DBA") || funcionario.getCargo().equals("TESTADOR")) {
                if (salario >= 2000) {
                    salario = salario * 0.75;
                } else {
                    salario = salario * 0.85;
                }
            } else if (funcionario.getCargo().equals("GERENTE")) {
                if (salario >= 5000) {
                    salario = salario * 0.7;
                } else {
                    salario = salario * 0.8;
                }
            }

            return salario;
        }
}
