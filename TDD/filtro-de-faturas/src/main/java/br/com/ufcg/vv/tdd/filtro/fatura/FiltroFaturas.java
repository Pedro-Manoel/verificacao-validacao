package br.com.ufcg.vv.tdd.filtro.fatura;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class FiltroFaturas {
    private static final double VALOR_MINIMO = 2000.0;
    private static final double VALOR_MEDIO = 2500.0;
    private static final double VALOR_ALTO = 3000.0;
    private static final double VALOR_RS = 4000.0;

    private static boolean valorMenorQueMinimo(Fatura fatura) {
        return fatura.getValor() < VALOR_MINIMO;
    }

    private static boolean valorEntreMinimoEMedioEDataAntiga(Fatura fatura) {
        LocalDate umMesAtras = LocalDate.now().minus(Period.ofMonths(1));
        return fatura.getValor() >= VALOR_MINIMO && fatura.getValor() <= VALOR_MEDIO && fatura.getData().isBefore(umMesAtras);
    }

    private static boolean valorEntreMedioEAltoEDataInclusaoAntiga(Fatura fatura) {
        LocalDate doisMesesAtras = LocalDate.now().minus(Period.ofMonths(2));
        return fatura.getValor() > VALOR_MEDIO && fatura.getValor() <= VALOR_ALTO && fatura.getCliente().getDataInclusao().isBefore(doisMesesAtras);
    }

    private static boolean valorMaiorQueRS(Fatura fatura) {
        return fatura.getValor() > VALOR_RS && fatura.getCliente().getEstado().equals("RS");
    }

    public List<Fatura> filtraFaturas(List<Fatura> faturas) {
        List<Fatura> faturasFiltradas = new ArrayList<>();

        for (Fatura fatura : faturas) {
            if (!valorMenorQueMinimo(fatura) && !valorEntreMinimoEMedioEDataAntiga(fatura) && !valorEntreMedioEAltoEDataInclusaoAntiga(fatura) && !valorMaiorQueRS(fatura)) {
                faturasFiltradas.add(fatura);
            }
        }

        return faturasFiltradas;
    }
}
