import java.util.*;

public class Main {

    /*
    private static void handleList(List<Integer> list) {
        for (Object o : list) {
            System.out.println(o.getClass().getSimpleName());
        }
    }
     */

    // GENERICS: possibilidade de parametrizar os tipos de dados
    private <T> void handleList(List<T> list) {
        for (T o : list) {
            System.out.println(o.getClass().getSimpleName());
        }
    }

    public static void main(String[] args) {

        // LISTAS:
        int[] array = new int[10];

        // ao não determinar o tipo da lista, a lista recebe variáveis de qualquer tipo
        //ArrayList list = new ArrayList();
        List<Integer> list = new ArrayList<>();

        list.add(15);
        list.add(18);
        list.add(30);
        //list.add(false);
        //list.add("String");
        //list.add(10.5D);

        //handleList(list);
        // Generics:
        new Main().handleList(list);

        list.size(); // verifica tamanho da lista
        list.remove(0); // remove elementos da lista
        list.isEmpty(); // verifica se lista está vazia
        list.contains(15); // verifica se lista possui determinado valor
        list.indexOf(18); // verifica a posição de determinado valor
        list.clear(); // remove os elementos da lista

        // Usando Generics em classes:
        new Caixa<String>().empacotar("sapato");
        // O generics permite que o tipo de dado seja determinado em sua instância

        // SET:
        // Tipo de coleção que não permite elementos duplicados.
        Set<String> set = new HashSet<>();

        set.add("A");
        set.add("B");
        set.add("C");
        set.add("C");
        set.add("C");

        for (String s : set) {
            System.out.println(s);
        }

        set.remove("A");
        set.contains("B");
        set.clear();

        // MAP:
        // Tipo de estrutura que permite uma chave e valor.
        Map<String, String> map = new HashMap<>();

        map.put("França", "Pariss");
        map.put("França", "Paris");
        map.put("Alemanha", "Berlim");

        System.out.println(map.keySet());
        System.out.println(map.values());

        // Obtendo o valor do Map:
        System.out.println(map.get("Françaa"));
        System.out.println(map.get("França"));

        map.containsKey("Alemanha");
        map.clear();

        map.remove("Alemanha");

        // FILA:
        // FIFO (first-in first-out)
        Queue<String> fila = new LinkedList<>();

        fila.add("Elizabeth");
        fila.add("Will");
        fila.add("Jack");

        System.out.println(fila.poll()); // remove o primeiro item da fila
        System.out.println(fila.peek()); // obtém o primeiro item da fila

        fila.isEmpty(); // verifica se a fila está vazia
        System.out.println(fila.size()); // verifica o tamanho da fila

        for (String s : fila) {
            System.out.println(s);
        }

        // PILHA:
        // LIFO (last-in first-out)
        Stack<String> pilha = new Stack<>();

        pilha.isEmpty();
        pilha.size();
        pilha.clear();

        pilha.push("Item 1");
        pilha.push("Item 2");
        pilha.push("Item 3");

        System.out.println(pilha.peek());
        pilha.pop();

        for (String s : pilha) {
            System.out.println(s);
        }
    }
}
