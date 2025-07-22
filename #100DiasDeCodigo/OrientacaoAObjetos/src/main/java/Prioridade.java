public enum Prioridade {
    Baixa(5),
    Media(15),
    Alta(30);

    private int id;

    Prioridade(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
