public class FluxoDoWhile {
    public static void main(String[] args) {

        /*do {
            corpo
        } while (true);
        */

        int i = 100000;
        do {
            System.out.println(i);
            i++;
        } while (i < 10); // do/while executa pelo menos uma vez antes de verificar a condição.
    }
}
