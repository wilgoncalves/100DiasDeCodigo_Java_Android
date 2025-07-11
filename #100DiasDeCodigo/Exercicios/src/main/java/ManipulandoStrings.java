public class ManipulandoStrings {
    public static void main(String[] args) {
        String frase = "Estou estudando Java";

        System.out.printf("Maiuscula: %s%n", frase.toUpperCase());
        System.out.printf("Minuscula: %s%n", frase.toLowerCase());
        System.out.printf("Tamanho da string: %s%n", frase.length());
        System.out.printf("A String contem a palavra 'Java'? R = %s%n", frase.contains("Java"));
    }
}
