package br.com.ufcg.vv.tdd.filtro.fatura;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class FiltroFaturas {
    public List<Fatura> filtraFaturas(List<Fatura> faturas) {
        List<Fatura> faturasFiltradas = new ArrayList<>();

        LocalDate umMesAtras = LocalDate.now().minus(Period.ofMonths(1));
        LocalDate doisMesesAtras = LocalDate.now().minus(Period.ofMonths(2));

        for (Fatura f : faturas) {
            if (f.getValor() < 2000.0) {
                continue;
            }

            if (f.getValor() >= 2000.0 && f.getValor() <= 2500.0 && f.getData().isBefore(umMesAtras)) {
                continue;
            }

            if (f.getValor() > 2500.0 && f.getValor() <= 3000.0 && f.getCliente().getDataInclusao().isBefore(doisMesesAtras)) {
                continue;
            }

            if (f.getValor() > 4000.0 && f.getCliente().getEstado().equals("RS")) {
                continue;
            }

            faturasFiltradas.add(f);
        }

        return faturasFiltradas;
    }
}