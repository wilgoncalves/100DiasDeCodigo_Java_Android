import java.util.Scanner;

public class Exercicios2 {
    /* Escreva um programa capaz de ler dois números que representam os lados de uma figura
    geométrica. Informar se formam um quadrado (lados iguais). */
    private void formaQuadrado () {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe o primeiro lado: ");
        double a = scanner.nextDouble();
        System.out.println("Informe o segundo lado: ");
        double b = scanner.nextDouble();

        if (a == b) {
            System.out.println("Forma quadrado!");
        } else {
            System.out.println("Não forma quadrado!");
        }
    }

    /*  Escreva um programa capaz de ler três números que representam os lados de um triângulo.
    Informar se é um triângulo equilátero (todos os lados iguais) */
    private void formaTriangulo () {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe o primeiro lado: ");
        double a = scanner.nextDouble();
        System.out.println("Informe o segundo lado: ");
        double b = scanner.nextDouble();
        System.out.println("Informe o terceiro lado: ");
        double c = scanner.nextDouble();

        if ((a == b) && (b == c)) {
            System.out.println("E um triangulo equilatero!");
        } else {
            System.out.println("Nao e um triangulo equilatero!");
        }
    }

    /*
    * Escreva um programa para ser usado na de portaria de um evento.
         a. Peça a idade. Menores de idade não são permitidos. Mensagem: “Negado. Menores de idade não são
        permitidos.”.
         b. Peça o tipo de convite. Os tipos de convite são comum, premium e luxo. Negar a entrada caso não seja
        nenhum destes.  Mensagem: “Negado. Convite inválido.”.
         c. Peça o código do convite. Convites premium e luxo começam com “XL”. Convites comuns começam
        com “XT”. Caso o código não esteja nos padrões, negar a entrada.  Mensagem: “Negado. Convite
        inválido.”.
         d. Caso todos os critérios sejam satisfeitos, exibir “Welcome :)” */
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
        Exercicios2 exercicios = new Exercicios2();
        exercicios.formaQuadrado();
        exercicios.formaTriangulo();
        exercicios.verificaConvite();

        scanner.close();
    }
}
