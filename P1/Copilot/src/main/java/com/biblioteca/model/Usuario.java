package com.biblioteca.model;

import java.time.LocalDate;

public class Usuario {
    private static int contadorId = 1;
    private int id;
    private String nome;
    private LocalDate dataNascimento;
    private String endereco;
    private String identificacaoPessoal;
    private int impedimento; // dias de impedimento

    public Usuario(String nome, LocalDate dataNascimento, String endereco, String identificacaoPessoal) {
        this.id = contadorId++;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.identificacaoPessoal = identificacaoPessoal;
        this.impedimento = 0;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getIdentificacaoPessoal() {
        return identificacaoPessoal;
    }

    public int getImpedimento() {
        return impedimento;
    }

    public void adicionarImpedimento(int dias) {
        this.impedimento += dias;
    }

    public boolean podeEmprestar() {
        return impedimento <= 0;
    }

    public void renovarImpedimento() {
        if (impedimento > 0) {
            impedimento--;
        }
    }
}