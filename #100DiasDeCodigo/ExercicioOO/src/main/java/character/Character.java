package character;

import java.util.Random;

/**
 * Classe abstrata que representa um personagem no jogo.
 * Define atributos básicos como vida, ataque e defesa, além de métodos para ataque e dano.
 */
public abstract class Character {

    // Quantidade de vida do personagem.
    protected int health;

    // Poder de ataque do personagem.
    protected int attack;

    // Poder de defesa do personagem.
    protected int defense;

    // Construtor:
    public Character (int health, int attack, int defense) {
        this.health = health;
        this.attack = attack;
        this.defense = defense;
    }

    // Método abstrato que deve ser implementado por subclasses para definir o ataque do personagem.
    public abstract int attack();

    // Aplica dano ao personagem, considerando sua defesa.
    public void receiveDamage (int damage) {
        // Exercicio: Pesquise como implementar 25% de chance do personagem esquivar do ataque.
        // Implementando exercício:
        Random random = new Random();
        // Gera um número aleatório entre 0 e 3 (25% de chance quando o número é 0).
        if (random.nextInt(4) == 0) { // 0, 1, 2, 3 - 0 tem 25% de chance
            System.out.println(this + " esquivou do ataque!");
            return; // O personagem esquiva, então não recebe dano
        }

        int damageTaken = Math.max(damage - defense, 0);
        health = Math.max(health - damageTaken, 0);
        System.out.println(this + " recebeu " + damageTaken + " de dano! Vida atual: " + health);
    }

    // Verifica se o personagem ainda está vivo.
    public boolean isAlive() {
        return health > 0;
    }
}
