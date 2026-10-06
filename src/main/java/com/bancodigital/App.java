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

        System.out.println();
        System.out.println();

        //_____________________________________________________________________________//
        Banco banco = new Banco();

        banco.cadastrarCliente(cliente); // Banco, cadastre este cliente.
        banco.cadastrarCliente(cliente1);

        System.out.println();
        System.out.println();

        //_____________________________________________________________________________//
        Cliente clienteEncontrado = banco.consultarCliente(cliente.getId());

        System.out.println(clienteEncontrado.getNome().toString());
        System.out.println(clienteEncontrado.getEmail().toString());
        System.out.println(clienteEncontrado.getId());
        System.out.println(clienteEncontrado.getTelefone().toString());

        System.out.println();
        System.out.println();


        //__________________________________________________________________________________//

        banco.cadastrarCliente(cliente2);

        clienteEncontrado = banco.consultarCliente(cliente2.getId());

        System.out.println(clienteEncontrado.getNome().toString());
        System.out.println(clienteEncontrado.getEmail().toString());
        System.out.println(clienteEncontrado.getId());
        System.out.println(clienteEncontrado.getTelefone().toString());

        System.out.println();
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

        System.out.println();
        System.out.println();

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

        System.out.println();
        System.out.println();

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

        System.out.println();
        System.out.println();

        //____________________________________________________________________________________//

        conta.bloquear();
        System.out.println("Status da conta: " + conta.getStatus().toString());

        contaOrigem.bloquear();
        System.out.println("Status da conta origem: " + contaOrigem.getStatus().toString());

        contaDestino.bloquear();
        System.out.println("Status da conta destino: " + contaDestino.getStatus().toString());

        System.out.println();
        System.out.println();

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

        System.out.println();
        System.out.println();

        //________________________________________________________________________________________________//

        BigDecimal novoSaldo2 = new BigDecimal("1000.00"); // Criei novo saldo

        Conta novaConta2 = new Conta(10, "66658", "0008", novoSaldo2, cliente); // Criei nova conta

        System.out.println("Saldo antes: " + novaConta2.getSaldo()); // Mostrei saldo

        novaConta2.sacar(new BigDecimal("100.00")); // Saquei saldo

        System.out.println("Saldo atual: " + novaConta2.getSaldo()); // Mostrei saldo atual

        novaConta2.bloquear(); // Realizei o bloqueio da conta

        novaConta2.sacar(new BigDecimal("100.00")); // Realizar novo saque

        System.out.println("Saldo atual: " + novaConta2.getSaldo()); // Mostrar saque atual após bloqueio de conta

        System.out.println();
        System.out.println();

        //__________________________________________________________________________________________________//

        System.out.println(novaConta2.getStatus().toString());

        novaConta2.ativar();
        System.out.println(novaConta2.getStatus().toString());

        novaConta2.sacar(new BigDecimal("100.00"));

        System.out.println("saldo atual: " + novaConta2.getSaldo());

        System.out.println();
        System.out.println();
        System.out.println();

        //___________________________________________________________________________________________________//


        BigDecimal novoSaldo_A = new BigDecimal("1000.00"); // novo saldo da conta A
        Conta conta_A = new Conta(23, "56498", "0023", novoSaldo_A, cliente); // Nova conta A
        System.out.println("Conta A: " + conta_A.getStatus().toString()); // Status da conta A


        BigDecimal novoSaldo_B = new BigDecimal("500.00"); // Novo saldo da conta B
        Conta conta_B = new Conta(24, "86954", "0024", novoSaldo_B, cliente); // Nova conta B
        System.out.println("Conta B: " + conta_B.getStatus().toString()); // Status da conta B

        System.out.println("----------------------------------------------------------------------------");
        System.out.println(); // Pular Linha

        conta_B.bloquear(); // Realizei o bloqueio da conta B
        System.out.println("Conta B: " + conta_B.getStatus().toString()); // Mostrar status atual

        conta_A.transferir(conta_B, BigDecimal.valueOf(100)); // Transferir 100,00 para a conta B bloquada

        System.out.println("Saldo atual da Conta A: " + conta_A.getSaldo()); // SALDO ATUAL da conta A
        System.out.println("Saldo atual da Conta B: " + conta_B.getSaldo()); // SALDO ATUAL da conta B









    }
}



