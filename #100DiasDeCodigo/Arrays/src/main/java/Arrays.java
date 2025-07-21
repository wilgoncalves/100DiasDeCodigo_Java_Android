import java.util.InputMismatchException;
import java.util.Scanner;

public class Arrays {

    // ler três numeros do usuário e armazenar em um array
    private void preenchaTresNumeros () {
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[3];

        for (int i = 0; i < array.length;) {
            System.out.print("Informe número: ");
            try {
                int numero = scanner.nextInt();
                array[i] = numero;
                i++;
            } catch (InputMismatchException e) {
                System.out.println("Número inválido!");
                scanner.nextLine();
            }
        }
        // utilizando do/while:
        /*
        int i = 0;
        do {
            System.out.print("Informe número [" + (i + 1) + "]: ");
            try {
                int numero = scanner.nextInt();
                array[i] = numero;
                i++;
            } catch (InputMismatchException e) {
                System.out.println("Número inválido!");
                scanner.nextLine();
            }
        } while (i < array.length); */

        imprimeArray(array);
        scanner.close();
    }

    private void imprimeArray (int[] array) throws NullPointerException {
        if (array == null) {
            throw new NullPointerException("Array não pode ser nulo!");
        }

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public static void main(String[] args) {
        int[] array1 = new int[10];
        int[] array2 = null;
        int[] array3 = {1, 2, 3, 4, 5, 6};

        //System.out.println(array1[0]);

        Arrays arrays = new Arrays();

        try {
            arrays.imprimeArray(array2);
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }

        arrays.preenchaTresNumeros();
    }
}
