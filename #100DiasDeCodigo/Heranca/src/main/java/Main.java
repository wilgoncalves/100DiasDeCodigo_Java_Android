import eletronico.Computador;
import eletronico.Microfone;

public class Main {

    // sobrescrita
    @Override
    public String toString() {
        return "Este é o toString da Main";
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    // sobrecarga:
    private void abc() {

    }

    private void abc(int id) {

    }

    private void abc(byte id) {

    }

    public static void main(String[] args) {

        Microfone microfone = new Microfone();
        Computador computador = new Computador();
        new Computador().ligar();
        computador.instalarSoftware();

        // superclasse Object:
        Main main = new Main();
        Main main2 = new Main();

        System.out.println(main.toString()); // sobrescrita
        System.out.println(main.hashCode());
        System.out.println(main.equals(main2));
    }
}
