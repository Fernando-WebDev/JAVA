public class Card {
    private final String face; // Ex: "Ás", "Dois", "Rei"
    private final String suit; // Ex: "Copas", "Espadas"

    // Construtor que inicializa a face e o naipe [cite: 131]
    public Card(String face, String suit) {
        this.face = face;
        this.suit = suit;
    }

    // Retorna a representação textual formatada [cite: 132]
    @Override
    public String toString() {
        return face + " de " + suit; // Ex: "Ás de Copas"
    }
}