// funções = métodos
public class Funcoes {

    private void sayHello() {
        System.out.println("Hello, World!");
    }

    private void sayHello(String name) {
        System.out.println("Hello, " + name + "!");
    }

    private int sum(int n1, int n2) {
        return n1 + n2;
    }

    public static void main(String[] args) {

        Funcoes funcoes = new Funcoes();
        funcoes.sayHello();
        funcoes.sayHello("Willian");
        System.out.println(funcoes.sum(5, 4));
    }
}
