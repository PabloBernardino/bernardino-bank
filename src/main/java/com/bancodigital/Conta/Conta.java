package com.bancodigital.Conta;

import com.bancodigital.cliente.Cliente;

import java.math.BigDecimal;

public class Conta {

    private int id;
    private String numero;
    private String agencia;
    private BigDecimal saldo;
    private Cliente cliente;

    public Conta (int idInit, String numeroInit, String agenciaInit,
                  BigDecimal saldoInit, Cliente clienteInit) {
        id = idInit;
        numero = numeroInit;
        agencia = agenciaInit;
        saldo = saldoInit;
        cliente = clienteInit;

    }

    public int getId() { return id; }
    public String getNumero() { return numero; }
    public String getAgencia() { return agencia; }
    public BigDecimal getSaldo() { return saldo; }
    public Cliente getCliente() { return cliente; }

}
