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


    public static void main(String[] args) {
        Exercicios exercicios = new Exercicios();
        String[] nomes = {"Natasha Alianovna Romanoff", "Stephen Vincent Strange", "Anthony Edward Stark"};
        exercicios.maiorString(nomes);
    }
}
