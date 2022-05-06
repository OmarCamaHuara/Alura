package br.com.domon.cursos.model;

import java.time.LocalDate;

public class Funcionario {
    private String name;
    private int matricula;
    private LocalDate dateOfBirth;

    public Funcionario(String name, int matricula, LocalDate dateOfBirth) {
        this.name = name;
        this.matricula = matricula;
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "name='" + name + '\'' +
                ", matricula=" + matricula +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
