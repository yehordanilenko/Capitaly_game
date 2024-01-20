package Capitaly.fields;

import Capitaly.Capitaly;
import Capitaly.players.Player;


public class Field_lucky extends Field {

    /**
     * Constructor for Field_lucky.
     *
     * param price The price of the Lucky field.
     */
    public Field_lucky(int price) {
        super();
        this.price = price;
    }

    /**
     * Perform the action associated with the Lucky field when a player lands on it.
     *
     * param player The player who landed on the Lucky field.
     */
    @Override
    public void FieldAct(Player player) {
        Capitaly.printData(this.price, player + " roll ", 1);
        player.getPayment(this.price);
    }
    /**
     * Get a string representation of the Lucky field.
     *
     * return A string representation of the Lucky field.
     */
    @Override
    public String toString() {
        return "Field Lucky";
    }
}
