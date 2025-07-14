public class Exercicios {
    /*
    * Escreva um programa para ajudar a empresa XPTO calcular o bônus que os funcionários
    receberão no final do ano. Os bônus são classificados por cargo.
     a. Gerentes recebem R$ 2.000,00
     b. Coordenadores recebem R$ 1.500,00
     c. Engenheiros de software recebem R$ 1.000,00
     d. Estagiários recebem R$ 500,00 */
    private float calculoBonus (String cargo) {
        switch (cargo) {
            case "Gerente":
                return 2000;
            case "Coordenador":
                return 1500;
            case "Engenheiro de software":
                return 1000;
            default:
                return 500;
        }
    }

    /*
    * Modifique o primeiro exercício para considerar o tempo de experiência no cálculo de bônus.
     a. Gerentes com menos de 2 anos de experiência recebem R$ 2.000,00, caso contrário recebem R$
    3.000,00
     b. Coordenadores com menos de 1 ano de experiência recebem R$ 1.500,00, caso contrário recebem R$
    1.800,00
     c. Engenheiros de software recebem R$ 1.000,00
     d. Estagiários recebem R$ 500,00
    */
    private float calculoBonusExperiencia (String cargo, float experiencia) {
        if (cargo.equals("Gerente")) {
            if (experiencia < 2.0) {
                return 2000;
            } else {
                return 3000;
            }
        } else if (cargo.equals("Coordenador")) {
            if (experiencia < 1.0) {
                return 1500;
            } else {
                return 1800;
            }
        } else if (cargo.equals("Engenheiro de software")) {
            return 1000;
        } else {
            return 500;
        }
    }

    public static void main(String[] args) {

        Exercicios exercicios = new Exercicios();
        System.out.println(exercicios.calculoBonus("Engenheiro de software"));
        System.out.println(exercicios.calculoBonusExperiencia("Gerente", 10));
        System.out.println(exercicios.calculoBonusExperiencia("Gerente", 1));
        System.out.println(exercicios.calculoBonusExperiencia("Coordenador", 5));
        System.out.println(exercicios.calculoBonusExperiencia("Coordenador", 0.5F));
        System.out.println(exercicios.calculoBonusExperiencia("Estagiário", 2));

        /*
        * Qual o resultado das comparações abaixo?
         a = false b = false c = true d = true
         (a && b && c && d)
         *
         a = false b = false c = true d = true
         (!a && !b && (c && d))
         *
         a = false b = false c = true d = true
         (a && ((b || c) || d))
         *
         a = false b = false c = true d = true
         (a || ((!b && c) || !d)*/

        boolean a = false;
        boolean b = false;
        boolean c = true;
        boolean d = true;

        System.out.println(a && b && c && d); // false
        System.out.println(!a && !b && (c && d)); // true
        System.out.println(a && ((b || c) && d)); // false
        System.out.println(a || ((!b && c) || !d)); // true

    }
}
