public class SwitchCase {
    private float calculoMensalidade (String curso) {
        /*if (curso.equals("matematica")) {
            return 500;
        } else if (curso.equals("informatica")) {
            return 600;
        } else if (curso.equals("geografia")) {
            return 700;
        } else {
            return 0F;
        }*/

        // switch case
        float valor;
        switch (curso) {
            case "matematica": {
                valor = 500;
                break;
            }
            case "historia": // OU
            case "informatica": {
                valor = 600;
                break;
            }
            case "geografia": {
                valor = 700;
                break;
            }
            /*case "portugues" ->
                valor = 400;
            rule switch: para evitar o uso do "break", usamos o sinal "->"
            */
            default: {
                valor = 0;
            }
        }
        return valor;
    }

    public static void main(String[] args) {

    }
}
