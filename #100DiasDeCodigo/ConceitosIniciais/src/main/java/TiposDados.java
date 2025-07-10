/**
 Type	    Bit     Intervalo
 Double	    64      [1.7976931348623157 x (10)^308, 4.9406564584124654 x (10)^-324]
 Float	    32      [3.40282347 x 10^(38), 1.40239846 x (10)^-45]
 Long	    64      [-9,223,372,036,854,775,808 - 9,223,372,036,854,775,807]
 Integer     32      [-2,147,483,648 - 2,147,483,647]
 Short	    16      [-32,768 .. 32,767]
 Byte	    8       [-128,127]
 Character   16      -
 String      ?       -
 Boolean     ?       [0,1]

 Lembrando sobre unidades de medida
 1 Byte = 8 bits
 1 kilobyte (kB) = 1024 bytes
 1 megabyte (MB) = 1024 kilobytes
 1 gigabyte (GB) = 1024 megabytes

 */

/**
 * O tamanho Boolean pode ser representado somente com 1 bit, true ou false
 * Porém o tamanho depende da JVM e a especificaçacão não deixa claro.
 * String - O tamanho de uma String depende de seu conteúdo.
 */

public class TiposDados {
    public static void main(String[] args) {

        Byte b = 100;
        Short s = 1000;
        Integer i = 1000000;
        Long l = 100000000L;
        Float f = 100.15425F;
        Double d = 12345432.23453249554681292346;
        Character c = 'd';
        String string = "Linguagem Java";
        Boolean umBoolean = true;

        System.out.println("Byte Min: " + Byte.MIN_VALUE + " - " + Byte.MAX_VALUE);
        System.out.println("Short Min: " + Short.MIN_VALUE + " - " + Short.MAX_VALUE);
        System.out.println("Integer Min: " + Integer.MIN_VALUE + " - " + Integer.MAX_VALUE);
        System.out.println("Long Min: " + Long.MIN_VALUE + " - " + Long.MAX_VALUE);
        System.out.println("Float Min: " + Float.MIN_VALUE + " - " + Float.MAX_VALUE);
        System.out.println("Double Min: " + Double.MIN_VALUE + " - " + Double.MAX_VALUE);

        // Tipos primitivos:

        byte b2 = 10;
        short s2 = 100;
        int i2 = 1000000;
        long l2 = 100000000L;
        float f2 = 100.15425F;
        double d2 = 12345432.23453249554681292346;
        char c2 = 'c';
        boolean b3 = false;
    }
}
