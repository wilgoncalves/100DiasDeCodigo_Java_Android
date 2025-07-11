import java.util.Scanner;

public class ExerciciosFuncoes {
    /*  Escreva um programa que seja capaz de receber a quantidade de anos e transformar em
        meses, dias, horas, minutos e segundos. Faça a leitura do teclado. Saída desejada:
         2 ano(s) corresponde a:
         24 meses
         730 dias
         17520 horas
         1051200 minutos
         63072000 segundos */
    private void transformandoAnos() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe a quantidade de anos: ");
        int anos = scanner.nextInt();

        int meses = anos * 12;
        int dias = anos * 365;
        int horas = dias * 24;
        int minutos = horas * 60;
        int segundos = minutos * 60;

        System.out.println(anos + " ano(s) corresponde(m) a:");
        System.out.println(meses + " meses");
        System.out.println(dias + " dias");
        System.out.println(horas + " horas");
        System.out.println(minutos + " minutos");
        System.out.println(segundos + " segundos");
    }

    // Escreva uma função capaz de receber uma string e retornar a quantidade de caracteres
    private int quantidadeCaracteres(String name) {
        return name.length();
    }

    // Escreva uma função capaz de calcular o cubo de um número (cubo = n*n*n)
    private void calculaAoCubo(int n) {
        int cubo = n * n *n;
        System.out.println(cubo);
    }

    // Escreva uma função capaz de receber milhas e converter em km (1 milha = 1,6km).
    private void conversaoParaKm(double milhas) {
        double conversor = milhas * 1.6;
        System.out.println(conversor + "km");
    }

    // Escreva uma função capaz de receber Celsius e converter Fahrenheit. F = (C * 9 / 5) + 32
    private void conversorTemperatura(double celsius) {
        double fahrenheit = (celsius * 9 / 5) + 32;
        System.out.println(fahrenheit + "F");
    }

    /*
    Escreva um programa que seja capaz de receber uma string e fazer a troca de todas as letras
    “a” ou “A” por “x”.
     a. Não deve existir lógica dentro da função main. Deve ser usada somente como ponto de entrada.
     b. Escrever uma função para ler a string.
     c. Escrever uma função para a troca de letras e impressão do valor final.
    d. String final deve estar com todas as letras minúsculas
     */
    private String lerString(String title) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(title);
        return scanner.nextLine();
    }

    private void manipulandoStrings(String frase) {
        System.out.println(frase.toLowerCase().replace("a", "x"));
    }

    public static void main(String[] args) {

        ExerciciosFuncoes funcoes = new ExerciciosFuncoes();

        funcoes.transformandoAnos();
        System.out.println(funcoes.quantidadeCaracteres("Willian Gonçalves"));
        funcoes.calculaAoCubo(4);
        funcoes.conversaoParaKm(2);
        funcoes.conversorTemperatura(28);
        funcoes.manipulandoStrings(funcoes.lerString("Escreva a sua frase: "));
    }
}
