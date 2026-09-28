package com.bancodigital;

import com.bancodigital.banco.Banco;
import com.bancodigital.cliente.Cliente;

import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) {

        Cliente cliente = new Cliente
                (1, "Pablo Bernardino", "498.921.418-81", "pablopbernardino@gmail.com", "(11) 949092368");

        Cliente cliente1 = new Cliente
                (2, "Jenn", "498.921.418-81", "pablopbernardino@gmail.com", "(11) 949092368");

        Banco banco = new Banco();

        banco.cadastrarCliente(cliente); // Banco, cadastre este cliente.
        banco.cadastrarCliente(cliente1);





    }
}


