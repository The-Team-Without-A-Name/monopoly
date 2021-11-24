package library;

import lombok.Getter;

public class CardsHandler {
    private final int DECK_SIZE = 16; //16 cards in either type of deck
    private final Deck deck; //store deck of cards

    @Getter
    private Card.CardType type;

    public CardsHandler(Card.CardType type, Deck deck) {
        this.deck = deck;
        if (type != Card.CardType.COMMUNITY && type != Card.CardType.CHANCE)
            throw new IllegalArgumentException("Card type invalid!");
        if (type == Card.CardType.CHANCE)
            chance();
        else
            community();

        this.type = type;
    }

    //create deck of community chest cards
    private void community() {
        Card[] cards = new Card[DECK_SIZE];

        for (int i = 0; i < DECK_SIZE; i++)
            cards[i] = new Card(Card.CardType.COMMUNITY, i);

        deck.initializeCard(cards);
    }

    //create deck of chance cards
    private void chance() {
        Card[] cards = new Card[DECK_SIZE];

        for (int i = 0; i < DECK_SIZE; i++)
            cards[i] = new Card(Card.CardType.CHANCE, i);

        deck.initializeCard(cards);
    }

    //draw next card
    public Card draw() {
        return deck.drawCard();
    }
}
