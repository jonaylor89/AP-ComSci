package BlackJack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Dealer {

    final private String[] suits = {"Diamonds", "Hearts", "Clubs", "Spades"};
    final private int cardsPerSuit = 13;
    final private int goal = 21;

    private ArrayList<Card> deck;
    private ArrayList<Player> possibleWinners;
    private Player[] players;

    private Scanner userInput;

    Dealer(int numberOfPlayers){

        deck = new ArrayList<>();
        possibleWinners = new ArrayList<>();
        players = new Player[numberOfPlayers];
        userInput = new Scanner(System.in);

        for (int i = 0; i < players.length; i++) {
            players[i] = new Player();
        }
    }

    private void createDeck(){
        for (int i = 0; i < suits.length; i++) {
            for (int j = 0; j < cardsPerSuit; j++) {
                deck.add(new Card(j+1, suits[i]));
            }
        }
    }


    private void dealCard(Player player, int numberOfCards){
        for(int i = 0; i < numberOfCards; i++) {
            player.hand.add(deck.get(0));
            deck.remove(0);

        }
    }

    private void responseHandler(String response, Player player, int index){

        if(response.equals("s")) {
            player.alive = false;
        }
        else if(response.equals("c")){
            dealCard(player, 1);
            System.out.println(player.hand.get(player.hand.size()-1));
            player.update();
        }
        else if(response.equals("l")){
            System.out.println(player.show_to_self());
            System.out.println("Player " + (index+1) + ": \'s\' to stop, \'c\' to continue, and \'l\' to look at your hand:");
            String newResponse = userInput.next();
            responseHandler(newResponse, player, index);
        }
        else{
            System.out.println("Not a valid response");
            System.out.println("Player " + (index+1) + ": \'s\' to stop, \'c\' to continue, and \'l\' to look at your hand:");
            String newResponse = userInput.next();
            responseHandler(newResponse, player, index);
        }
    }

    private String finalScoreHandler(Player player){

        if(player.lost){
            return "**lost** " + player.total;
        }

        Collections.sort(possibleWinners);

        if(player == possibleWinners.get(0)){
            return "**Winner** " + player.total;
        }

        else{
            return "" + player.total;
        }
    }

    void start(){
        createDeck();
        Collections.shuffle(deck);

        for(Player p : players){
            dealCard(p, 2);
            p.update();
        }

        while(true) {

            int playersAlive = players.length;

            for (int i = 0; i < players.length; i++) {
                System.out.println("Player " + (i+1) + ": " + deck.get(0) + " and " + (players[i].hand.size()-1) + " cards hidden");
            }

            for (int i = 0; i < players.length; i++) {

                if (players[i].alive) {

                    System.out.println("Player " + (i + 1) + ": \'s\' to stop, \'c\' to continue, and \'l\' to look at your hand:");
                    String response = userInput.next();

                    responseHandler(response, players[i], i);
                }

                if (players[i].total > goal) {
                    players[i].alive = false;
                    players[i].lost = true;
                    System.out.println("Player " + (i+1) + " is out of the game");
                }

                if (!players[i].alive) {
                    playersAlive -= 1;
                }
            }

            if (playersAlive == 0) {
                break;
            }

        }

        for(Player p : players) {
            if (!p.lost) {
                p.distanceFromGoal = goal - p.total;
                possibleWinners.add(p);
            }
        }

        for(int i = 0; i < players.length; i++) {
            System.out.println("Player " + (i+1) + ": " + finalScoreHandler(players[i]));
        }

    }

}
