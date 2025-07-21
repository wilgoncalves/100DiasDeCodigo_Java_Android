public class Exercicios {
    // ARRAY UNIDIMENSIONAL

    /*
    1. Considere o código abaixo para ser usado no exercício. Escreva um código capaz de informar
    qual o índice que possui a maior String.
     String[] nomes = {"Natasha Alianovna Romanoff", "Stephen Vincent Strange", "Anthony Edward Stark"};

     2. Escreva uma função capaz de receber um array de float e retornar a média dos valores.
     Se o array for vazio ou nulo, retornar 0. Teste com os arrays abaixo:
     float[] valores = {14f, 5.3f, 63.5f, 34f, 15f};
     float[] valores = {};
     float[] valores = null;
     */

    // 1.
    private void maiorString(String[] nomes) {
        int tamanho = 0;
        int index = 0;
        for (int i = 0; i < nomes.length; i++) {
            if (nomes[i].length() > tamanho) {
                tamanho = nomes[i].length();
                index = i;
            }
        }
        System.out.println("Indice: [" + index + "] possui o maior tamanho: " + tamanho);
    }

    // 2.
    private float mediaDeValores (float[] valores) {
        if (valores == null || valores.length == 0) {
            return 0;
        }

        float soma = 0;
        for (int i = 0; i < valores.length; i++) {
            soma += valores[i];
        }

        return soma / valores.length;
    }

    public static void main(String[] args) {
        Exercicios exercicios = new Exercicios();
        String[] nomes = {"Natasha Alianovna Romanoff", "Stephen Vincent Strange", "Anthony Edward Stark"};
        exercicios.maiorString(nomes);

        float[] valores1 = {14f, 5.3f, 63.5f, 34f, 15f};
        float[] valores2 = {};
        float[] valores3 = null;
        System.out.println("A média dos valores é: " + exercicios.mediaDeValores(valores3));
    }
}
