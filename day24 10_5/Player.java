package poker;

import java.util.ArrayList;
import java.util.List;

public class Player {
    public List<Card> cardList = new ArrayList<>();
    public String name;

    public Player(String name) {
        this.name = name;
    }
}
