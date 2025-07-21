public class Desafio1 {
    /*
     Considere a função abaixo responsável por calcular o fatorial de um número:
     private long fatorial(int n) {
            if (n == 0 || n == 1)
                return 1;
            long resultado = 1;
            while (n > 1) {
                resultado *= n;
                n--;
            }
            return resultado;
        }
     Toda vez que essa função é chamada, o cálculo do fatorial é executado passando por todos os passos. Por exemplo, fazer a
    chamada a função fatorial(7) e novamente fatorial(7) executará os mesmos passos.
     É possível melhorar a performance desta função? Seria possível salvar o valor de um número fatorial e caso esse mesmo
     número seja chamado, retornar o valor já calculado ao invés de executar todo o cálculo novamente?
     Considere que o maior número para calcular o fatorial seja 10. Caso o valor seja maior que 10, retorne 1
     */

    // CACHE: evita o processamento repetitivo de informação.
    long[] array = new long[11];

    private long calculandoFatorial (int n) {
        int numero = n;

        if (array[n] != 0) {
            return array[n];
        }

        if (n == 0 || n == 1) {
            return 1;
        }

        long resultado = 1;
        while (n > 1) {
            resultado *= n;
            n--;
        }

        array[numero] = resultado;
        return resultado;
    }

    public static void main(String[] args) {
        Desafio1 desafio = new Desafio1();
        System.out.println(desafio.calculandoFatorial(9));
        System.out.println(desafio.calculandoFatorial(9));
    }
}
