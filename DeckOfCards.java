import java.security.SecureRandom;

public class DeckOfCards {
    private Card[] deck; // Array de objetos Card [cite: 133]
    private int currentCard; // Índice da próxima carta a ser distribuída [cite: 134]
    private static final int NUMBER_OF_CARDS = 52; // Total de cartas [cite: 134]
    
    private static final SecureRandom randomNumbers = new SecureRandom();

    // Construtor: preenche o baralho em português [cite: 136, 147]
    public DeckOfCards() {
        String[] faces = {"Ás", "Dois", "Três", "Quatro", "Cinco", "Seis", 
                          "Sete", "Oito", "Nove", "Dez", "Valete", "Dama", "Rei"};
        String[] suits = {"Copas", "Ouros", "Paus", "Espadas"};

        deck = new Card[NUMBER_OF_CARDS]; 
        currentCard = 0; 

        // Inicializa o baralho combinando as faces e naipes [cite: 136]
        for (int count = 0; count < deck.length; count++) {
            deck[count] = new Card(faces[count % 13], suits[count / 13]);
        }
    }

    // Embaralha o vetor de cartas [cite: 137]
    public void shuffle() {
        currentCard = 0; 

        for (int first = 0; first < deck.length; first++) {
            int second = randomNumbers.nextInt(NUMBER_OF_CARDS);

            // Permutação simples (swap)
            Card temp = deck[first];
            deck[first] = deck[second];
            deck[second] = temp;
        }
    }

    // Distribui uma carta por vez [cite: 139]
    public Card dealCard() {
        if (currentCard < deck.length) {
            return deck[currentCard++]; 
        } else {
            return null; 
        }
    }
}