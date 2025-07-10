public class FuncionalidadesString {
    public static void main(String[] args) {

        String str = "Curso de Java!";
        System.out.println("Tamanho: " + str.length());
        System.out.println("Caractere na posição (0): " + str.charAt(0));
        System.out.println(str.equals("curso de java!")); // false
        System.out.println(str.equalsIgnoreCase("curso DE JAVA!")); // true
        System.out.println(str.startsWith("Curso")); // true
        System.out.println(str.endsWith("!")); // true
        System.out.println(str.contains("Curso")); // true

        System.out.println(str.substring(5));
        System.out.println(str.replace("Java!", "Java muito legal!"));
        System.out.println(str.toUpperCase());
        System.out.println(str.toLowerCase());

        System.out.println("    nome de pessoa   ".trim());
    }
}
