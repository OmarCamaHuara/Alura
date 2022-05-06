package br.com.domon.cursos.model;

import java.time.LocalDate;

public class Curso {

    private String nome;
    private int codigo;
    private LocalDate data;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Curso{" +
                "nome='" + nome + '\'' +
                ", codigo=" + codigo +
                ", data=" + data +
                '}';
    }

}
