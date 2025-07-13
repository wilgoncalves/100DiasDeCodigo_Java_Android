public class Operadores {
    /*
    * Cáluclo de bônus de funcionário baseado em tempo de empresa
    * Menos de um ano -> 500
    * 1 a 3 anos -> 2000
    * 4 anos ou mais -> 5000
    * Se tiver o cargo diretor, valor do bonus -> 10000 */

    private float calculoBonus (int experiencia, String cargo) {
        // EARLY RETURN
        if (cargo.equals("Diretor")) {
            return 10000;
        }

        if (experiencia == 0) {
            return 500;
        } else if (experiencia >= 1 && experiencia <= 3) {
            return 2000;
        } else {
            return 5000;
        }
    }

    public static void main(String[] args) {
        Operadores operadores = new Operadores();
        System.out.println(operadores.calculoBonus(0, "Diretor"));
    }
}
