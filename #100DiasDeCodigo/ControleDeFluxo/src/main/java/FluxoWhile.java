public class FluxoWhile {
    public static void main(String[] args) {

        /*while (INSTRUÇÃO) {
            corpo
        }
        */

        int i = 0;
        while (i < 50) {
            System.out.println(i);
            i += 5;
        }

        String frase = "Programacao Java";
        int j = frase.length() - 1;
        while (j >= 0) {
            System.out.print(frase.charAt(j));
            j--;
        }
    }
}
