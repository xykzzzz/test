package poker;

import java.util.Objects;

public class Card {
    public String suit;     // 花色
    public int rank;        // 分值
    public Card(String suit, int rank) {
        this.suit = suit;
        this.rank = rank;
    }

    @Override
    public String toString() {
        return String.format("[%s %d]", suit, rank);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof  Card)) return false;
        Card card = (Card) o;
        return rank == card.rank && suit.equals(card.suit);
    }
}
