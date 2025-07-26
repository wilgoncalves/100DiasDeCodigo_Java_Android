import character.*;
import character.Character;
import utils.CharacterOptions;

import java.util.Scanner;

// Exercicio: Ponto de entrada está com mais de 40 linhas de lógica. Como melhorar usando funções?
// Resolvendo exercício:
public class Main {

    private static final int SLEEP_TIMER = 2500;

    public static void main(String[] args) {
        // Escolha do personagem hero
        Character hero = getHero();

        // Cria o inimigo
        Character enemy = createEnemy();

        // Inicia a batalha
        Battle.start(hero, enemy);

        // Sistema de jogo - Executa até que acabe a batalha:
        Thread battleThread = new Thread(() -> {
           while (hero.isAlive() && enemy.isAlive()) {
               Battle.fight();
               sleep(SLEEP_TIMER);
           }
        });

        // Inicializa:
        battleThread.start();
    }

    private static String getUserChoice() {
        Scanner scanner = new Scanner(System.in);
        String character;

        do {
            System.out.println("Escolha seu personagem: ");
            System.out.println("Arqueiro (A)");
            System.out.println("Mago (M)");
            character = scanner.nextLine().trim().toLowerCase();
        } while (!character.equals("a") && !character.equals("m"));

        return character;
    }

    private static Character getHero() {
        String character = getUserChoice();

        // Exercicio: É possível evitar comparação de Strings? Alguma outra opção mais segura?
        // Resolvendo exercício:
        CharacterOptions option = character.equals("a") ? CharacterOptions.Archer : CharacterOptions.Wizard;

        // Exercicio: É possível evitar comparação de Strings? Alguma outra opção mais segura?
        // Resolvendo exercício:
        if (option == CharacterOptions.Archer) {
            return new Archer(100, 15, 10);
        } else {
            return new Wizard(100, 15, 10);
        }
    }

    private static Character createEnemy() {
        return new Goblin(100, 18, 5);
    }

    private static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException ignored) {

        }
    }
}
