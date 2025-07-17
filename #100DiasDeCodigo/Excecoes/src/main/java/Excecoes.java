import java.util.Scanner;

public class Excecoes {

    private float divisao (float n1, float n2) throws Exception {
        if (n2 == 0) {
            throw new Exception("Divisor não pode ser zero.");
        }

        return n1 / n2;
    }

    public static void main(String[] args) {

        // NullPointerException
        //Integer i = null;
        //System.out.println(i.byteValue());

        // InputMismatchException
        //Scanner scanner = new Scanner(System.in);
        //int a = scanner.nextInt();

        // StringIndexOutOfBoundsException
        //String str = "abc";
        //str.charAt(15);

        Excecoes excecoes = new Excecoes();
        try {
            System.out.println(excecoes.divisao(10, 0));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // Tratando exceções:
        try {
            Integer i = null;
            System.out.println(i.byteValue());

            Scanner scanner = new Scanner(System.in);
            System.out.println("Digite um numero: ");
            int a = scanner.nextInt();

            String str = "abc";
            str.charAt(15);

            scanner.close();
        } /* catch (NullPointerException exception) {
            // Tratando NullPointerException
            System.out.println("Conversão incorreta!");

        } catch (InputMismatchException exception) {
            // Tratando InputMismatchException
            System.out.println("");

        } catch (StringIndexOutOfBoundsException exception) {
            // Tratando StringIndexOutOfBoundsException
            System.out.println("");

        }*/ catch (Exception e) {
            // Exceção genérica:
            System.out.println("Erro ao informar dados.");
        }
        finally {
            System.out.println("FINALLY!");
        }

        System.out.println("Fim do programa!");
    }
}
