import java.util.Scanner;

public class ExerciciosWhile {

    /*  Resolva os exercícios usando o laço de repetição WHILE.
     a. Considere uma caixa d’água de 2 mil litros. Rômulo gostaria de encher a caixa d’água com balões de água
    de 7 litros. Quantos balões cabem na caixa d’água sem que o volume seja excedido?

     b. FizzBuzz. Imprima os números de 1 a 50 em ordem crescente de acordo com a regra abaixo:
     ● Quando um número for divisível por 3, imprimir Buzz.
     ● Quando um número for divisível por 5, imprimir Fizz.
     ● Quando um número for divisível por 3 e 5, imprimir FizzBuzz.

     c. Escreva um programa capaz de receber um texto e imprimi-lo invertido.
     Entrada: Meu nome é Julius.
    Saída: .suiluJ é emon ueM

     d. Escreva uma função que recebe uma string, verifica se existe a mesma quantidade de caracteres ‘x’ e ‘o’ e
    retorna true ou false. Caso não exista nem ‘x’ nem ‘o’, retornar false. Não diferencie maíusculas e minúsculas.
     “xXooox” -> true          “xxxxo” -> false          “bdefghjij” -> false           “ooooxzzzzz” -> false
    */

    // a.
    private void enchendoCaixaDagua() {
        int capacidade = 2000;
        int volumeBalao = 7;
        int totalBaloes = 0;

        while ((totalBaloes * volumeBalao) + volumeBalao < capacidade) {
            totalBaloes++;
        }
        System.out.println("Quantidade: " + totalBaloes);
    }

    // b.
    private void imprimindoNumeros() {
        int i = 1;
        while (i <= 50) {
            if (i % 15 == 0) {
                System.out.print("FizzBuzz ");
            } else if (i % 3 == 0) {
                System.out.print("Buzz ");
            } else if (i % 5 == 0) {
                System.out.print("Fizz ");
            } else {
                System.out.print(i + " ");
            }
            i++;
        }
    }

    // c.
    private void invertendoFrases (String frase) {
        int i = frase.length() - 1;
        while (i >= 0) {
            System.out.print(frase.charAt(i));
            i--;
        }
    }

    // d.
    private boolean verificandoStrings (String caracteres) {
        caracteres = caracteres.toLowerCase();
        int tamanho = caracteres.length();
        int i = 0;
        int countX = 0;
        int countO = 0;

        while (i < tamanho) {
            if (caracteres.charAt(i) == 'x') {
                countX++;
            } else if (caracteres.charAt(i) == 'o') {
                countO++;
            }
            i++;
        }
         return (countX == countO) && (countX != 0);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ExerciciosWhile exercicios = new ExerciciosWhile();
        exercicios.enchendoCaixaDagua();
        exercicios.imprimindoNumeros();

        System.out.println();
        System.out.println("Escreva a sua frase: ");
        String frase = scanner.nextLine();
        exercicios.invertendoFrases(frase);
        System.out.println();

        System.out.println(exercicios.verificandoStrings("xXooox"));
        System.out.println(exercicios.verificandoStrings("xxxxo"));
        System.out.println(exercicios.verificandoStrings("bdefghjij"));
        System.out.println(exercicios.verificandoStrings("ooooxzzzzz"));


        scanner.close();
    }
}
