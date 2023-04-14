package br.com.ufcg.vv.tdd.filtro.fatura;

import java.time.LocalDate;

public class Fatura {
    private String codigo;
    private Double valor;
    private LocalDate data;
    private Cliente cliente;

    public Fatura(String codigo, Double valor, LocalDate data, Cliente cliente) {
        this.codigo = codigo;
        this.valor = valor;
        this.data = data;
        this.cliente = cliente;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
