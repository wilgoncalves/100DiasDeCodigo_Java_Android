import java.util.Scanner;

public class ExerciciosFor {
    public static void main(String[] args) {

    /* Resolva os exercícios usando o laço de repetição FOR.
     a. Imprima os números de 1 a 50 na mesma linha em ordem crescente. Saída esperada:
     “1 2 3 4 5 6 7 8 9 10 .. .. .. 49 50”
     b. Imprima os números de 1 a 50 na mesma linha em ordem decrescente. Saída esperada:
     “50 49 48 47 .. .. .. 2 1”
     c. Usando a resolução do exercício a, não imprima os números múltiplos de 5.
     d. Faça a soma de todos os números no intervalo de 1 a 500.
     e. Escreva um programa capaz de receber um número inteiro N e imprimir uma escada de tamanho N
    usando o caracter #.
     Se a entrada do programa for 3, teremos:
     #
     ##
     ###
     Se a entrada do programa for 5, teremos:
     #
     ##
     ###
     ####
     #####
     */
        // a.
        for (int i = 1; i <= 50; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        // b.
        for (int i = 50; i >= 1; i--) {
            System.out.print(i + " ");
        }
        System.out.println();

        // c.
        for (int i = 1; i <= 50; i++) {
            if (i % 5 == 0) {
                continue;
            }
            System.out.print(i + " ");
        }
        System.out.println();

        // d.
        int soma = 0;
        for (int i = 1; i <= 500; i++) {
            soma += i;
        }
        System.out.println(soma);

        // e.
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insira um numero: ");
        int n = scanner.nextInt();

        int caractere = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < caractere; j++) {
                System.out.print("#");
            }
            caractere++;
            System.out.println();
        }
    }
}
