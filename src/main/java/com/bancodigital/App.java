package com.bancodigital;

import com.bancodigital.Conta.Conta;
import com.bancodigital.Conta.StatusConta;
import com.bancodigital.banco.Banco;
import com.bancodigital.cliente.Cliente;

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

        Conta conta = new Conta(1, "56886", "0001", saldoInicial, cliente);


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

        //_____________________________________________________________________________________//

        // Adicionei um saldo inicial a conta Origem
        BigDecimal saldoOrigem = new BigDecimal("1000.00");

       Conta contaOrigem = new Conta( // Criei nova conta (objeto) contaOrigem

               2,
               "56498",
               "0002",
               saldoOrigem,
               cliente

       );

       // Adicionei um saldo inicial a conta Destino
       BigDecimal saldoDestino = new BigDecimal("500.00");

       Conta contaDestino = new Conta( // Criei nova conta (objeto) contaDestino

               1,
               "56886",
               "0001",
               saldoDestino,
               cliente

       );

       banco.cadastrarConta(contaOrigem); // Cadastrei nova conta (contaOrigem)
       banco.cadastrarConta(contaDestino); // Cadastrei nova conta (contaDestino)

        // CONSULTA
        System.out.println(banco.consultarConta(contaDestino.getId()));

        // CONSULTA
        System.out.println(banco.consultarConta(contaOrigem.getId()));

        // CONSULTA SALDO
        System.out.println("contaOrigem: " + contaOrigem.getSaldo());

        // CONSULTA SALDO
        System.out.println("contaDestino:" + contaDestino.getSaldo());


        // TRANSFERÊNCIA VÁLIDA
        contaOrigem.transferir(contaDestino, BigDecimal.valueOf(200));

        System.out.println("contaDestino: " + contaDestino.getSaldo());
        System.out.println("contaOrigem: " + contaOrigem.getSaldo());

        // VALOR 0,00
        contaOrigem.transferir(contaDestino, BigDecimal.valueOf(0));

        // VALOR NEGATIVO
        contaOrigem.transferir(contaDestino, BigDecimal.valueOf(-100.00));

        // CONTA DESTINO NULL
        contaOrigem.transferir(null, BigDecimal.valueOf(100));

        // PRÓPRIA conta
        contaOrigem.transferir(contaOrigem, BigDecimal.valueOf(200));

        // SALDO INSUFICIENTE
        contaOrigem.transferir(contaDestino, BigDecimal.valueOf(1500.00));

        //____________________________________________________________________________________//

        conta.bloquear();
        System.out.println("Status da conta: " + conta.getStatus().toString());

        contaOrigem.bloquear();
        System.out.println("Status da conta origem: " + contaOrigem.getStatus().toString());

        contaDestino.bloquear();
        System.out.println("Status da conta destino: " + contaDestino.getStatus().toString());

        //__________________________________________________________________________________________//

        BigDecimal novoSaldo = new BigDecimal("1000.00");

        Conta novaConta = new Conta(
                5,
                "88954",
                "0005",
                novoSaldo,
                cliente
        );

        novaConta.bloquear();

        System.out.println("Saldo antes: " + novaConta.getSaldo());

        novaConta.depositar(new BigDecimal("2000.00"));

        System.out.println("Saldo depois: " + novaConta.getSaldo());




    }
}



