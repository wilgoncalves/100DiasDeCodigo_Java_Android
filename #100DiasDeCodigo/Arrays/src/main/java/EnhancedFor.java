public class EnhancedFor {

    // varargs: int[] = int...
    private void imprimeArray (int... array) {
        if (array != null) {
            // Enhanced for:
            /*
            * for (VARIAVEL : ARRAY) {
            *
            * }
            * */
            for (int valor : array) {
                System.out.println(valor);
            }
        }
    }

    public static void main(String[] args) {
        //int[] array = {1, 2, 3, 4, 5, 6};
        EnhancedFor enhancedFor = new EnhancedFor();
        enhancedFor.imprimeArray(1, 2, 3, 7, 3, 9, 11, 23); // varargs
    }
}
