import java.util.Locale;

public class Main {

    public String controlePortaria(int idade, String tipoConvite, String codigoConvite) {
        tipoConvite = tipoConvite.toLowerCase();
        codigoConvite = codigoConvite.toLowerCase();

        if (idade < 18) {
            return "Negado. Menores de idade nao sao permitidos.";
        }

        if (!tipoConvite.equals("comum") && !tipoConvite.equals("premium") && !tipoConvite.equals("luxo")) {
            return "Negado. Convite invalido.";
        }

        if ((tipoConvite.equals("premium") || tipoConvite.equals("luxo")) && codigoConvite.startsWith("xl")) {
            return "Welcome :)";
        }

        if (tipoConvite.equals("comum") && codigoConvite.startsWith("xt")) {
            return "Welcome :)";
        }

        return "Negado. Convite invalido.";
    }

    public static void main(String[] args) {

        Main main = new Main();
        main.controlePortaria(18, "comum", "xt934757");

    }
}
