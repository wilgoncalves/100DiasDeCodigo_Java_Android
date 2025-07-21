public class Multidimensional {
    public static void main(String[] args) {

        int[][] matriz = {{1, 8, 4, 7}, {2, 5, 3, 4}, {3, 6, 2, 9}}; // int[3][4] array de 3 linhas e 4 colunas.

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }
}
