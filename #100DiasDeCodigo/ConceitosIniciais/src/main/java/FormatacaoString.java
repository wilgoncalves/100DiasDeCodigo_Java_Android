import java.util.Locale;

public class FormatacaoString {
    public static void main(String[] args) {

        String nome = "John";
        System.out.println("Ola, " + nome);

        String str = String.format("Ola, %s", nome); // placeholder
        System.out.println(str);

        /*
        * %s - String
        * %d - Integer
        * $f - Ponto flutuante
        * %c - Character
        * %b - Boolean
        */

        int valor = 5;
        float salario = 8469.28F;

        String valorESalario = String.format("Valor: %d - Salario: %f", valor, salario);
        System.out.println();
        System.out.println(valorESalario);

        valorESalario = String.format("Valor: %02d - Salario: %.2f", valor, salario);
        System.out.println();
        System.out.println(valorESalario);

        valorESalario = String.format(Locale.CANADA, "Valor: %02d - Salario: %.2f", valor, salario);
        System.out.println();
        System.out.println(valorESalario);
    }
}
