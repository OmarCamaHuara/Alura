package br.com.domon.cursos.exception;

public class FluxoComTratamento {
    public static void main(String[] args) {
        System.out.println("Ini do main");
        try {
            metodo1();
        }catch (ArithmeticException | NullPointerException | MyException exception){
            String msg = exception.getMessage();
            System.out.println("Exception "+ msg);
            exception.printStackTrace();
        }
        System.out.println("Fim do main");

    }

    public static void metodo1() {
        System.out.println("Ini do metodo 1");
        metodo2();
        System.out.println("Fim do medoto 1");
    }

    private static void metodo2() {
        System.out.println("Ini do metodo 2");

        throw new MyException("Deu muito errado");
        // System.out.println("fim do metodo 2");
    }
}
