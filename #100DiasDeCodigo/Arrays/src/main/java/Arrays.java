public class Arrays {

    private void imprimeArray (int[] array) throws NullPointerException {
        if (array == null) {
            throw new NullPointerException("Array não pode ser nulo!");
        }

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public static void main(String[] args) {
        int[] array1 = new int[10];
        int[] array2 = null;
        int[] array3 = {1, 2, 3, 4, 5, 6};

        //System.out.println(array1[0]);

        Arrays arrays = new Arrays();

        try {
            arrays.imprimeArray(array2);
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }
}
