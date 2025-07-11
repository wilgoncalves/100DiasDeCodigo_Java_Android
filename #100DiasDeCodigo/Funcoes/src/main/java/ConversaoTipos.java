public class ConversaoTipos {
    private void conversaoImplicita() {
        // byte, short, int, long, float e double

        byte a = 10;
        short b = a; // byte é menor que short.
        int c = b;
        long d = c;
        float e = d;
        double f = e;
    }

    private void conversaoExplicita() {
        // byte, short, int, long, float e double

        double a = 100.65;
        float b = (float)a;
        long c = (long)b;
        int d = (int)c;
        short e = (short)d;
        byte f = (byte)e;
    }

    // boxing e unboxing
    private void boxing() {
        // auto-boxing
        int a = 10;
        Integer b = a;
        // quando uma variável primitiva é atribuída a um objeto.
    }

    private void unboxing() {
        Long a = 10L;
        long b = a;
    }

    private void conversaoPorMetodos() {
        System.out.println(Double.parseDouble("10.5"));
    }

    public static void main(String[] args) {
        ConversaoTipos conversao = new ConversaoTipos();
        conversao.conversaoPorMetodos();
    }
}
