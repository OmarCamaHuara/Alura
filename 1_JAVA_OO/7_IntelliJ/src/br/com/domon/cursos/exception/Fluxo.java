package br.com.domon.cursos.exception;

public class Fluxo {
    public static void main(String[] args) {
        System.out.println("Ini do main");
        try {
            metodo1();
        }catch (ArithmeticException | NullPointerException  exception){
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
        for (int i = 1; i <= 5; i++){
            System.out.println(i);
//            int a = i / 0;
            Conta c = null;
            c.depositar();
        }
        System.out.println("fim do metodo 2");
    }
}
