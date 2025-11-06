public class Main {
    public static void main(String[] args) {

        /*
        if (condicao) {
            executa caso condicao seja satisfeita
        }
        */

        int idade = 17;
        if (idade > 18) {
            System.out.println("Maior de idade!");
        } else {
            System.out.println("Menor de idade!");
        }

        int opcao = 4;
        if (opcao == 1) {
            System.out.println("Cartão de crédito selecionado!");
        } else if (opcao == 2) {
            System.out.println("Saldos da sua conta!");
        } else if (opcao == 3) {
            System.out.println("Descontos indevidos!");
        } else {
            System.out.println("Falar com atendente!");
        }

        int idade1 = 18;
        if (idade1 < 12) {
            System.out.println("Crianca");
        } else if (idade1 >= 12 && idade1 <= 18) {
            System.out.println("Adolescente");
        } else {
            System.out.println("Adulto");
        }
    }
}
