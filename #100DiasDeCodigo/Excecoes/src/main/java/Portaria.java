import java.util.Scanner;

// bug
// debug = depurar

public class Portaria {

    private void verificaConvite() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe a idade: ");
        int idade = scanner.nextInt();

        if (idade < 18) {
            System.out.println("Negado. Menores de idade nao sao permitidos.");
            return;
        }

        System.out.println("Informe o tipo do convite (Comum/Premium/Luxo): ");
        scanner.nextLine();
        String tipo = scanner.nextLine().toLowerCase();

        if (!tipo.equals("comum") && !tipo.equals("premium") && !tipo.equals("luxo")) {
            System.out.println("Negado. Convite invalido.");
            return;
        }

        System.out.println("Informe o codigo do convite (XL/XT): ");
        String codigo = scanner.nextLine().toLowerCase();

        if ((tipo.equals("premium") || tipo.equals("luxo")) && codigo.startsWith("xl")) {
            System.out.println("Welcome :)");
        } else if (tipo.equals("comum") && codigo.startsWith("xt")) {
            System.out.println("Welcome :)");
        } else {
            System.out.println("Negado. Convite invalido.");
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Portaria portaria = new Portaria();
        portaria.verificaConvite();

        scanner.close();
    }
}
