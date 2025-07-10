public class Operadores {
    public static void main(String[] args) {
        // + - / * %

        int numero = 10;

        System.out.println(numero + 15);
        System.out.println(numero - 15);
        System.out.println(numero / 2);
        System.out.println(numero * 5);
        System.out.println(numero % 2);
        System.out.println(numero % 3);

        numero += 15; // numero = numero + 15;
        numero -= 15;
        numero /= 15;
        numero *= 15;
        numero %= 2;

        int num = 0;

        System.out.println("Imprimi 1x");
        num++;

        System.out.println("Imprimi 2x");
        num++;

        System.out.println("Imprimi 3x");
        num++;

        System.out.println(num);

        /* Ordem de precedência dos operadores:
        * 1. ()
        * 2. * /
        * 3. - +
        * */


    }
}
