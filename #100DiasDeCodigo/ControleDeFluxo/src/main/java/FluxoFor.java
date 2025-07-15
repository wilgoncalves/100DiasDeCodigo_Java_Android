public class FluxoFor {
    public static void main(String[] args) {

        /* for (INSTRUÇÃO1; INSTRUÇÃO2; INSTRUÇÃO3) {
            corpo
        }
        */

        for (int i = 0; i < 10; i++) {
            System.out.println(i);
            System.out.println();
        }

        for (int i = 0; i < 10; i++) {
            if (i == 5) {
                break;
            }
            System.out.println(i);
        }

        for (int i = 0; i < 10; i++) {
            if (i == 5) {
                continue;
            }
            System.out.println(i);
            System.out.println();
        }

        for (int i = 0; i < 10;) {
            System.out.println(i);
            i += 5;
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(i);
            for (int j = 0; j < 5; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }
}
