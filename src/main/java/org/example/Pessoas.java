package org.example;

public class Pessoas {
    private int codigo;
    private String nome;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Pessoas(int codigo, String nome) {
        super();
        this.codigo = codigo;
        this.nome = nome;
    }
}
