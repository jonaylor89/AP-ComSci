package BlackJack;

import java.util.ArrayList;

class Player implements Comparable<Player>{

    boolean alive;
    boolean lost;
    int total;
    int distanceFromGoal;

    ArrayList<Card> hand;

    Player(){
        super();
        alive = true;
        lost = false;

        hand = new ArrayList<Card>();
    }

    String show_to_self() {
        return total + " : " + hand;
    }

    String show() {
        if(lost) {
            return hand.get(0) + " and " + (hand.size()-1) + " more cards";
        }
        else {
            return total + " : " + hand;
        }
    }

    void update(){
        int temp = 0;

        for (Card c: hand) {
            temp += c.getValue();
        }

        total = temp;
    }

    @Override
    public int compareTo(Player p) {
        int compareDistance = ((Player) p).distanceFromGoal;


        return this.distanceFromGoal - compareDistance;
    }
}
