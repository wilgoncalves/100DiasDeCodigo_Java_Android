import eletronico.Computador;
import eletronico.Eletronico;
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

    // POLIMORFISMO:
    private void imprimeFuncionamentoLigar(Eletronico e) {
        // lógica
        /*
        a função possui sua lógica de funcionamento e logo após
        chama a função ligar() dentro da classe anônima.
        */
        e.ligar();
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

        // POLIMORFISMO:
        Eletronico e1 = new Computador();
        Eletronico e2 = new Microfone();

        new Main().imprimeFuncionamentoLigar(e1);
        new Main().imprimeFuncionamentoLigar(e2);

        // CLASSE ANÔNIMA:
        new Main().imprimeFuncionamentoLigar(new Eletronico() {
            @Override
            public void ligar() {
                System.out.println("Estou ligando classe anônima");
            }
        });

        // LAMBDA:
        new Main().imprimeFuncionamentoLigar(() -> {
            System.out.println("Estou ligando classe anônima");
            System.out.println("Estou ligando classe anônima");
            System.out.println("Estou ligando classe anônima");
        });


    }
}
