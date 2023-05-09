package br.com.ufcg.vv.tdd.filtro.fatura;


import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FaturaTest {

    @Test
    public void testFiltraFaturasValorMenorQue2000() {
        Cliente cliente = new Cliente("João", LocalDate.now(), "PB");
        Fatura fatura = new Fatura("123", 1500.0, LocalDate.now(), cliente);
        List<Fatura> faturas = new ArrayList<>();
        faturas.add(fatura);
        FiltroFaturas filtro = new FiltroFaturas();
        List<Fatura> faturasFiltradas = filtro.filtraFaturas(faturas);
        assertEquals(0, faturasFiltradas.size());
    }

    @Test
    public void testFiltraFaturasValorEntre2000E2500EDataMenorIgualUmMesAtras() {
        Cliente cliente = new Cliente("Maria", LocalDate.now(), "SP");
        Fatura fatura = new Fatura("456", 2200.0, LocalDate.now().minusMonths(1), cliente);
        List<Fatura> faturas = new ArrayList<>();
        faturas.add(fatura);
        FiltroFaturas filtro = new FiltroFaturas();
        List<Fatura> faturasFiltradas = filtro.filtraFaturas(faturas);
        assertEquals(1, faturasFiltradas.size());
    }

    @Test
    public void testFiltraFaturasValorEntre2500E3000EDataInclusaoMenorIgualDoisMesesAtras() {
        Cliente cliente = new Cliente("Ana", LocalDate.now().minusMonths(2), "RJ");
        Fatura fatura = new Fatura("789", 2800.0, LocalDate.now(), cliente);
        List<Fatura> faturas = new ArrayList<>();
        faturas.add(fatura);
        FiltroFaturas filtro = new FiltroFaturas();
        List<Fatura> faturasFiltradas = filtro.filtraFaturas(faturas);
        assertEquals(1, faturasFiltradas.size());
    }

    @Test
    public void testFiltraFaturasValorMaiorQue4000EEstadoRS() {
        Cliente cliente = new Cliente("Pedro", LocalDate.now(), "RS");
        Fatura fatura = new Fatura("101112", 4500.0, LocalDate.now().minusDays(1), cliente);
        List<Fatura> faturas = new ArrayList<>();
        faturas.add(fatura);
        FiltroFaturas filtro = new FiltroFaturas();
        List<Fatura> faturasFiltradas = filtro.filtraFaturas(faturas);
        assertEquals(0, faturasFiltradas.size());
    }

}