public class Main {
    public static void main(String[] args) {

        // Operadores aritméticos:
        // Somar (+)
        // Subtrair (-)
        // Multiplicar (*)
        // Dividir (/)
        // Módulo - resto da divisão (%)

        int numero1 = 7;
        int numero2 = 5;
        int resultado;

        resultado = numero1 % numero2;
        System.out.println(resultado);

        // Operadores relacionais:
        // == (igual a)
        // != (diferente)
        // > (maior que)
        // < (menor que)
        // >= (maior ou igual)
        // <= (menor ou igual)

        int n1 = 1;
        int n2 = 2;
        boolean resultado1 = n1 != n2;
        System.out.println(resultado1);

        int idade = 19;
        boolean resultado2 = idade > 18;
        System.out.println(resultado2);

        // Operadores lógicos:
        // && (e)
        // || (ou)

        boolean resultado3;
        int idade1 = 18;
        resultado3 = idade1 >= 18 && idade <= 40;
        System.out.println(resultado3);
    }
}
