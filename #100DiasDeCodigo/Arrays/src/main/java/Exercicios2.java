public class Exercicios2 {
    // ARRAY MULTIDIMENSIONAL

    /*
     1. Considere a seguinte matriz quadrada que representa as notas de 4 alunos em 4 matérias:
     float[][] matriz = {{8.8f, 9, 7.6f, 4}, {8.9f, 9.7f, 9.4f, 8.9f}, {10, 10, 9, 9}, {4.7f, 9.9f, 9.2f, 8.9f}};
     Qual a média da sala?

     2. Imprima os padrões abaixo usando uma matriz. Para facilitar, crie uma função capaz de
    imprimir uma matriz de tamanho NxN.
     a)
     1 2 3 4
     5 6 7 8
     9 10 11 12
     13 14 15 16

     b)
     x  -  -  -
     -  x  -  -
     -  -  x  -
     -  -  -  x

    c)
    x  -  -  -
    x  x  -  -
    x  x  x  -
    x  x  x  x

    d)
      x  x  x  x
      -  x  x  x
      -  -  x  x
      -  -  -  x
     */

    // 1.
    private float mediaDaTurma (float[][] matriz) {
        float soma = 0;
        int quantidade = 0;

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                soma += matriz[i][j];
                quantidade++;
            }
        }
        return soma / quantidade;
    }

    // 2.
    private void imprimindoMatrizes1 () {
        int aux = 1;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(aux + " ");
                aux++;
            }
            System.out.println();
        }
    }

    private void imprimindoMatrizes2 () {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (i == j) {
                    System.out.print("x ");
                } else {
                    System.out.print("- ");
                }
            }
            System.out.println();
        }
    }

    private void imprimindoMatrizes3 () {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (i >= j) {
                    System.out.print("x ");
                } else {
                    System.out.print("- ");
                }
            }
            System.out.println();
        }
    }

    private void imprimindoMatrizes4 () {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (i <= j) {
                    System.out.print("x ");
                } else {
                    System.out.print("- ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Exercicios2 exercicio = new Exercicios2();

        //float[][] matriz = {{8.8f, 9, 7.6f, 4}, {8.9f, 9.7f, 9.4f, 8.9f}, {10, 10, 9, 9}, {4.7f, 9.9f, 9.2f, 8.9f}};
        //System.out.println(exercicio.mediaDaTurma(matriz));
        exercicio.imprimindoMatrizes1();
        System.out.println();
        exercicio.imprimindoMatrizes2();
        System.out.println();
        exercicio.imprimindoMatrizes3();
        System.out.println();
        exercicio.imprimindoMatrizes4();
    }
}
