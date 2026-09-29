package com.bancodigital.banco;

import com.bancodigital.cliente.Cliente;

import java.util.HashMap;
import java.util.Map;

public class Banco {

    // Crie um Map chamado mapClientes, cujo chave é Integer e cujo valor é Cliente, utilizando um HashMap
    Map<Integer, Cliente> mapClientes =
            new HashMap<Integer, Cliente>();

    public void cadastrarCliente(Cliente cliente) {

        // Se o ID já existe, avise. Caso contrário, coloque o cliente no Map usando o ID como chave..
        if (mapClientes.containsKey(cliente.getId())) {

            System.out.println("Cliente existente");

        }else {
            System.out.println("O cliente foi cadastrado");

            // No mapClientes, coloque o cliente usando o ID dele como chave.
            mapClientes.put(cliente.getId(), cliente);
        }
    }

    public Cliente consultarCliente(int id) {

        // Pegue no mapClientes o valor associado à chave id e coloque esse objeto dentro da variável cliente
        Cliente cliente = mapClientes.get(id);

        return cliente;
    }
}
