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

    public int getId() {return id;}
    public BigDecimal getSaldo() {return saldo;}

    public void depositar(BigDecimal valor) {

        if (valor.compareTo(BigDecimal.ZERO) <= 0) {

            System.out.println("Valor invalido");

        }else  {

            saldo = saldo.add(valor);
        }
    }


}
