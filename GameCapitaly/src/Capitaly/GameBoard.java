package Capitaly;

import java.util.*;
import Capitaly.fields.*;
import Capitaly.players.*;
public class GameBoard {
    private Field[] fields;
    private ArrayList<Player> players;

    public GameBoard(Field... fields) {
        this.fields = (Field[]) fields;
    }
    /**
     * Adds a new field to the game board.
     *
     * param newField The field to be added to the game board.
     */
    public void addField(Field newField) {
        int totalFields = fields.length + 1;

        Field[] updatedFields = new Field[totalFields];

        System.arraycopy(fields, 0, updatedFields, 0, fields.length);

        updatedFields[fields.length] = newField;

        fields = updatedFields;
    }
    /**
     * Starts the Capitaly game with the specified players and rules.
     *
     * param in_players The array of players participating in the game.
     * param k          The number of game rounds to play.
     * param rls        The array of dice roll values for each round.
     * return An array of players who won the game.
     */
    public Player[] startGame(Player[] in_players, int k, int rls[]) {
        if (in_players.length < 1 || this.fields.length < 1) {
            return null;
        }
        this.players = new ArrayList<>();
        Collections.addAll(this.players, in_players);


        Stack<Player> winners = new Stack<>();

        int n = 0;
        int n1 = 0;

        while (n < k) {
            ArrayList<Player> winnersToRem = new ArrayList<>();

            for (Player player : this.players) {

                if (player.isLost()) {
                    winnersToRem.add(player);
                    winners.push(player);
                    continue;
                }

                int diceVal = rls[n1];
                Capitaly.printData(diceVal, player + " roll ", 0);
                player.Moving(diceVal);
                Field playerField = fields[getPlayerPos(player)];
                Capitaly.printData(playerField + " position: " + getPlayerPos(player) , player + " on ", 0);
                playerField.FieldAct(player);
                n1++;
            }

            Capitaly.gamePromotion += "\n";

            //winnersToRem.clear();
            n++;
        }

        Player[] out = new Player[winners.size()];
        for (int i = 0; i < out.length; i++) {
            out[i] = winners.pop();
        }
        return out;
    }

    /**
     * Get the position of a player on the game board.
     *
     * param player The player whose position is to be determined.
     * return The player's position on the game board.
     */
    private int getPlayerPos(Player player) {
        return player.getPosition() % this.fields.length;
    }
}
