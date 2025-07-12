public class FluxoIfElse {

    private boolean maiorDeIdade (int idade) {
        return idade >= 18;
    }

    /*
    * Valor da mensalidade:
    *
    * matematica - 500
    * informatica - 600
    * geografia - 700
    * */
    private float calculoMensalidade (String curso) {
        if (curso.equals("matematica")) {
            return 500;
        } else if (curso.equals("informatica")) {
            return 600;
        } else {
            return 700;
        }
    }

    public static void main(String[] args) {

        FluxoIfElse ifElse = new FluxoIfElse();
        System.out.println(ifElse.maiorDeIdade(25));
        System.out.println("A mensalidade é: " + ifElse.calculoMensalidade("informatica"));

        String frase = "Programação Java";

        /*
        if (frase.contains("Java")) {
            System.out.println("Contem Java!");
        }

        if (!frase.contains("asdifhbi")) { // operador de negação "!"
            System.out.println("Nao contem a string asdifhbi");
        }
         */

        if (frase.contains("Javaaa")) {
            System.out.println("Contem Javaaa!");
        } else {
            System.out.println("Nao contem Javaaa!");
        }
    }
}
