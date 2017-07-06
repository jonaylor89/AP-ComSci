package BlackJack;

class Card {

    private String suit;
    private int value;

    Card(int value, String suit){

        this.value = value;
        this.suit = suit;

    }

    String getSuit() {
        return suit;
    }

    int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Card{" +
                "suit='" + suit + '\'' +
                ", value=" + value +
                '}';
    }
}
