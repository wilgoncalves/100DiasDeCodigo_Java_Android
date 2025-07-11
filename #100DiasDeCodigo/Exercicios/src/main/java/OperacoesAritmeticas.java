public class OperacoesAritmeticas {
    public static void main(String[] args) {
        int a = 20;
        int b = 10;

        int soma = a + b;
        int divisao = a / b;
        int resto = a % b;

        System.out.printf("Soma: %d%n", soma);
        System.out.printf("Divisao: %d%n", divisao);
        System.out.printf("Resto da divisao: %d%n", resto);
        System.out.println("Pre-incremento: " + ++a);
        System.out.println("Valor de a: " + a);
        System.out.println("Pre-decremento: " + --b);
        System.out.println("Valor de b: " + b);
        System.out.println("Pos-incremento: " + a++);
        System.out.println("Valor de a: " + a);
        System.out.println("Pos-decremento: " + b--);
        System.out.println("Valor de b: " + b);
    }
}
