package br.com.domon.cursos;

import br.com.domon.cursos.model.Curso;
import br.com.domon.cursos.model.Funcionario;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        System.out.println("Domon");
        Curso php = new Curso();
        Funcionario fun1 = new Funcionario("Omar", 156, LocalDate.of(1991, 11, 28));
        Funcionario fun2 = new Funcionario("Carlos", 207, LocalDate.of(1994, 01, 16));

        php.setCodigo(1);
        php.setNome("PHP");
        php.setData(LocalDate.of(2023, 02, 10));

        System.out.println(php);
        int
        omar
        = 1;
        System.out.println(omar);

        for(char c='a';c <= 'z';c++) {
            System.out.println(c);
        }
        System.out.println(fun1.getName());
        System.out.println(fun1.getDateOfBirth());
        System.out.println(fun2.getName());
        System.out.println(fun2.getDateOfBirth());
    }
}
