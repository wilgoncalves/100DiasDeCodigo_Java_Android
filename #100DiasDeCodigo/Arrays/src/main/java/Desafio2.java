import java.util.Locale;
import java.util.Scanner;

public class Desafio2 {
    /*
     Implemente um software para gerenciar os assentos em uma sala de cinema. Considere uma sala de 5 fileiras de assentos e 8
    colunas.
    O software deve ser capaz de perguntar ao usuário qual a fileira e qual a coluna. Caso o assento esteja ocupado, não permita a
    reserva. Caso esteja livre, faça a reserva.
    Para que o controle fique mais visual, imprima todos os lugares da sala de cinema no console e marque com ‘x’ os lugares
    ocupados e ‘-’ os lugares disponíveis.
    Caso o usuário informe linhas ou colunas inválidas, repita a pergunta.
    (Caso deseje, faça alterações para incrementar a funcionalidade do software)
     */

    // int[][] salaDeCinema = new int[5][8];
    /*private void reservaDeAssentos (int linha, int coluna) {
        Scanner scanner = new Scanner(System.in);
        char[][] assentos = new char[5][8];

        for (int i = 0; i < assentos.length; i++) {
            for (int j = 0; j < assentos[i].length; j++) {
                assentos[i][j] = '-';
            }
        }

        do {
            System.out.println("Informe a linha: ");
            linha = scanner.nextInt();
            System.out.println("Informe a coluna: ");
            coluna = scanner.nextInt();
        } while (assentos[linha][coluna] == 'x');

    } */

    char[][] assentos = new char[5][8];

    private void iniciaReserva() {
        for (int i = 0; i < assentos.length; i++) {
            for (int j = 0; j < assentos[i].length; j++) {
                assentos[i][j] = '-';
            }
        }
    }

    private void imprimeAssentos() {
        for (int i = 0; i < assentos.length; i++) {
            for (int j = 0; j < assentos[i].length; j++) {
                System.out.print(assentos[i][j] + " ");
            }
            System.out.println();
        }
    }

    private int informaPosicao(int max, boolean isLinha) {
        Scanner scanner = new Scanner(System.in);

        String linhaColuna = isLinha ? "linha" : "coluna";

        int posicao = -1;
        do {
            try {
                System.out.print("Informe a " + linhaColuna + " (1 - " + (max + 1) + "): ");
                posicao = scanner.nextInt() - 1;

                if (posicao < 0 || posicao > max) {
                    posicao = -1;
                    System.out.println("Valor invalido - " + linhaColuna + "s de 1 a " + (max + 1) + ".");
                }
            } catch (Exception e) {
                System.out.println("Valor invalido!");
                scanner.nextLine();
            }
        } while (posicao == -1);

        return posicao;
    }

    private void finalizaReserva (int linha, int coluna) {
        if (assentos[linha][coluna] == 'x') {
            System.out.println("Posicao ocupada. Escolha outro assento!");
        } else {
            assentos[linha][coluna] = 'x';
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Desafio2 desafio = new Desafio2();
        desafio.iniciaReserva();

        String resposta;
        do {
            desafio.imprimeAssentos();
            int linha = desafio.informaPosicao(4, true);
            int coluna = desafio.informaPosicao(7, false);
            desafio.finalizaReserva(linha, coluna);

            System.out.print("Deseja continuar? (s/n) ");
            resposta = scanner.nextLine().toLowerCase();
        } while (resposta.equals("s"));

        System.out.println("Tenha um otimo filme!");
    }
}
