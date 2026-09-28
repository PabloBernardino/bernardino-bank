package com.bancodigital.cliente;

public class Cliente {

    private int id;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    // private String endereco;

    public Cliente(int id, String nome, String cpf, String email, String telefone) { //Construtor
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
    }


    public String getNome() {return nome;}
    public String getCpf() {return cpf;}
    public String getEmail() {return email;}
    public String getTelefone() {return telefone;}
    public int getId() {return id;}
}