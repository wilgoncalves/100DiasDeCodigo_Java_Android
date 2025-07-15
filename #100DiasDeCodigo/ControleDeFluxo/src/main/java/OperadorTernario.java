public class OperadorTernario {
    private String maiorDeIdade (int idade) {
        /*if (idade >=18) {
            return "Maior de idade";
        } else {
            return "Menor de idade";
        }*/

        return (idade >= 18) ? "Maior de idade" : "Menor de idade";
        // (expressão) ? INSTRUÇÃO_TRUE : INSTRUÇÃO_FALSE
    }

    public static void main(String[] args) {
        OperadorTernario ternario = new OperadorTernario();
        System.out.println(ternario.maiorDeIdade(18));
    }
}
