package com.bancodigital;

import com.bancodigital.Conta.Conta;
import com.bancodigital.banco.Banco;
import com.bancodigital.cliente.Cliente;

import java.util.HashMap;
import java.util.Map;

import java.math.BigDecimal;

public class App {
    public static void main(String[] args) {

        Cliente cliente = new Cliente
                (1, "Pablo Bernardino", "498.921.418-81", "pablopbernardino@gmail.com", "(11) 949092368");

        Cliente cliente1 = new Cliente
                (2, "Jenn", "498.921.418-81", "pablopbernardino@gmail.com", "(11) 949092368");

        Cliente cliente2 = new Cliente(3, "Alailton", "498.921.418-81", "pablopbernardino@gmail.com", "(11) 949092368");

        //_____________________________________________________________________________//
        Banco banco = new Banco();

        banco.cadastrarCliente(cliente); // Banco, cadastre este cliente.
        banco.cadastrarCliente(cliente1);

        //_____________________________________________________________________________//
        Cliente clienteEncontrado = banco.consultarCliente(cliente.getId());

        System.out.println(clienteEncontrado.getNome().toString());
        System.out.println(clienteEncontrado.getEmail().toString());
        System.out.println(clienteEncontrado.getId());
        System.out.println(clienteEncontrado.getTelefone().toString());

        System.out.println();

        //__________________________________________________________________________________//

        banco.cadastrarCliente(cliente2);

        clienteEncontrado = banco.consultarCliente(cliente2.getId());

        System.out.println(clienteEncontrado.getNome().toString());
        System.out.println(clienteEncontrado.getEmail().toString());
        System.out.println(clienteEncontrado.getId());
        System.out.println(clienteEncontrado.getTelefone().toString());

        System.out.println();

        //_________________________________________________________________________________//


        BigDecimal saldoInicial = new BigDecimal("1000.00");

        Conta conta = new Conta
                (1, "56886", "0001", saldoInicial, cliente);


        banco.cadastrarConta(conta);

        Conta contaEncontrada = banco.consultarConta(conta.getId());

        System.out.println(contaEncontrada.getId());



        conta.depositar(new BigDecimal("2000.00"));
        System.out.println(contaEncontrada.getSaldo());

        conta.depositar(new BigDecimal("0.00"));
        conta.depositar(new BigDecimal("-500.00"));

        //_____________________________________________________________________________________//

        conta.sacar(new BigDecimal("100.00"));
        System.out.println(contaEncontrada.getSaldo());

        conta.sacar(new BigDecimal("2900.00"));
        System.out.println(contaEncontrada.getSaldo());

        conta.depositar(new BigDecimal("500.00"));
        System.out.println(contaEncontrada.getSaldo());

        conta.sacar(new BigDecimal("501.00"));
        System.out.println(contaEncontrada.getSaldo());

        conta.depositar(new BigDecimal("-500.00"));
        System.out.println(contaEncontrada.getSaldo());

        conta.sacar(new BigDecimal("0.00"));
        System.out.println(contaEncontrada.getSaldo());
    }
}



