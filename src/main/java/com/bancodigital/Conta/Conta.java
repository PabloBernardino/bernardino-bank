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

    public void sacar(BigDecimal valor) {

        if (valor.compareTo(BigDecimal.ZERO) <= 0) {
            System.out.println("Valor invalido");
        } else if (valor.compareTo(saldo) > 0) {
            System.out.println("Saldo insuficiente");
        } else {
            saldo = saldo.subtract(valor);
        }

    }

    public void transferir(Conta contaDestino, BigDecimal valor) {

        if (valor.compareTo(BigDecimal.ZERO) <= 0) {

            System.out.println("Valor invalido");


        }else if (contaDestino == null) {

            System.out.println("Conta destino null");

        }else if (this == contaDestino) {

            System.out.println("conta destino invalido");

        }else if (valor.compareTo(this.getSaldo()) > 0) {

            System.out.println("Saldo insuficiente");

        }else {

            // Tira dinheiro
            this.sacar(valor);

            // colocar dinheiro
            contaDestino.depositar(valor);

            System.out.println("Transferencia realizada com sucesso");
        }

    }
}












